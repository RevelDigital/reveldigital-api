package com.reveldigital.api.client;

import com.reveldigital.api.RequestError;

import java.io.IOException;

/**
 * Created by Mike on 5/19/2014.
 */
public class RequestException extends IOException {

    public final String statusMessage;
    public final int statusCode;

    public RequestException(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public RequestException(String statusMessage) {
        this.statusCode = 0;
        this.statusMessage = statusMessage;
    }

    public RequestException(int statusCode, RequestError error) {
        this.statusCode = statusCode;
        this.statusMessage = error.getDescription();
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
