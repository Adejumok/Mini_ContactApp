package com.sqlQuery;

import com.Utility;
import com.models.Contact;
import com.models.Referee;

import java.sql.*;

public class RefereeQuery {

    static final String INSERT_QUERY =
            "INSERT INTO Referee (name,profession,phoneNumber," +
                    "address) VALUES (?,?,?,?,?)";

    static final String UPDATE__QUERY =
            "UPDATE Referee SET address=address+? WHERE addressId=?";


    static final String SELECT_ALL_QUERY =
            "SELECT refereeId,name,profession,phoneNumber," +
                    "address_id FROM Referee";

    static final String SELECT_BY_ID_QUERY =
            "SELECT refereeId,name,profession,phoneNumber," +
                    "address FROM Referee" +
                    "WHERE refereeId=?";


    public static String insertReferee(Referee referee) {
        try(Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
            PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY);
        ) {
            // Execute a query
            stmt.setString(1, referee.getName());
            stmt.setString(2, referee.getProfession());
            stmt.setString(3, referee.getPhoneNumber());
            int result = stmt.executeUpdate();
            if (result == 1) return referee.getName();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getAllReferees() {
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
