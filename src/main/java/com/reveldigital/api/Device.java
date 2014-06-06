package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Mike on 6/4/2014.
 */
public class Device {

    private String id;
    private String name;
    @SerializedName("group_name")
    private String groupName;
    @SerializedName("group_id")
    private String groupId;
    private String tags;
    @SerializedName("entered_service")
    private Date enteredService;
    @SerializedName("last_service")
    private Date lastService;
    private String timezone;
    @SerializedName("last_update")
    private Date lastUpdate;
    private Location location;
    @SerializedName("registration_key")
    private String registrationKey;
    @SerializedName("mac_address")
    private String macAddress;
    @SerializedName("ping_data")
    private PingData pingData;
    private Beacon beacon;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getTags() {
        return tags;
    }

    public Date getEnteredService() {
        return enteredService;
    }

    public Date getLastService() {
        return lastService;
    }

    public String getTimezone() {
        return timezone;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Location getLocation() {
        return location;
    }

    public String getRegistrationKey() {
        return registrationKey;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public PingData getPingData() {
        return pingData;
    }

    public Beacon getBeacon() {
        return beacon;
    }

    public Device setName(String name) {
        this.name = name;
        return this;
    }

    public Device setGroupId(String groupId) {
        this.groupId = groupId;
        return this;
    }

    public Device setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public Device setLastService(Date lastService) {
        this.lastService = lastService;
        return this;
    }

    public Device setTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    public Device setLocation(Location location) {
        this.location = location;
        return this;
    }

    public Device setBeacon(Beacon beacon) {
        this.beacon = beacon;
        return this;
    }
}
