package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Mike on 6/5/2014.
 */
public class User {

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
    private String role;
    @SerializedName("user_name")
    protected String userName;
    @SerializedName("last_activity")
    private Date lastActivity;

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

    public String getRole() {
        return role;
    }

    public String getUserName() {
        return userName;
    }

    public Date getLastActivity() {
        return lastActivity;
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

    public User setRole(String role) {
        this.role = role;
        return this;
    }
}
