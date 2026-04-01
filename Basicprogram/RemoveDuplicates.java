import java.util.Scanner;
import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String result = removeDuplicateChars(input);
        
        System.out.println("String after removing duplicates: " + result);
        
        scanner.close();
    }

    public static String removeDuplicateChars(String str) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (sb.indexOf(String.valueOf(current)) == -1) {
                sb.append(current);
            }
        }
        return sb.toString();
    }
}