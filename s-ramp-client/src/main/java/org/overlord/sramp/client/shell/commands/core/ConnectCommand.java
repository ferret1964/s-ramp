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
package org.overlord.sramp.client.shell.commands.core;

import javax.xml.namespace.QName;

import org.overlord.sramp.client.SrampAtomApiClient;
import org.overlord.sramp.client.shell.AbstractShellCommand;
import org.overlord.sramp.client.shell.ShellContext;

/**
 * Connects to an s-ramp server.
 *
 * @author eric.wittmann@redhat.com
 */
public class ConnectCommand extends AbstractShellCommand {

	/**
	 * Constructor.
	 */
	public ConnectCommand() {
	}

	/**
	 * @see org.overlord.sramp.client.shell.ShellCommand#printUsage()
	 */
	@Override
	public void printUsage() {
		System.out.println("s-ramp:connect <endpointUrl>");
	}

	/**
	 * @see org.overlord.sramp.client.shell.ShellCommand#execute(org.overlord.sramp.client.shell.ShellContext)
	 */
	@Override
	public void execute(ShellContext context) throws Exception {
		String endpointUrlArg = this.requiredArgument(0, "Please specify a valid s-ramp URL.");
		QName varName = new QName("s-ramp", "client");
		SrampAtomApiClient client = new SrampAtomApiClient(endpointUrlArg);
		context.setVariable(varName, client);
		System.out.println("Connected to endpoint: " + endpointUrlArg);
	}

}