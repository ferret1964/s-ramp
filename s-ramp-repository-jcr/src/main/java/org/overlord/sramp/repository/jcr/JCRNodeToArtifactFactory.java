/*
 * Copyright 2012 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.overlord.sramp.repository.jcr;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.Session;
import javax.jcr.Value;

import org.overlord.sramp.ArtifactType;
import org.overlord.sramp.SrampException;
import org.overlord.sramp.SrampServerException;
import org.overlord.sramp.repository.jcr.mapper.JCRNodeToArtifactVisitor;
import org.overlord.sramp.repository.jcr.mapper.JCRNodeToArtifactVisitor.JCRReferenceResolver;
import org.overlord.sramp.visitors.ArtifactVisitor;
import org.overlord.sramp.visitors.ArtifactVisitorHelper;
import org.s_ramp.xmlns._2010.s_ramp.BaseArtifactType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple visitor that will create an S-RAMP artifact from a
 *
 * @author eric.wittmann@redhat.com
 */
public final class JCRNodeToArtifactFactory {

    private static Logger log = LoggerFactory.getLogger(JCRRepository.class);

	/**
	 * Private constructor.
	 */
	private JCRNodeToArtifactFactory() {
	}

	/**
	 * Creates a S-RAMP artifact from the given JCR node.
	 * @param jcrNode a JCR node
	 */
	public static BaseArtifactType createArtifact(final Session session, Node jcrNode) {
        try {
			String artifactType = jcrNode.getProperty(JCRConstants.SRAMP_ARTIFACT_TYPE).getValue().getString();
			return createArtifact(session, jcrNode, ArtifactType.valueOf(artifactType));
		} catch (PathNotFoundException e) {
			throw new RuntimeException("JCR Node does not seem to be an s-ramp artifact node.", e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Creates a S-RAMP artifact from the given JCR node.
	 * @param jcrNode a node in the JCR repo
	 * @param artifactType the type of artifact represented by the {@link Node}
	 * @return S-RAMP artifact
	 * @throws SrampException
	 */
    public static BaseArtifactType createArtifact(final Session session, Node jcrNode,
            ArtifactType artifactType) throws SrampException {
		try {
			Class<?> artifactClass = artifactType.getArtifactType().getTypeClass();
			BaseArtifactType artifact = (BaseArtifactType) artifactClass.newInstance();
			ArtifactVisitor visitor = new JCRNodeToArtifactVisitor(jcrNode, new JCRReferenceResolver() {
				@Override
				public String resolveReference(Value reference) {
					try {
						String ident = reference.getString();
						Node node = session.getNodeByIdentifier(ident);
						return node.getProperty("sramp:uuid").getString();
					} catch (Exception e) {
						log.debug("Error resolving JCR reference.", e);
					}
					return null;
				}
			});
			ArtifactVisitorHelper.visitArtifact(visitor, artifact);
			return artifact;
		} catch (InstantiationException e) {
			throw new SrampServerException(e);
		} catch (IllegalAccessException e) {
			throw new SrampServerException(e);
		} catch (RuntimeException e) {
			if (e.getCause() != null) {
				throw new SrampServerException(e.getCause());
			} else {
				throw new SrampServerException(e);
			}
		}
	}

}
