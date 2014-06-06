package com.reveldigital.api.client;

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
    String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"; //$NON-NLS-1$

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