package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Mike on 6/4/2014.
 */
public class PingData implements Serializable {

    @SerializedName("player_version")
    private String playerVersion;
    @SerializedName("cpu_usage")
    private double cpuUsage;
    @SerializedName("memory_usage")
    private double memoryUsage;
    @SerializedName("disk_usage")
    private double diskUsage;
    @SerializedName("mac_address")
    private String macAddress;
    private byte[] snap;

    public String getPlayerVersion() {
        return playerVersion;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public double getMemoryUsage() {
        return memoryUsage;
    }

    public double getDiskUsage() {
        return diskUsage;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public byte[] getSnap() {
        return snap;
    }
}
