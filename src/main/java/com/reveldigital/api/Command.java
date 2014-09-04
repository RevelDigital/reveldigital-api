package com.reveldigital.api;

import java.io.Serializable;

/**
 * Created by Mike on 6/5/2014.
 */
public class Command implements Serializable {

    private String name;
    private String arg;

    public String getName() {
        return name;
    }

    public Command setName(String name) {
        this.name = name;
        return this;
    }

    public String getArg() {
        return arg;
    }

    public Command setArg(String arg) {
        this.arg = arg;
        return this;
    }
}
