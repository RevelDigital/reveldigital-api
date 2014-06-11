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

    public String getType() {
        return type;
    }

    public int getOperator() {
        return operator;
    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }

    public String getValue3() {
        return value3;
    }

    public String getValue4() {
        return value4;
    }
}
