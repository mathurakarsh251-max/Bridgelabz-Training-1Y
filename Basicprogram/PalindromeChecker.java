import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        String userInput = getUserInput();
        boolean isPalindrome = checkPalindrome(userInput);
        displayResult(userInput, isPalindrome);
    }
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or phrase to check: ");
        return scanner.nextLine();
    }
    public static boolean checkPalindrome(String text) {
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int left = 0;
        int right = cleanText.length() - 1;

        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false; 
            }
            left++;
            right--;
        }
        return true;
    }
    public static void displayResult(String original, boolean result) {
        System.out.println("\nOriginal text: \"" + original + "\"");
        if (result) {
            System.out.println("Result: This IS a palindrome.");
        } else {
            System.out.println("Result: This is NOT a palindrome.");
        }
    }
}