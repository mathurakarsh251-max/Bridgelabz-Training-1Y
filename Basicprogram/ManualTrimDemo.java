import java.util.Scanner;

public class ManualTrimDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string with leading and trailing spaces:");
        String input = scanner.nextLine();
        int[] boundaries = getTrimBoundaries(input);
        int start = boundaries[0];
        int end = boundaries[1];
        String manualTrimmed = getManualSubstring(input, start, end);
        String builtInTrimmed = input.trim();
        boolean areEqual = compareManual(manualTrimmed, builtInTrimmed);
        System.out.println("\n--- Results ---");
        System.out.println("Original:        [" + input + "]");
        System.out.println("Manual Trimmed:  [" + manualTrimmed + "]");
        System.out.println("Built-in Trimmed:[" + builtInTrimmed + "]");
        System.out.println("Do they match?   " + areEqual);

        scanner.close();
    }
    public static int[] getTrimBoundaries(String text) {
        int len = text.length();
        int start = 0;
        int end = len; 
        while (start < len && text.charAt(start) == ' ') {
            start++;
        }
        while (end > start && text.charAt(end - 1) == ' ') {
            end--;
        }

        return new int[]{start, end};
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
        for (int i = 0; i < s1.length