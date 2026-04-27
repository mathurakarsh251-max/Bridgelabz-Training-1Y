CREATE TABLE menu (
    id INT PRIMARY KEY,
    itemName VARCHAR(50),
    price DOUBLE
);
import java.sql.*;

public class MenuManager {
    static final String URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            addItem(conn, 1, "Paneer Butter Masala", 250.0);
            addItem(conn, 2, "Garlic Naan", 60.0);
            addItem(conn, 3, "Cold Coffee", 120.0);
            System.out.println("--- Budget Friendly Items (< ₹200) ---");
            viewBudgetItems(conn, 200.0);
            updatePrice(conn, 1, 280.0);
            removeItem(conn, 3);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addItem(Connection conn, int id, String name, double price) throws SQLException {
        String sql = "INSERT INTO menu (id, itemName, price) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, price);
            pstmt.executeUpdate();
            System.out.println("Item Added: " + name);
        }
    }
    public static void viewBudgetItems(Connection conn, double maxPrice) throws SQLException {
        String sql = "SELECT * FROM menu WHERE price < ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, maxPrice);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("itemName") + " - ₹" + rs.getDouble("price"));
                }
            }
        }
    }
    public static void updatePrice(Connection conn, int id, double newPrice) throws SQLException {
        String sql = "UPDATE menu SET price = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newPrice);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Price updated for Item ID: " + id);
        }
    }
    public static void removeItem(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM menu WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Item ID " + id + " removed from the menu.");
        }
    }
}