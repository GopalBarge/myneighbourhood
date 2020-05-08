package com.bs.myneighbourhood.api.dto;

public class Address {
    String address;
    String city;
    String pinCde;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCde() {
        return pinCde;
    }

    public void setPinCde(String pinCde) {
        this.pinCde = pinCde;
    }
}
