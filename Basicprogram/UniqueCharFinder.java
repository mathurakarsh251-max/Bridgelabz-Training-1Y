import java.util.Scanner;

public class UniqueCharFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to find unique characters:");
        String input = scanner.nextLine();
        char[] uniqueChars = findUniqueChars(input);
        System.out.print("Unique characters found: ");
        for (int i = 0; i < uniqueChars.length; i++) {
            System.out.print(uniqueChars[i] + (i < uniqueChars.length - 1 ? ", " : ""));
        }
        System.out.println("\nTotal unique count: " + uniqueChars.length);

        scanner.close();
    }
    public static int getManualLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }
    public static char[] findUniqueChars(String text) {
        int len = getManualLength(text);
        char[] tempArray = new char[len];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean isAlreadySeen = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isAlreadySeen = true;
                    break;
                }
            }
            if (!isAlreadySeen) {
                tempArray[uniqueCount] = current;
                uniqueCount++;
            }
        }
        char[] finalUniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            finalUniqueChars[i] = tempArray[i];
        }

        return finalUniqueChars;
    }
}