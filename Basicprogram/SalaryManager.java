import java.sql.*;

public class SalaryManager {
    static final String DB_URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            addEmployee(conn, 101, "Aarav Sharma", 45000.0);
            addEmployee(conn, 102, "Ishani Verma", 12000.0);
            System.out.println("High Earning Employees:");
            displayHighEarners(conn);
            updateSalary(conn, 101, 1.10);
            deleteUnderpaid(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addEmployee(Connection conn, int id, String name, double salary) throws SQLException {
        String sql = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, salary);
            pstmt.executeUpdate();
        }
    }
    public static void displayHighEarners(Connection conn) throws SQLException {
        String sql = "SELECT * FROM employee WHERE salary > 30000";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getDouble("salary"));
            }
        }
    }
    public static void updateSalary(Connection conn, int id, double multiplier) throws SQLException {
        String sql = "UPDATE employee SET salary = salary * ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, multiplier);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }
    public static void deleteUnderpaid(Connection conn) throws SQLException {
        String sql = "DELETE FROM employee WHERE salary < 15000";
        try (Statement stmt = conn.createStatement()) {
            int rowsDeleted = stmt.executeUpdate(sql);
            System.out.println("Deleted " + rowsDeleted + " records.");
        }
    }
}