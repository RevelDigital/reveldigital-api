/*
 * Copyright (c) 2015. Catalyst LLC. All right reserved.
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

/**
 * Created by Mike on 6/4/2014.
 */
public class Location implements Serializable {

    private String city;
    private String state;
    private String county;
    private String country;
    @SerializedName("postal_code")
    private String postalCode;
    private String address;
    private double latitude;
    private double longitude;

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCounty() {
        return county;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Location setCity(String city) {
        this.city = city;
        return this;
    }

    public Location setState(String state) {
        this.state = state;
        return this;
    }

    public Location setCounty(String county) {
        this.county = county;
        return this;
    }

    public Location setCountry(String country) {
        this.country = country;
        return this;
    }

    public Location setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Location setAddress(String address) {
        this.address = address;
        return this;
    }

    public Location setLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Location setLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }
}
