import java.sql.*;

public class LibraryManager {
    static final String DB_URL = "jdbc:mysql://localhost:3306/library_db";
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            addBook(conn, 1001, "The Great Gatsby", "F. Scott Fitzgerald");
            addBook(conn, 1002, "1984", "George Orwell");
            System.out.println("--- Books Currently Available ---");
            displayAvailableBooks(conn);
            issueBook(conn, 1001);
            removeBook(conn, 1002);

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
            System.out.println("Book added: " + title);
        }
    }
    public static void displayAvailableBooks(Connection conn) throws SQLException {
        String sql = "SELECT id, title, author FROM books WHERE status = 'Available'";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("title") + " by " + rs.getString("author"));
            }
        }
    }
    public static void issueBook(Connection conn, int id) throws SQLException {
        String sql = "UPDATE books SET status = 'Issued' WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Book ID " + id + " has been successfully issued.");
        }
    }
    public static void removeBook(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM books WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Book ID " + id + " removed from catalog.");
        }
    }
}