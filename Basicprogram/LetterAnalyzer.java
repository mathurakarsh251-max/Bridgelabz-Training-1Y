import java.util.Scanner;

public class LetterAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to count vowels and consonants:");
        String input = scanner.nextLine();
        int[] counts = countVowelsAndConsonants(input);
        System.out.println("\n--- Analysis Results ---");
        System.out.println("Vowels:     " + counts[0]);
        System.out.println("Consonants: " + counts[1]);

        scanner.close();
    }
    public static String checkCharacterType(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        if (ch < 'a' || ch > 'z') {
            return "Not a Letter";
        }
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        } else {
            return "Consonant";
        }
    }
    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String type = checkCharacterType(ch);

            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }
}