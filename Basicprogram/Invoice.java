import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Invoice {
    private String transactionId;
    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice[ID: " + transactionId + ", Status: GENERATED]";
    }
}

public class InvoiceSystem {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList(
            "TXN-2026-001", 
            "TXN-2026-002", 
            "TXN-2026-003", 
            "TXN-2026-004"
        );
        List<Invoice> invoices = transactionIds.stream()
                                               .map(Invoice::new)
                                               .collect(Collectors.toList());
        System.out.println("--- System Generated Invoices ---");
        invoices.forEach(System.out::println);
    }
}