import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateUtils {
    static String formatInvoiceDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}
public class InvoiceGenerator {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        String indianFormat = DateUtils.formatInvoiceDate(today, "dd-MM-yyyy");
        String usFormat = DateUtils.formatInvoiceDate(today, "MM/dd/yyyy");
        String formalFormat = DateUtils.formatInvoiceDate(today, "MMMM dd, yyyy");

        System.out.println("--- Invoice Date Formats ---");
        System.out.println("Local Format: " + indianFormat);
        System.out.println("International Format: " + usFormat);
        System.out.println("Billing Statement Format: " + formalFormat);
    }
}