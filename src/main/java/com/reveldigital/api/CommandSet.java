package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mike on 11/9/2016.
 */
public class CommandSet implements Serializable {

    private String device_id;
    private List<Command> commands;

    public String getDeviceId() {
        return device_id;
    }

    public CommandSet setDeviceId(String deviceId) {
        this.device_id = deviceId;
        return this;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public CommandSet setCommands(List<Command> commands) {
        this.commands = commands;
        return this;
    }
}
