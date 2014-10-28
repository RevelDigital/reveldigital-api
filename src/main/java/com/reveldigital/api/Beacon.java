package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mike on 6/5/2014.
 */
public class Beacon implements Serializable {

    @SerializedName("distance")
    private double distance;
    @SerializedName("calibration")
    private double calibration;
    @SerializedName("rating")
    private int rating;
    private String website;
    private String phone;
    private String email;
    List<String> devices;
    private String uuid;
    private String major;
    private String minor;

    public double getDistance() {
        return distance;
    }

    public double getCalibration() {
        return calibration;
    }

    public int getRating() {
        return rating;
    }

    public String getWebsite() {
        return website;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getDevices() {
        return devices;
    }

    public String getMinor() {
        return minor;
    }

    public String getMajor() {
        return major;
    }

    public String getUuid() {
        return uuid;
    }

    public Beacon setDistance(double distance) {
        this.distance = distance;
        return this;
    }

    public Beacon setCalibration(double calibration) {
        this.calibration = calibration;
        return this;
    }

    public Beacon setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public Beacon setWebsite(String website) {
        this.website = website;
        return this;
    }

    public Beacon setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Beacon setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * List of device Ids to correspond with this beacon
     *
     * @param devices
     * @return
     */
    public Beacon setDevices(List<String> devices) {
        this.devices = devices;
        return this;
    }

    public Beacon setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public Beacon setMajor(String major) {
        this.major = major;
        return this;
    }

    public Beacon setMinor(String minor) {
        this.minor = minor;
        return this;
    }
}
