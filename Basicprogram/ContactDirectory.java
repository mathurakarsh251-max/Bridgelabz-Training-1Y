import java.sql.*;

public class ContactDirectory {
    static final String DB_URL = "jdbc:mysql://localhost:3306/shop_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            addCustomer(conn, 1, "Rajesh Kumar", "9876543210");
            addCustomer(conn, 2, "Anita Sharma", "9123456789");
            System.out.println("--- Search Results ---");
            searchCustomer(conn, "Raj");
            updatePhone(conn, 1, "9988776655");
            removeCustomer(conn, 2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addCustomer(Connection conn, int id, String name, String phone) throws SQLException {
        String sql = "INSERT INTO customers (id, name, phone) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            pstmt.executeUpdate();
            System.out.println("Customer added: " + name);
        }
    }
    public static void searchCustomer(Connection conn, String searchTerm) throws SQLException {
        String sql = "SELECT * FROM customers WHERE name LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // Adding % wildcards for partial matching
            pstmt.setString(1, "%" + searchTerm + "%");
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
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Phone number updated for ID: " + id);
        }
    }
    public static void removeCustomer(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Customer record ID " + id + " deleted.");
        }
    }
}