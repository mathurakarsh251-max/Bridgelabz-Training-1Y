import java.util.Scanner;

public class CaseConversionDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String originalText = scanner.nextLine();
        String manualUpper = convertToUpperCaseManual(originalText);
        String builtInUpper = originalText.toUpperCase();
        boolean areSame = compareManual(manualUpper, builtInUpper);
        System.out.println("\n--- Results ---");
        System.out.println("Manual Upper:   " + manualUpper);
        System.out.println("Built-in Upper: " + builtInUpper);
        System.out.println("Do they match?  " + areSame);

        scanner.close();
    }
    public static String convertToUpperCaseManual(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char) (ch - 32);
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