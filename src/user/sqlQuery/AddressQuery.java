package user.sqlQuery;

import user.Utility;
import user.models.Address;

import java.sql.*;

public class AddressQuery {
    static final String INSERT_QUERY =
            "INSERT INTO Address (street,city,state," +
                    "country, zipCode, contact_id) VALUES (?,?,?,?,?,?)";

    static final String UPDATE_QUERY =
            "UPDATE Address SET address=address+? WHERE address_id=?";


    static final String SELECT_ALL_QUERY =
            "SELECT * FROM Address";

    static final String DELETE_BY_ID =
            "DELETE FROM Address WHERE address_id = ?";



    public static void insertAddress(Address address) {
        try(Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
            PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
        ) {
            // Execute a query
            stmt.setString(1, address.getStreet());
            stmt.setString(2, address.getCity());
            stmt.setString(3, address.getState());
            stmt.setString(4, address.getCountry());
            stmt.setInt(5, address.getZipCode());
            stmt.setInt(6, address.getContactId());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating referee failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    address.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating referee failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public static void deleteByID(int addressId) {

        try (Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(DELETE_BY_ID);
        ) {
            stmt.setInt(1, addressId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record with ID " + addressId + " deleted successfully.");
            } else {
                System.out.println("No record found with ID " + addressId + ". Nothing deleted.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void updateAddressIDByID(int addressId) {

        try (Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY);
        ) {
            stmt.setInt(1, addressId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record with ID " + addressId + " updated successfully.");
            } else {
                System.out.println("No record found with ID " + addressId + ". Nothing updated.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
