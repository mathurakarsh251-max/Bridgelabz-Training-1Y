CREATE TABLE books (
    id INT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(50),
    status VARCHAR(10) -- "Available" or "Issued"
);
import java.sql.*;

public class LibraryManager {
    static final String URL = "jdbc:mysql";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            addBook(conn, 501, "The Great Gatsby", "F. Scott Fitzgerald");
            System.out.println("--- Books Currently Available ---");
            showAvailableBooks(conn);
            issueBook(conn, 501);
            removeBook(conn, 502);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addBook(Connection conn, int id, String title, String author) throws SQLException {
        String sql = "INSERT INTO books (id, title, author, status) VALUES (?, ?, ?, 'Available')";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.executeUpdate();
            System.out.println("Book Added: " + title);
        }
    }
    public static void showAvailableBooks(Connection conn) throws SQLException {
        String sql = "SELECT * FROM books WHERE status = 'Available'";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("title") + " by " + rs.getString("author"));
            }
        }
    }
    public static void issueBook(Connection conn, int id) throws SQLException {
        String sql = "UPDATE books SET status = 'Issued' WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Book ID " + id + " has been issued.");
        }
    }
    public static void removeBook(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Book ID " + id + " removed from catalog.");
        }
    }
}