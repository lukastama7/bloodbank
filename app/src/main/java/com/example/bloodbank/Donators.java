package com.example.bloodbank;

import java.util.Date;

public class Donators {

    private String ID, USER_ID, Full_Name, Gender, Blood_Type, Email, Date_Donate, MobileNo, Address;

    public Donators() {
    }

    public Donators(String ID, String USER_ID, String full_Name, String gender, String blood_Type, String email, String date_Donate, String mobileNo, String address) {
        this.ID = ID;
        this.USER_ID = USER_ID;
        this.Full_Name = full_Name;
        this.Gender = gender;
        this.Blood_Type = blood_Type;
        this.Email = email;
        this.Date_Donate = date_Donate;
        this.MobileNo = mobileNo;
        this.Address = address;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String full_Name) {
        Full_Name = full_Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getBlood_Type() {
        return Blood_Type;
    }

    public void setBlood_Type(String blood_Type) {
        Blood_Type = blood_Type;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDate_Donate() {
        return Date_Donate;
    }

    public void setDate_Donate(String date_Donate) {
        Date_Donate = date_Donate;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
