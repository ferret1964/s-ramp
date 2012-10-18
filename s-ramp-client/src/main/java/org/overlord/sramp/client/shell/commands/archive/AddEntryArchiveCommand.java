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
package org.overlord.sramp.client.shell.commands.archive;

import java.io.File;
import java.io.InputStream;

import javax.xml.namespace.QName;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.overlord.sramp.ArtifactType;
import org.overlord.sramp.atom.archive.SrampArchive;
import org.overlord.sramp.client.shell.AbstractShellCommand;
import org.overlord.sramp.client.shell.ShellContext;
import org.s_ramp.xmlns._2010.s_ramp.BaseArtifactType;

/**
 * Adds an entry to the current S-RAMP batch archive.
 *
 * @author eric.wittmann@redhat.com
 */
public class AddEntryArchiveCommand extends AbstractShellCommand {

	/**
	 * Constructor.
	 */
	public AddEntryArchiveCommand() {
	}

	/**
	 * @see org.overlord.sramp.client.shell.ShellCommand#printUsage()
	 */
	@Override
	public void printUsage() {
		System.out.println("archive:addEntry <archivePath> <srampArtifactType> [<pathToFileContent>]");
	}

	/**
	 * @see org.overlord.sramp.client.shell.ShellCommand#execute(org.overlord.sramp.client.shell.ShellContext)
	 */
	@Override
	public void execute(ShellContext context) throws Exception {
		String archivePathArg = requiredArgument(0, "Please include an entry path (relative archive path).");
		String artifactTypeArg = requiredArgument(1, "Please include an entry path (relative archive path).");
		String pathToContent = optionalArgument(2);

		QName varName = new QName("archive", "active-archive");
		SrampArchive archive = (SrampArchive) context.getVariable(varName);

		if (archive == null) {
			System.out.println("No S-RAMP archive is currently open.");
		} else {
			InputStream contentStream = null;
			try {
				ArtifactType type = ArtifactType.valueOf(artifactTypeArg);
				String name = new File(archivePathArg).getName();
				if (pathToContent != null) {
					File contentFile = new File(pathToContent);
					contentStream = FileUtils.openInputStream(contentFile);
				}
				BaseArtifactType artifact = type.newArtifactInstance();
				artifact.setName(name);
				archive.addEntry(archivePathArg, artifact, contentStream);
				System.out.println("Entry added to S-RAMP archive:  " + archivePathArg);
			} finally {
				IOUtils.closeQuietly(contentStream);
			}
		}
	}

}