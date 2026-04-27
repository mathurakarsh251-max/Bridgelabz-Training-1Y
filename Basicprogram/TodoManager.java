CREATE TABLE tasks (
    id INT PRIMARY KEY,
    title VARCHAR(100),
    status VARCHAR(20) -- "Pending", "Completed"
);
import java.sql.*;

public class TodoManager {
    static final String URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            addTask(conn, 1, "Finish Java JDBC Assignment");
            addTask(conn, 2, "Buy Groceries");
            addTask(conn, 3, "Pay Electricity Bill");
            System.out.println("--- Your Pending Tasks ---");
            viewPendingTasks(conn);
            completeTask(conn, 1);
            clearFinishedTasks(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addTask(Connection conn, int id, String title) throws SQLException {
        String sql = "INSERT INTO tasks (id, title, status) VALUES (?, ?, 'Pending')";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, title);
            pstmt.executeUpdate();
            System.out.println("Task Added: " + title);
        }
    }
    public static void viewPendingTasks(Connection conn) throws SQLException {
        String sql = "SELECT * FROM tasks WHERE status = 'Pending'";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". [ ] " + rs.getString("title"));
            }
        }
    }
    public static void completeTask(Connection conn, int id) throws SQLException {
        String sql = "UPDATE tasks SET status = 'Completed' WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Task " + id + " marked as Completed.");
        }
    }
    public static void clearFinishedTasks(Connection conn) throws SQLException {
        String sql = "DELETE FROM tasks WHERE status = 'Completed'";
        try (Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(sql);
            System.out.println("Cleanup: " + rows + " completed tasks removed.");
        }
    }
}