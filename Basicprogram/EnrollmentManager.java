CREATE TABLE enrollments (
    id INT PRIMARY KEY,
    student VARCHAR(50),
    course VARCHAR(50)
);
import java.sql.*;

public class EnrollmentManager {
    static final String URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            enrollStudent(conn, 301, "Amit Patel", "Java Programming");
            enrollStudent(conn, 302, "Sarah Jones", "Python for Data Science");
            enrollStudent(conn, 303, "Amit Patel", "Web Development");
            System.out.println("--- Students in Java Programming ---");
            viewStudentsByCourse(conn, "Java Programming");
            updateCourse(conn, 302, "Java Programming");
            cancelEnrollment(conn, 303);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void enrollStudent(Connection conn, int id, String student, String course) throws SQLException {
        String sql = "INSERT INTO enrollments (id, student, course) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, student);
            pstmt.setString(3, course);
            pstmt.executeUpdate();
            System.out.println("Enrolled: " + student + " in " + course);
        }
    }
    public static void viewStudentsByCourse(Connection conn, String courseName) throws SQLException {
        String sql = "SELECT student FROM enrollments WHERE course = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseName);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("- " + rs.getString("student"));
                }
            }
        }
    }
    public static void updateCourse(Connection conn, int id, String newCourse) throws SQLException {
        String sql = "UPDATE enrollments SET course = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newCourse);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Course updated for Enrollment ID: " + id);
        }
    }
    public static void cancelEnrollment(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM enrollments WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Enrollment ID " + id + " cancelled.");
        }
    }
}