package user.models;

public class Address {
    private Integer id;
    private String street;

    private String city;
    private String state;
    private String country;
    private int zipCode;
    private int contactId;

    public void setId(Integer id) {
        this.id = id;
    }

    public Address(String street, String city, String state, String country, int zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public Address(Integer id, String street, String city, String state, String country,int zipCode, int contactId) {
        this.id = id;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.contactId = contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public int getContactId() {
        return contactId;
    }

    public int getZipCode() {
        return zipCode;
    }
}
