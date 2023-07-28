package user.models;

import java.util.List;

public class Contact {
    private Integer id;
    private String firstName;
    private String lastName;

    public void setId(Integer id) {
        this.id = id;
    }

    private String phoneNumber;
    private String sex;
    private String dob;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sex='" + sex + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }

    public Contact(Integer id, String firstName, String lastName, String phoneNumber, String sex, String dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.dob = dob;
    }


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
