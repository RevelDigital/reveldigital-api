package com.reveldigital.api.client;

import java.net.HttpURLConnection;

/**
 * RevelDigital API response class that provides the parsed response body as well as
 * any links to the first, previous, next, and last responses.
 */
public class RevelResponse {

    /**
     * HTTP response
     */
    protected final HttpURLConnection response;

    /**
     * Response body
     */
    protected final Object body;

//    /**
//     * Links to other pages
//     */
//    protected PageLinks links;

    /**
     * Create response
     *
     * @param response
     * @param body
     */
    public RevelResponse(HttpURLConnection response, Object body) {
        this.response = response;
        this.body = body;
    }

    /**
     * Get header value
     *
     * @param name
     * @return value
     */
    public String getHeader(String name) {
        return response.getHeaderField(name);
    }

//    /**
//     * Get link uri to first page
//     *
//     * @return possibly null uri
//     */
//    public String getFirst() {
//        return getLinks().getFirst();
//    }
//
//    /**
//     * Get link uri to previous page
//     *
//     * @return possibly null uri
//     */
//    public String getPrevious() {
//        return getLinks().getPrev();
//    }
//
//    /**
//     * Get link uri to next page
//     *
//     * @return possibly null uri
//     */
//    public String getNext() {
//        return getLinks().getNext();
//    }
//
//    /**
//     * Get link uri to last page
//     *
//     * @return possibly null uri
//     */
//    public String getLast() {
//        return getLinks().getLast();
//    }

    /**
     * Parsed response body
     *
     * @return body
     */
    public Object getBody() {
        return body;
    }
}