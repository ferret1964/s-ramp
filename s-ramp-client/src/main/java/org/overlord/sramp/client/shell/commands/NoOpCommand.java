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
package org.overlord.sramp.client.shell.commands;

import org.overlord.sramp.client.shell.AbstractShellCommand;

/**
 * The command about nothing.  The Seinfeld command.
 *
 * @author eric.wittmann@redhat.com
 */
public class NoOpCommand extends AbstractShellCommand {

	/**
	 * Constructor.
	 */
	public NoOpCommand() {
	}

	/**
	 * @see org.overlord.sramp.client.shell.ShellCommand#printUsage()
	 */
	@Override
	public void printUsage() {
	}

	/**
	 * @see org.overlord.sramp.client.shell.ShellCommand#printHelp()
	 */
	@Override
	public void printHelp() {
	}

	/**
	 * @see org.overlord.sramp.client.shell.ShellCommand#execute()
	 */
	@Override
	public void execute() {
	}

}
