package com.models;

public class Referee {
    private String name;
    private String profession;
    private String phoneNumber;
    private Address address;

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public Referee(String name, String profession, String phoneNumber, Address address) {
        this.name = name;
        this.profession = profession;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    private Contact contact;
}
