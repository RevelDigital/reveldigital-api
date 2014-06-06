package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mike on 6/4/2014.
 */
public class RequestError {

    @SerializedName("statuscode")
    private String statusCode;

    private String description;

    public String getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }
}
