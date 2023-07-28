package user.sqlQuery;

import user.Utility;
import user.models.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactQuery {
    static final String INSERT_QUERY =
            "INSERT INTO Contact (first_name,last_name,phone_number," +
                    "sex, date_of_birth) VALUES (?,?,?,?,?)";

    static final String UPDATE_QUERY =
            "UPDATE Contact SET address_id=address_id+? WHERE contact_id=?";


    static final String SELECT_ALL_QUERY =
            "SELECT contact_id,first_name,last_name,phone_number," +
                    "sex, date_of_birth FROM Contact";

    static final String DELETE_BY_ID =
            "DELETE FROM Contact WHERE contact_id = ?";

    public static void insertContact(Contact contact) {

        try (Connection conn = DriverManager.getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
        ) {
            // Execute a query
            stmt.setString(1, contact.getFirstName());
            stmt.setString(2, contact.getLastName());
            stmt.setString(3, contact.getPhoneNumber());
            stmt.setString(4, contact.getSex());
            stmt.setDate(5, java.sql.Date.valueOf(contact.getDob()));
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating referee failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    contact.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating referee failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void getAllContact() {
        List<Contact> contacts = null;
        try(Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
            PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_QUERY);
            ResultSet rs = stmt.executeQuery()
        ) {
            contacts = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String phoneNumber = rs.getString(4);
                String sex = rs.getString(5);
                String dob =
                        rs.getDate(6).toString();
                Contact contact =
                        new Contact(id,firstName,lastName,phoneNumber,sex,dob);
                contacts.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert contacts != null;
        for (Contact contact:contacts) {
            System.out.println(contact);
        }
    }

    public static void deleteByID(int contactId) {

        try (Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(DELETE_BY_ID);
        ) {
            stmt.setInt(1, contactId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record with ID " + contactId + " deleted successfully.");
            } else {
                System.out.println("No record found with ID " + contactId + ". Nothing deleted.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateAddressIDByID(int contactId, int addressId) {

        try (Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY);
        ) {
            stmt.setInt(1, addressId);
            stmt.setInt(2, contactId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record with ID " + contactId + " updated successfully.");
            } else {
                System.out.println("No record found with ID " + contactId + ". Nothing updated.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
