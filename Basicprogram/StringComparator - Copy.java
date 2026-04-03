import java.util.Scanner;

public class StringComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("String 1: ");
        String s1 = scanner.nextLine();
        System.out.print("String 2: ");
        String s2 = scanner.nextLine();
        
        int result = compareStrings(s1, s2);

        if (result < 0) {
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
        } else if (result > 0) {
            System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal.");
        }
        
        scanner.close();
    }

    public static int compareStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < minLength; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (c1 != c2) {
                // Return the difference in ASCII values
                return c1 - c2;
            }
        }
        return str1.length() - str2.length();
    }
}