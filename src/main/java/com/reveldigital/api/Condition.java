package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mike on 6/5/2014.
 */
public class Condition {

    private String type;
    private int operator;
    @SerializedName("value_1")
    private String value1;
    @SerializedName("value_2")
    private String value2;
    @SerializedName("value_3")
    private String value3;
    @SerializedName("value_4")
    private String value4;
}
