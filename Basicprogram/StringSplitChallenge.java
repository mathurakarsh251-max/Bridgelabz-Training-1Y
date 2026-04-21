import java.util.Scanner;
import java.util.Arrays;

public class StringSplitChallenge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence to split:");
        String input = scanner.nextLine().trim(); 
        String[] manualWords = splitManually(input);
        String[] builtInWords = input.split(" ");
        boolean areEqual = compareStringArrays(manualWords, builtInWords);
        System.out.println("\n--- Results ---");
        System.out.println("Manual Split:   " + Arrays.toString(manualWords));
        System.out.println("Built-in Split: " + Arrays.toString(builtInWords));
        System.out.println("Do the arrays match? " + areEqual);

        scanner.close();
    }
    public static int getLength(String text) {
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
    public static String[] splitManually(String text) {
        int len = getLength(text);
        if (len == 0) return new String[0];
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') spaceCount++;
        }
        int wordCount = spaceCount + 1;
        int[] spaceIndices = new int[spaceCount];
        int indexTracker = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndices[indexTracker++] = i;
            }
        }
        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < wordCount; i++) {
            int end = (i < spaceCount) ? spaceIndices[i] : len;
            String word = "";
            for (int j = start; j < end; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
            start = end + 1; 
        }

        return words;
    }
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            