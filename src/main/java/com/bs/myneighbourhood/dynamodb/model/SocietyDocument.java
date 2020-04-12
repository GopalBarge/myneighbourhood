package com.bs.myneighbourhood.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "society")
public class SocietyDocument {

    Integer id;
   private String name;
    String contactNumber;
    String contactPerson;
    String address;
    private String city;
    String pinCode;

    public SocietyDocument() {
    }

    public SocietyDocument(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @DynamoDBHashKey
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @DynamoDBRangeKey
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
@DynamoDBAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @DynamoDBAttribute
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}