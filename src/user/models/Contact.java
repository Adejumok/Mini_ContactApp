package com.models;

import java.util.List;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String sex;
    private String dob;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public String getDob() {
        return dob;
    }

    public Contact(String firstName, String lastName, String phoneNumber, String sex, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.dob = dob;
    }

}
