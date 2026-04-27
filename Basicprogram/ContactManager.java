CREATE TABLE customers (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    phone VARCHAR(15)
);
import java.sql.*;

public class ContactManager {
    static final String URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            addCustomer(conn, 1001, "Rajesh Khanna", "9876543210");
            addCustomer(conn, 1002, "Sonal Singh", "9123456789");
            System.out.println("--- Search Results ---");
            searchByName(conn, "Raj");
            updatePhone(conn, 1001, "9988776655");
            removeCustomer(conn, 1002);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addCustomer(Connection conn, int id, String name, String phone) throws SQLException {
        String sql = "INSERT INTO customers VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            pstmt.executeUpdate();
            System.out.println("Customer added: " + name);
        }
    }
    public static void searchByName(Connection conn, String partialName) throws SQLException {
        String sql = "SELECT * FROM customers WHERE name LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + partialName + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Name: " + rs.getString("name") + " | Phone: " + rs.getString("phone"));
            }
        }
    }
    public static void updatePhone(Connection conn, int id, String newPhone) throws SQLException {
        String sql = "UPDATE customers SET phone = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newPhone);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Phone number updated for ID: " + id);
        }
    }
    public static void removeCustomer(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Customer record " + id + " deleted.");
        }
    }
}