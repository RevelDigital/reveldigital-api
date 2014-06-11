package com.reveldigital.api;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Mike on 6/4/2014.
 */
public class Account {

    private String name;
    @SerializedName("business_name")
    private String businessName;
    @SerializedName("address_1")
    private String address1;
    @SerializedName("address_2")
    private String address2;
    private String city;
    private String state;
    @SerializedName("postal_code")
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    @SerializedName("primary_contact_id")
    private String primaryContactId;
    @SerializedName("secondary_contact_id")
    private String secondaryContactId;
    @SerializedName("created_on")
    private Date createdOn;
    private String timezone;

    public String getName() {
        return name;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
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

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getPrimaryContactId() {
        return primaryContactId;
    }

    public String getSecondaryContactId() {
        return secondaryContactId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getTimezone() {
        return timezone;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public Account setBusinessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    public Account setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public Account setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public Account setCity(String city) {
        this.city = city;
        return this;
    }

    public Account setState(String state) {
        this.state = state;
        return this;
    }

    public Account setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Account setCountry(String country) {
        this.country = country;
        return this;
    }

    public Account setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Account setFax(String fax) {
        this.fax = fax;
        return this;
    }

    public Account setPrimaryContactId(String primaryContactId) {
        this.primaryContactId = primaryContactId;
        return this;
    }

    public Account setSecondaryContactId(String secondaryContactId) {
        this.secondaryContactId = secondaryContactId;
        return this;
    }

    public Account setTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }
}
