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
package org.overlord.sramp;

/**
 * Some S-RAMP constants.
 *
 * @author eric.wittmann@redhat.com
 */
public class SrampConstants {

    public static final String DATE_FORMAT  = "EEE, d MMM yyyy HH:mm:ss Z";
    
	public static final String SRAMP_NS     = "http://s-ramp.org/xmlns/2010/s-ramp";
	public static final String SRAMP_PREFIX = "s-ramp";
	
	public static final String SRAMP_CONTENT_SIZE        = SRAMP_PREFIX + "contentSize";
    public static final String SRAMP_CONTENT_TYPE        = SRAMP_PREFIX + "contentType";

    //Configuration constants
    public static final String SRAMP_CONFIG_FILE_NAME     = "sramp.config.file.name";
    public static final String SRAMP_CONFIG_FILE_REFRESH  = "sramp.config.file.refresh";
    public static final String SRAMP_CONFIG_BASEURL       = "sramp.config.baseurl";
}
