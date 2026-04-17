import java.util.Arrays;
import java.util.List;

public class EmailNotificationSystem {
    public static void main(String[] args) {
        List<String> userEmails = Arrays.asList(
            "admin@company.com", 
            "dev_team@startup.io", 
            "support@service.net", 
            "ceo@enterprise.org"
        );

        System.out.println("--- Initializing Bulk Email Dispatch ---");
        userEmails.forEach(email -> sendEmailNotification(email));

        System.out.println("--- Dispatch Complete ---");
    }
    public static void sendEmailNotification(String email) {
        System.out.println(">> Success: Notification sent to " + email);
    }
}