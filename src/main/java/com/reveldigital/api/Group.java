package com.reveldigital.api;

import java.io.Serializable;

/**
 * Created by Mike on 12/15/2016.
 */
public class Group implements Serializable {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
