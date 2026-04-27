CREATE TABLE accounts (
    accNo INT PRIMARY KEY,
    name VARCHAR(50),
    balance DOUBLE
);
import java.sql.*;

public class BankAccountManager {
    static final String URL = "jdbc:mysql:
    static final String USER = "root";
    static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            addAccount(conn, 1001, "Ishaan Gupta", 15000.0);
            addAccount(conn, 1002, "Meera Rao", 5000.0);
            System.out.println("--- High Balance Accounts ---");
            viewPremiumAccounts(conn);
            updateBalance(conn, 1002, 2000.0); 
            closeAccount(conn, 1001);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addAccount(Connection conn, int accNo, String name, double initialBalance) throws SQLException {
        String sql = "INSERT INTO accounts (accNo, name, balance) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accNo);
            pstmt.setString(2, name);
            pstmt.setDouble(3, initialBalance);
            pstmt.executeUpdate();
            System.out.println("Account created for: " + name);
        }
    }
    public static void viewPremiumAccounts(Connection conn) throws SQLException {
        String sql = "SELECT * FROM accounts WHERE balance > 10000";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Acc No: " + rs.getInt("accNo") + " | Holder: " + rs.getString("name") + " | Balance: " + rs.getDouble("balance"));
            }
        }
    }
    public static void updateBalance(Connection conn, int accNo, double amount) throws SQLException {
        String sql = "UPDATE accounts SET balance = balance + ? WHERE accNo = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, amount);
            pstmt.setInt(2, accNo);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                String type = (amount > 0) ? "Deposit" : "Withdrawal";
                System.out.println(type + " successful for Account: " + accNo);
            }
        }
    }
    public static void closeAccount(Connection conn, int accNo) throws SQLException {
        String sql = "DELETE FROM accounts WHERE accNo = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accNo);
            pstmt.executeUpdate();
            System.out.println("Account " + accNo + " closed successfully.");
        }
    }
}