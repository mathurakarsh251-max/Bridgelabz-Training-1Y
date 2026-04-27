CREATE TABLE sales (
    id INT PRIMARY KEY,
    bookName VARCHAR(100),
    quantity INT,
    price DOUBLE
);
import java.sql.*;

public class BookstoreSalesTracker {
    static final String URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            recordSale(conn, 1001, "The Alchemist", 2, 350.0);
            recordSale(conn, 1002, "Atomic Habits", 1, 450.0);
            recordSale(conn, 1003, "Clean Code", 3, 1200.0);
            System.out.println("--- Bulk Sales (Quantity > 1) ---");
            viewBulkSales(conn);
            updateSaleQuantity(conn, 1002, 5);
            deleteIncorrectSale(conn, 1003);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void recordSale(Connection conn, int id, String name, int qty, double price) throws SQLException {
        String sql = "INSERT INTO sales (id, bookName, quantity, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, qty);
            pstmt.setDouble(4, price);
            pstmt.executeUpdate();
            System.out.println("Sale recorded: " + name);
        }
    }
    public static void viewBulkSales(Connection conn) throws SQLException {
        String sql = "SELECT * FROM sales WHERE quantity > 1";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Book: " + rs.getString("bookName") + " | Qty: " + rs.getInt("quantity"));
            }
        }
    }
    public static void updateSaleQuantity(Connection conn, int id, int newQty) throws SQLException {
        String sql = "UPDATE sales SET quantity = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newQty);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Quantity updated for Sale ID: " + id);
        }
    }
    public static void deleteIncorrectSale(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM sales WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Sale record ID " + id + " has been deleted.");
        }
    }
}