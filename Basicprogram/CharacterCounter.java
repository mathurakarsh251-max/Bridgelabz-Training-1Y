import java.util.Scanner;

public class CharacterCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to analyze:");
        String input = scanner.nextLine();

        int letterCount = 0;
        int digitCount = 0;
        int specialCharCount = 0;
        int whitespaceCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                letterCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            } else if (Character.isWhitespace(ch)) {
                whitespaceCount++;
            } else {
                specialCharCount++;
            }
        }
        System.out.println("\n--- Analysis Results ---");
        System.out.println("Total Letters: " + letterCount);
        System.out.println("Total Digits: " + digitCount);
        System.out.println("Total Whitespaces: " + whitespaceCount);
        System.out.println("Total Special Characters: " + specialCharCount);

        scanner.close();
    }
}