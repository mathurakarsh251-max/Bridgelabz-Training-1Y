CREATE TABLE members (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    type VARCHAR(20), -- e.g., "Basic", "Premium", "Elite"
    months INT
);
import java.sql.*;

public class GymManager {
    static final String URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            addMember(conn, 401, "Karan Singh", "Premium", 6);
            addMember(conn, 402, "Sonia Ray", "Basic", 3);
            addMember(conn, 403, "Rahul Verma", "Premium", 12);
            System.out.println("--- Premium Membership List ---");
            viewMembersByType(conn, "Premium");
            extendMembership(conn, 402, 3);
            removeMember(conn, 403);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addMember(Connection conn, int id, String name, String type, int months) throws SQLException {
        String sql = "INSERT INTO members (id, name, type, months) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, type);
            pstmt.setInt(4, months);
            pstmt.executeUpdate();
            System.out.println("Member Added: " + name);
        }
    }
    public static void viewMembersByType(Connection conn, String type) throws SQLException {
        String sql = "SELECT * FROM members WHERE type = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, type);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + " | Name: " + rs.getString("name") + " | Validity: " + rs.getInt("months") + " months");
                }
            }
        }
    }
    public static void extendMembership(Connection conn, int id, int extraMonths) throws SQLException {
        String sql = "UPDATE members SET months = months + ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, extraMonths);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Membership extended for ID: " + id);
        }
    }
    public static void removeMember(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM members WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Member record ID " + id + " removed.");
        }
    }
}