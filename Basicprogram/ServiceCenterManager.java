CREATE TABLE vehicles (
    regNo VARCHAR(20) PRIMARY KEY,
    owner VARCHAR(50),
    status VARCHAR(20) -- "Pending", "In Progress", "Completed"
);
import java.sql.*;

public class ServiceCenterManager {
    static final String URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            addVehicle(conn, "DL-3C-1234", "Vikram Singh");
            addVehicle(conn, "MH-01-AB-9999", "Priya Sharma");
            System.out.println("--- Pending Service List ---");
            viewByStatus(conn, "Pending");
            updateStatus(conn, "DL-3C-1234", "Completed");
            deliverVehicle(conn, "DL-3C-1234");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addVehicle(Connection conn, String regNo, String owner) throws SQLException {
        String sql = "INSERT INTO vehicles (regNo, owner, status) VALUES (?, ?, 'Pending')";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, regNo);
            pstmt.setString(2, owner);
            pstmt.executeUpdate();
            System.out.println("Vehicle Registered: " + regNo);
        }
    }
    public static void viewByStatus(Connection conn, String status) throws SQLException {
        String sql = "SELECT * FROM vehicles WHERE status = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("RegNo: " + rs.getString("regNo") + " | Owner: " + rs.getString("owner"));
                }
            }
        }
    }
    public static void updateStatus(Connection conn, String regNo, String newStatus) throws SQLException {
        String sql = "UPDATE vehicles SET status = ? WHERE regNo = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newStatus);
            pstmt.setString(2, regNo);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Status updated to '" + newStatus + "' for: " + regNo);
        }
    }
    public static void deliverVehicle(Connection conn, String regNo) throws SQLException {
        String sql = "DELETE FROM vehicles WHERE regNo = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, regNo);
            pstmt.executeUpdate();
            System.out.println("Vehicle " + regNo + " delivered and record closed.");
        }
    }
}