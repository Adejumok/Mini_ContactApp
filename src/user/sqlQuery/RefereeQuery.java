package user.sqlQuery;

import user.Utility;
import user.models.Contact;
import user.models.Referee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RefereeQuery {

    static final String INSERT_QUERY =
            "INSERT INTO Referee (name,profession,phone_number," +
                    "contact_id, address_id) VALUES (?,?,?,?,?)";

    static final String UPDATE_QUERY =
            "UPDATE Referee SET referee=referee+? WHERE referee_id=?";


    static final String SELECT_ALL_QUERY =
            "SELECT referee_id,name,profession,phone_number," +
                    "contact_id, address_id FROM Referee";

    static final String DELETE_BY_ID =
            "DELETE FROM Referee WHERE referee_id = ?";


    public static void insertReferee(Referee referee) {
        try (Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY);
        ) {
            // Execute a query
            stmt.setString(1, referee.getName());
            stmt.setString(2, referee.getProfession());
            stmt.setString(3, referee.getPhoneNumber());
            stmt.setInt(4, referee.getContactId());
            stmt.setInt(5, referee.getAddressId());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating referee failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    referee.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating referee failed, no ID obtained.");
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Referee> getAllReferees() {
        List<Referee> referees = null;
        try (Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL_QUERY);
             ResultSet rs = stmt.executeQuery()
        ) {
            referees = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                String name = rs.getString(2);
                String profession = rs.getString(3);
                String phoneNumber = rs.getString(4);
                Referee referee =
                        new Referee(id, name, profession, phoneNumber);
                referees.add(referee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return referees;
    }

    public static void deleteByID(int refereeId) {

        try (Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(DELETE_BY_ID);
        ) {
            stmt.setInt(1, refereeId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record with ID " + refereeId + " deleted successfully.");
            } else {
                System.out.println("No record found with ID " + refereeId + ". Nothing deleted.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateAddressIDByID(int refereeId) {

        try (Connection conn = DriverManager
                .getConnection(Utility.DB_URL);
             PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY);
        ) {
            stmt.setInt(1, refereeId);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Record with ID " + refereeId + " updated successfully.");
            } else {
                System.out.println("No record found with ID " + refereeId + ". Nothing updated.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
