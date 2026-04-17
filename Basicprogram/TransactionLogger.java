import java.util.Arrays;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionLogger {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList(
            "TXN-9901", 
            "TXN-9902", 
            "TXN-9903", 
            "TXN-9904"
        );
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        System.out.println("--- System Audit Log Initialized ---");
        transactionIds.forEach(id -> {
            String timestamp = LocalDateTime.now().format(formatter);
            System.out.println(timestamp + " - Transaction: " + id);
        });

        System.out.println("--- End of Log ---");
    }
}