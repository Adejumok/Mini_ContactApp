package com.sqlQuery;

import com.Utility;
import com.models.Address;
import com.models.Referee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressQuery {
    static final String INSERT_QUERY =
            "INSERT INTO Address (street,city,state," +
                    "country, zipCode) VALUES (?,?,?,?,?)";

    static final String UPDATE__QUERY =
            "UPDATE Address SET address=address+? WHERE addressId=?";


    static final String SELECT_ALL_QUERY =
            "SELECT addressId,street,city,state," +
                    "country, zipCode FROM Address";

    static final String SELECT_BY_ID_QUERY =
            "SELECT addressId,street,city,state," +
                    "country, zipCode FROM Address" +
                    "WHERE addressId=?";


    public static String insertAddress(Address address) {
        try(Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
            PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY);
        ) {
            // Execute a query
            stmt.setString(1, address.getStreet());
            stmt.setString(2, address.getCity());
            stmt.setString(3, address.getState());
            stmt.setString(3, address.getCountry());
            int result = stmt.executeUpdate();
            if (result == 1) return address.getStreet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getAllAddresses() {
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
