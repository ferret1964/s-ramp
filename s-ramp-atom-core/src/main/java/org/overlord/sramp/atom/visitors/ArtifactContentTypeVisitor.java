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
package org.overlord.sramp.atom.visitors;

import javax.xml.namespace.QName;

import org.overlord.sramp.SrampConstants;
import org.overlord.sramp.atom.MediaType;
import org.overlord.sramp.visitors.HierarchicalArtifactVisitorAdapter;
import org.s_ramp.xmlns._2010.s_ramp.BaseArtifactType;
import org.s_ramp.xmlns._2010.s_ramp.DocumentArtifactType;
import org.s_ramp.xmlns._2010.s_ramp.UserDefinedArtifactType;
import org.s_ramp.xmlns._2010.s_ramp.XmlDocument;

/**
 * A simple artifact visitor that determines the content type of an S-RAMP
 * artifact.
 *
 * @author eric.wittmann@redhat.com
 */
public class ArtifactContentTypeVisitor extends HierarchicalArtifactVisitorAdapter {

	private javax.ws.rs.core.MediaType contentType;

	/**
	 * Default constructor.
	 */
	public ArtifactContentTypeVisitor() {
	}

	/**
	 * @see org.overlord.sramp.visitors.HierarchicalArtifactVisitorAdapter#visitBase(org.s_ramp.xmlns._2010.s_ramp.BaseArtifactType)
	 */
	@Override
	protected void visitBase(BaseArtifactType artifact) {
		setContentType(MediaType.APPLICATION_OCTET_STREAM_TYPE);
	}

	/**
	 * @see org.overlord.sramp.visitors.HierarchicalArtifactVisitorAdapter#visitDocument(org.s_ramp.xmlns._2010.s_ramp.DocumentArtifactType)
	 */
	@Override
	protected void visitDocument(DocumentArtifactType artifact) {
		if (artifact.getContentType() != null)
			setContentType(MediaType.valueOf(artifact.getContentType()));
	}

	/**
	 * @see org.overlord.sramp.visitors.HierarchicalArtifactVisitorAdapter#visitXmlDocument(org.s_ramp.xmlns._2010.s_ramp.XmlDocument)
	 */
	@Override
	protected void visitXmlDocument(XmlDocument artifact) {
		setContentType(MediaType.APPLICATION_XML_TYPE);
	}
	
	/**
	 * org.overlord.sramp.visitors.HierarchicalArtifactVisitorAdapter#visitUserDefined(org.s_ramp.xmlns._2010.s_ramp.UserDefinedArtifactType)
	 */
	@Override
	protected void visitUserDefined(UserDefinedArtifactType artifact) {
	    //grab the content type from an any-attribute
	    if ((artifact.getOtherAttributes().keySet().contains(new QName(SrampConstants.SRAMP_CONTENT_TYPE)))) {
	        String contentTypeStr = artifact.getOtherAttributes().get(new QName(SrampConstants.SRAMP_CONTENT_TYPE));
	        setContentType(MediaType.valueOf(contentTypeStr));
	    } else {
	        setContentType(MediaType.APPLICATION_OCTET_STREAM_TYPE);
	    }
	}

	/**
	 * @return the contentType
	 */
	public javax.ws.rs.core.MediaType getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(javax.ws.rs.core.MediaType contentType) {
		this.contentType = contentType;
	}

}
