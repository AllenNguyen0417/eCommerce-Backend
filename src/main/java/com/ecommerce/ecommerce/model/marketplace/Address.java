package com.ecommerce.ecommerce.model.marketplace;

import javax.persistence.*;

@Table(name="addresses")
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private Integer userId;
    private String recipientName;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Address(Integer addressId, Integer userId, String recipientName, String street, String city, String state, String zip) {
        this.addressId = addressId;
        this.userId = userId;
        this.recipientName = recipientName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Address() {}

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", userId='" + userId + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
