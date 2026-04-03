import java.util.Scanner;

public class ComputerGuessingGame {
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it. You tell me if I'm high, low, or correct.");
        
        playGame();
    }
    public static void playGame() {
        int low = 1;
        int high = 100;
        boolean guessedCorrectly = false;

        while (!guessedCorrectly) {
            int currentGuess = calculateGuess(low, high);
            String feedback = getUserFeedback(currentGuess);

            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Awesome! I guessed it.");
                guessedCorrectly = true;
            } else if (feedback.equalsIgnoreCase("low")) {
                low = currentGuess + 1;
            } else if (feedback.equalsIgnoreCase("high")) {
                high = currentGuess - 1;
            } else {
                System.out.println("Invalid input. Please type 'high', 'low', or 'correct'.");
            }
            
            if (low > high) {
                System.out.println("Wait, something is wrong. Are you sure about your feedback?");
                break;
            }
        }
    }
    public static int calculateGuess(int low, int high) {
        return low + (high - low) / 2;
    }
    public static String getUserFeedback(int guess) {
        System.out.print("Is it " + guess + "? (high/low/correct): ");
        return scanner.nextLine().trim().toLowerCase();
    }
}