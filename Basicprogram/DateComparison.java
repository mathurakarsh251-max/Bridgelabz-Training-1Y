vimport java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Date Comparison Tool ---");
        System.out.print("Enter the first date (yyyy-mm-dd): ");
        LocalDate date1 = LocalDate.parse(scanner.next());
        System.out.print("Enter the second date (yyyy-mm-dd): ");
        LocalDate date2 = LocalDate.parse(scanner.next());

        System.out.println("\nComparison Results:");
        if (date1.isBefore(date2)) {
            System.out.println(date1 + " comes BEFORE " + date2);
        } 
        else if (date1.isAfter(date2)) {
            System.out.println(date1 + " comes AFTER " + date2);
        } 
        else if (date1.isEqual(date2)) {
            System.out.println("Both dates are the SAME.");
        }

        scanner.close();
    }
}