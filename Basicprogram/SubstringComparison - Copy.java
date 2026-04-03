import java.util.Scanner;

public class SubstringComparison {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String originalText = scanner.next();

        System.out.print("Enter the start index: ");
        int startIndex = scanner.nextInt();

        System.out.print("Enter the end index (exclusive): ");
        int endIndex = scanner.nextInt();
        if (startIndex < 0 || endIndex > originalText.length() || startIndex > endIndex) {
            System.out.println("Error: Invalid indices provided.");
            return;
        }
        String manualSubstring = getManualSubstring(originalText, startIndex, endIndex);
        String builtInSubstring = originalText.substring(startIndex, endIndex);
        boolean areEqual = compareManual(manualSubstring, builtInSubstring);
        System.out.println("\n--- Results ---");
        System.out.println("Manual Substring (charAt): " + manualSubstring);
        System.out.println("Built-in Substring:        " + builtInSubstring);
        System.out.println("Are the results identical?  " + areEqual);

        scanner.close();
    }
    public static String getManualSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
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