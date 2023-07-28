package user;

import user.models.Address;
import user.models.Contact;
import user.models.Referee;
import user.sqlQuery.AddressQuery;
import user.sqlQuery.ContactQuery;
import user.sqlQuery.RefereeQuery;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select any of the options below: \n" +
                "1 -> Add Record\n" +
                "2 -> Get All Contact Records\n" +
                "3 -> Get All Address Records\n" +
                "4 -> Get All Referee Records\n" +
                "5 -> Delete Contact Record by ID\n" +
                "6 -> Update Contact Record by ID");

        int option = scanner.nextInt();
        switch (option){
            case 1:
                System.out.print("Enter contact first name: ");
                String firstName = scanner.next();
                System.out.print("Enter contact last name: ");
                String lastName = scanner.next();
                System.out.print("Enter contact phone number: ");
                String phoneNumber = scanner.next();
                System.out.print("Enter contact sex(Male/Female): ");
                String sex = scanner.next();
                System.out.print("Enter contact date of birth(yyyy-MM-dd): ");
                String dob = scanner.next();

                Contact contact = new Contact(firstName, lastName, phoneNumber, sex, dob);
                ContactQuery.insertContact(contact);
                int contactId = contact.getId();

                System.out.print("Enter address street: ");
                String street = scanner.next();
                System.out.print("Enter address city: ");
                String city = scanner.next();
                System.out.print("Enter address state: ");
                String state = scanner.next();
                System.out.print("Enter address country: ");
                String country = scanner.next();
                System.out.print("Enter address zip code: ");
                int zipCode = scanner.nextInt();

                Address address = new Address(street, city, state, country, zipCode);
                address.setContactId(contactId);
                AddressQuery.insertAddress(address);

                System.out.print("Enter referee name: ");
                String refName = scanner.next();
                System.out.print("Enter referee phone number: ");
                String phoneNum = scanner.next();
                System.out.print("Enter referee profession: ");
                String profession = scanner.next();

                Referee referee = new Referee(refName,profession,phoneNum);
                referee.setContactId(contactId);
                referee.setAddressId(address.getId());
                RefereeQuery.insertReferee(referee);

                System.out.println("Data inserted successfully!");
                break;

            case 2:
                ContactQuery.getAllContact();
                break;

            case 3:
                AddressQuery.getAllAddresses();
                break;

            case 4:
                RefereeQuery.getAllReferees();
                break;

            case 5:
                System.out.print("Enter the contact id: ");
                int delContactId= scanner.nextInt();
                ContactQuery.deleteByID(delContactId);
                break;

            case 6:
                System.out.print("Enter the contact id: ");
                int updateContactId= scanner.nextInt();
                System.out.print("Enter the address id: ");
                int updateAddressId= scanner.nextInt();
                ContactQuery.updateAddressIDByID(updateContactId, updateAddressId);
                break;

        }



    }
}
