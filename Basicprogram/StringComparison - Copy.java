import java.util.Scanner;

public class StringComparison {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = scanner.next();

        System.out.print("Enter the second string: ");
        String str2 = scanner.next();
        boolean manualResult = compareManual(str1, str2);
        boolean builtInResult = str1.equals(str2);

        System.out.println("\n--- Results ---");
        System.out.println("Manual charAt() comparison: " + manualResult);
        System.out.println("Built-in .equals() comparison: " + builtInResult);

        if (manualResult == builtInResult) {
            System.out.println("Success: Both methods returned the same result!");
        } else {
            System.out.println("Error: The results do not match.");
        }
        
        scanner.close();
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