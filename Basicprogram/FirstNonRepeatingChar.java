import java.util.Scanner;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to find the first non-repeating character:");
        String input = scanner.nextLine();
        char result = findFirstUnique(input);
        if (result != '\0') {
            System.out.println("The first non-repeating character is: '" + result + "'");
        } else {
            System.out.println("No non-repeating character found.");
        }

        scanner.close();
    }
    public static char findFirstUnique(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch; 
            }
        }
        return '\0';
    }
}