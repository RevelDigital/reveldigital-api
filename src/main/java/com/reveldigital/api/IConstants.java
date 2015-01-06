/*
 * Copyright (c) 2015. Catalyst LLC. All right reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.reveldigital.api;

/**
 * RevelDigital constants
 */
public interface IConstants {

    /** */
    String CHARSET_UTF8 = "UTF-8"; //$NON-NLS-1$
    /** */
    String CHARSET_ISO_8859_1 = "ISO-8859-1"; //$NON-NLS-1$
    /** */
    String CONTENT_TYPE_JSON = "application/json"; //$NON-NLS-1$
    /** */
    String CONTENT_TYPE_STREAM = "application/octet-stream";

    /** */
    String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ"; //$NON-NLS-1$

    /** */
    String HOST_API = "api.reveldigital.com"; //$NON-NLS-1$
    /** */
    String HOST_DEFAULT = "reveldigital.com"; //$NON-NLS-1$

    /** */
    String PARAM_PAGE = "page"; //$NON-NLS-1$
    /** */
    String PARAM_PER_PAGE = "take"; //$NON-NLS-1$

    /** */
    String PROTOCOL_HTTPS = "https"; //$NON-NLS-1$

    /** */
    String SEGMENT_ACCOUNT = "/account"; //$NON-NLS-1$
    /** */
    String SEGMENT_DEVICES = "/devices"; //$NON-NLS-1$

    String SEGMENT_COMMANDS = "/commands";

    String SEGMENT_MEDIA = "/media";

    String SEGMENT_PLAYLISTS = "/playlists";

    String SEGMENT_SCHEDULES = "/schedules";

    String SEGMENT_TEMPLATES = "/templates";

    String SEGMENT_USERS = "/users";

    /** */
    String URL_API = PROTOCOL_HTTPS + "://" + HOST_API; //$NON-NLS-1$
}