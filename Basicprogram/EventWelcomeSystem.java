import java.util.Arrays;
import java.util.List;

public class 
 {
    public static void main(String[] args) {
        List<String> attendees = Arrays.asList(
            "Sophia", 
            "Jackson", 
            "Emma", 
            "Aiden", 
            "Olivia"
        );

        System.out.println("--- Starting Attendee Check-in ---");
        attendees.forEach(name -> System.out.println("Welcome to the Tech Summit, " + name + "!"));

        System.out.println("--- All attendees welcomed. ---");
    }
}