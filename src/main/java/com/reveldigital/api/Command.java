package com.reveldigital.api;

/**
 * Created by Mike on 6/5/2014.
 */
public class Command {

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
