/*
 * Copyright (c) 2016. Catalyst LLC. All right reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

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
    @SerializedName("ip_address")
    private String ipAddress;
    private Date timestamp;

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

    public String getIpAddress() {
        return ipAddress;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}
