CREATE TABLE product (
    pid INT PRIMARY KEY,
    pname VARCHAR(50),
    qty INT
);
import java.sql.*;

public class InventoryManager {
    static final String DB_URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "your_password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            insertProduct(conn, 1, "Laptop", 15);
            insertProduct(conn, 2, "Mouse", 5);
            insertProduct(conn, 3, "Keyboard", 8);
            System.out.println("--- Low Stock Alert ---");
            displayLowStock(conn);
            updateStock(conn, 3, 20);
            deleteProduct(conn, 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertProduct(Connection conn, int id, String name, int qty) throws SQLException {
        String sql = "INSERT INTO product VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, qty);
            pstmt.executeUpdate();
            System.out.println("Product Added: " + name);
        }
    }
    public static void displayLowStock(Connection conn) throws SQLException {
        String sql = "SELECT * FROM product WHERE qty < 10";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("pid") + " | Name: " + rs.getString("pname") + " | Qty: " + rs.getInt("qty"));
            }
        }
    }
    public static void updateStock(Connection conn, int id, int addedQty) throws SQLException {
        String sql = "UPDATE product SET qty = qty + ? WHERE pid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, addedQty);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Stock updated for Product ID: " + id);
        }
    }
    public static void deleteProduct(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM product WHERE pid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Product ID " + id + " deleted from records.");
        }
    }
}