CREATE TABLE movies (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    seats INT
);
import java.sql.*;

public class MovieBookingSystem {
    static final String URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            addMovie(conn, 1, "Inception", 50);
            addMovie(conn, 2, "Interstellar", 0); 
            addMovie(conn, 3, "The Dark Knight", 30);
            System.out.println("--- Movies with Available Seats ---");
            viewAvailableMovies(conn);
            bookTickets(conn, 1, 2);
            removeMovie(conn, 2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addMovie(Connection conn, int id, String name, int totalSeats) throws SQLException {
        String sql = "INSERT INTO movies (id, name, seats) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, totalSeats);
            pstmt.executeUpdate();
            System.out.println("Movie added: " + name);
        }
    }
    public static void viewAvailableMovies(Connection conn) throws SQLException {
        String sql = "SELECT * FROM movies WHERE seats > 0";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Movie: " + rs.getString("name") + " | Seats left: " + rs.getInt("seats"));
            }
        }
    }
    public static void bookTickets(Connection conn, int id, int ticketsToBook) throws SQLException {
        String sql = "UPDATE movies SET seats = seats - ? WHERE id = ? AND seats >= ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ticketsToBook);
            pstmt.setInt(2, id);
            pstmt.setInt(3, ticketsToBook);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Successfully booked " + ticketsToBook + " tickets for Movie ID: " + id);
            } else {
                System.out.println("Booking failed: Not enough seats or Movie ID not found.");
            }
        }
    }
    public static void removeMovie(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM movies WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Movie ID " + id + " has been removed from the schedule.");
        }
    }
}