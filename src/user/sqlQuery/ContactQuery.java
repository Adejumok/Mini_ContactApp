package com.sqlQuery;

import com.Utility;
import com.models.Contact;

import java.sql.*;
import java.time.LocalDate;

public class ContactQuery {
    static final String INSERT_QUERY =
            "INSERT INTO Contact (firstName,lastName,phoneNumber," +
                    "sex, dob) VALUES (?,?,?,?,?)";

    static final String UPDATE__QUERY =
            "UPDATE Contact SET address=address+? WHERE addressId=?";


    static final String SELECT_ALL_QUERY =
            "SELECT contactId,firstName,lastName,phoneNumber," +
                    "sex, dob FROM Contact";

    static final String SELECT_BY_ID_QUERY =
            "SELECT contactId,firstName,lastName,phoneNumber," +
                    "sex, dob FROM Contact" +
                    "WHERE refereeId=?";

    public static String insertContact(Contact contact) {
        try(Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
            PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY);
        ) {
            // Execute a query
            stmt.setString(1, contact.getFirstName());
            stmt.setString(2, contact.getLastName());
            stmt.setString(3, contact.getPhoneNumber());
            stmt.setString(4, contact.getSex());
            stmt.setDate(5, Date.valueOf(contact.getDob()));
            int result = stmt.executeUpdate();
            if (result == 1) return contact.getFirstName();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getAllContact() {
        try(Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
            PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_QUERY);
        ) {
            stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
