import java.util.Scanner;

public class LowerCaseConversionDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence with UPPERCASE letters: ");
        String originalText = scanner.nextLine();
        String manualLower = convertToLowerCaseManual(originalText);
        String builtInLower = originalText.toLowerCase();
        boolean areSame = compareManual(manualLower, builtInLower);
        System.out.println("\n--- Results ---");
        System.out.println("Manual Lower:   " + manualLower);
        System.out.println("Built-in Lower: " + builtInLower);
        System.out.println("Do they match?  " + areSame);

        scanner.close();
    }
    public static String convertToLowerCaseManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char) (ch + 32);
            } else {
                result += ch;
            }
        }
        return result;
    }
    public static boolean compareManual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}