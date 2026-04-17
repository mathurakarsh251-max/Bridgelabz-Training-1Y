import java.util.Scanner;
import java.util.Arrays;

public class CharArrayComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();
        char[] manualArray = getCharsManually(input);
        char[] builtInArray = input.toCharArray();
        boolean areArraysEqual = compareCharArrays(manualArray, builtInArray);
        System.out.println("\n--- Results ---");
        System.out.println("Manual Array:   " + Arrays.toString(manualArray));
        System.out.println("Built-in Array: " + Arrays.toString(builtInArray));
        System.out.println("Do the arrays match? " + areArraysEqual);

        scanner.close();
    }
    public static char[] getCharsManually(String str) {
        char[] charArray = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }
        
        return charArray;
    }
    public static boolean compareCharArrays(char[] array1, char[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }
}