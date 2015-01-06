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
import java.util.Date;
import java.util.List;

/**
 * Created by Mike on 6/5/2014.
 */
public class User implements Serializable {

    private String id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    private String city;
    private String state;
    @SerializedName("postal_code")
    private String postalCode;
    private String country;
    @SerializedName("home_phone")
    private String homePhone;
    @SerializedName("work_phone")
    private String workPhone;
    @SerializedName("mobile_phone")
    private String mobilePhone;
    @SerializedName("created_on")
    private Date createdOn;
    private String email;
    @SerializedName("role")
    private List<String> roles;
    @SerializedName("user_name")
    protected String userName;
    @SerializedName("last_activity")
    private Date lastActivity;
    @SerializedName("password")
    private String password;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getUserName() {
        return userName;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public String getPassword() {
        return password;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }

    public User setState(String state) {
        this.state = state;
        return this;
    }

    public User setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public User setCountry(String country) {
        this.country = country;
        return this;
    }

    public User setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public User setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public User setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public User setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
