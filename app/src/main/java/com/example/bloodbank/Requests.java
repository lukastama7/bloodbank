package com.example.bloodbank;

public class Requests {

    private String ID, FirstName, LastName, Date_Of_Birth, Blood_Type, Gender, Address, MobileNo,LocationToDonate, MessageRequest;

    public Requests() {
    }

    public Requests(String ID, String firstName, String lastName, String date_Of_Birth, String blood_Type, String gender, String address, String mobileNo, String locationToDonate, String messageRequest) {
        this.ID = ID;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Date_Of_Birth = date_Of_Birth;
        this.Blood_Type = blood_Type;
        this.Gender = gender;
        this.Address = address;
        this.MobileNo = mobileNo;
        this.LocationToDonate = locationToDonate;
        this.MessageRequest = messageRequest;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDate_Of_Birth() {
        return Date_Of_Birth;
    }

    public void setDate_Of_Birth(String date_Of_Birth) {
        Date_Of_Birth = date_Of_Birth;
    }

    public String getBlood_Type() {
        return Blood_Type;
    }

    public void setBlood_Type(String blood_Type) {
        Blood_Type = blood_Type;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getLocationToDonate() {
        return LocationToDonate;
    }

    public void setLocationToDonate(String locationToDonate) {
        LocationToDonate = locationToDonate;
    }

    public String getMessageRequest() {
        return MessageRequest;
    }

    public void setMessageRequest(String messageRequest) {
        MessageRequest = messageRequest;
    }
}
