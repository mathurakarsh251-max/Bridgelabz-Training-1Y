import java.util.Scanner;

public class PalindromeMaster {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or phrase to check: ");
        String input = scanner.nextLine();
        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();

        System.out.println("\n--- Palindrome Check Results ---");
        System.out.println("Logic 1 (Iterative): " + isPalindromeIterative(cleanInput));
        System.out.println("Logic 2 (Recursive): " + isPalindromeRecursive(cleanInput, 0, cleanInput.length() - 1));
        System.out.println("Logic 3 (Array Rev): " + isPalindromeArrayReversal(cleanInput));

        scanner.close();
    }
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }
    public static char[] reverseString(String text) {
        int len = text.length();
        char[] revArray = new char[len];
        for (int i = 0; i < len; i++) {
            revArray[i] = text.charAt(len - 1 - i);
        }
        return revArray;
    }
}