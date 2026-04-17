import java.util.function.Function;

public class MessageChecker {
    public static void main(String[] args) {
        Function<String, Integer> getLength = (message) -> message.length();
        String userMessage = "Hello, this is a test message for the length checker.";
        int limit = 50;
        int actualLength = getLength.apply(userMessage);

        System.out.println("Message: " + userMessage);
        System.out.println("Character Count: " + actualLength);

        if (actualLength > limit) {
            System.out.println("Result: Message exceeds the " + limit + " character limit! [cite: 18]");
        } else {
            System.out.println("Result: Message is within the allowed limit.");
        }
    }
}