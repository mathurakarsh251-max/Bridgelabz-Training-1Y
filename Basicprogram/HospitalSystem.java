CREATE TABLE patients (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    disease VARCHAR(50)
);
import java.sql.*;

public class HospitalSystem {
    static final String URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            addPatient(conn, 201, "Arjun Mehta", "Viral Fever");
            addPatient(conn, 202, "Sana Khan", "Diabetes");
            addPatient(conn, 203, "Rohan Das", "Viral Fever");
            System.out.println("--- Patients diagnosed with Viral Fever ---");
            findPatientsByDisease(conn, "Viral Fever");
            updateDiagnosis(conn, 202, "Type 2 Diabetes");
            dischargePatient(conn, 201);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addPatient(Connection conn, int id, String name, String disease) throws SQLException {
        String sql = "INSERT INTO patients (id, name, disease) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, disease);
            pstmt.executeUpdate();
            System.out.println("Patient Registered: " + name);
        }
    }
    public static void findPatientsByDisease(Connection conn, String diseaseName) throws SQLException {
        String sql = "SELECT * FROM patients WHERE disease = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, diseaseName);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + " | Name: " + rs.getString("name"));
                }
            }
        }
    }
    public static void updateDiagnosis(Connection conn, int id, String newDisease) throws SQLException {
        String sql = "UPDATE patients SET disease = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newDisease);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Diagnosis updated for Patient ID: " + id);
        }
    }
    public static void dischargePatient(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM patients WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Patient ID " + id + " discharged and record removed.");
        }
    }
}