CREATE TABLE employee (
    id INT PRIMARY KEY, 
    name VARCHAR(50), 
    salary DOUBLE
);
import java.sql.*;

public class SalaryManager {
    static final String URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("Connected to database successfully.");
            addEmployee(conn, 101, "Aman Sharma", 45000.0);
            addEmployee(conn, 102, "Sita Verma", 12000.0);
            System.out.println("\nEmployees with salary > 30000:");
            viewHighEarners(conn);
            updateSalary(conn, 101, 10);
            deleteLowEarners(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addEmployee(Connection conn, int id, String name, double salary) throws SQLException {
        String query = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, salary);
            pstmt.executeUpdate();
            System.out.println("Inserted: " + name);
        }
    }
    public static void viewHighEarners(Connection conn) throws SQLException {
        String query = "SELECT * FROM employee WHERE salary > 30000";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getDouble("salary"));
            }
        }
    }
    public static void updateSalary(Connection conn, int id, double percentage) throws SQLException {
        String query = "UPDATE employee SET salary = salary + (salary * ? / 100) WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDouble(1, percentage);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Salary updated for ID: " + id);
        }
    }
    public static void deleteLowEarners(Connection conn) throws SQLException {
        String query = "DELETE FROM employee WHERE salary < 15000";
        try (Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(query);
            System.out.println("Deleted " + rows + " employees with low salary.");
        }
    }
}