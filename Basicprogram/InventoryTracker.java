import java.sql.*;

public class InventoryTracker {
    static final String DB_URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            insertProduct(conn, 501, "Wireless Mouse", 15);
            insertProduct(conn, 502, "USB-C Cable", 5);
            insertProduct(conn, 503, "Mechanical Keyboard", 2);
            System.out.println("--- Low Stock Alert ---");
            checkLowStock(conn);
            updateStock(conn, 502, 20);
            deleteProduct(conn, 503);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertProduct(Connection conn, int pid, String name, int qty) throws SQLException {
        String sql = "INSERT INTO product (pid, pname, qty) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pid);
            pstmt.setString(2, name);
            pstmt.setInt(3, qty);
            pstmt.executeUpdate();
        }
    }
    public static void checkLowStock(Connection conn) throws SQLException {
        String sql = "SELECT * FROM product WHERE qty < 10";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Product: " + rs.getString("pname") + " | Stock: " + rs.getInt("qty"));
            }
        }
    }
    public static void updateStock(Connection conn, int pid, int addedQty) throws SQLException {
        String sql = "UPDATE product SET qty = qty + ? WHERE pid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, addedQty);
            pstmt.setInt(2, pid);
            pstmt.executeUpdate();
            System.out.println("Stock updated for Product ID: " + pid);
        }
    }
    public static void deleteProduct(Connection conn, int pid) throws SQLException {
        String sql = "DELETE FROM product WHERE pid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pid);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Product " + pid + " removed from inventory.");
        }
    }
}