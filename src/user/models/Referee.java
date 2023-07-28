package user.models;

public class Referee {
    private Integer id;
    private String name;
    private String profession;

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    private String phoneNumber;
    private int contactId;
    private int addressId;


    public Referee(Integer id, String name, String profession, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.profession = profession;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getContactId() {
        return contactId;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public Referee(String name, String profession, String phoneNumber) {
        this.name = name;
        this.profession = profession;
        this.phoneNumber = phoneNumber;

    }

    @Override
    public String toString() {
        return "Referee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contactId=" + contactId +
                ", addressId=" + addressId +
                '}';
    }
}
