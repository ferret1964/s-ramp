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
package org.overlord.sramp.governance;

/**
 * Some Governance constants.
 *
 */
public interface GovernanceConstants {

    //Configuration constants
    public static final String GOVERNANCE_FILE_NAME     = "governance.file.name";
    public static final String GOVERNANCE_FILE_REFRESH  = "governance.file.refresh";
    public static final String SRAMP_REPO_URL           = "sramp.repo.url";
    
    //JBPM connection info
    public static final String GOVERNANCE_JBPM_USER     = "governance.jbpm.user";
    public static final String GOVERNANCE_JBPM_PASSWORD = "governance.jbpm.password";
    public static final String GOVERNANCE_JBPM_URL      = "governance.jbpm.url";
    
    //governance.targets
    public static final String GOVERNANCE_TARGETS       = "governance.targets";
    public static final String GOVERNANCE_WORKFLOWS     = "governance.workflows";
}
