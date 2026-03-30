import java.util.Scanner;

public class StringMinMaxFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence to analyze:");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("No text entered.");
            return;
        }
        String[] words = splitManually(input);
        String[][] wordData = getWordData2D(words);
        int[] minMaxIndices = findMinMaxIndices(wordData);
        int shortestIdx = minMaxIndices[0];
        int longestIdx = minMaxIndices[1];

        System.out.println("\n--- Analysis Results ---");
        System.out.println("Shortest Word: " + wordData[shortestIdx][0] + " (Length: " + wordData[shortestIdx][1] + ")");
        System.out.println("Longest Word:  " + wordData[longestIdx][0] + " (Length: " + wordData[longestIdx][1] + ")");

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
        int textLen = getLength(text);
        int spaceCount = 0;
        for (int i = 0; i < textLen; i++) {
            if (text.charAt(i) == ' ') spaceCount++;
        }

        String[] words = new String[spaceCount + 1];
        int wordIdx = 0;
        String currentWord = "";

        for (int i = 0; i < textLen; i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (!currentWord.isEmpty()) {
                    words[wordIdx++] = currentWord;
                    currentWord = "";
                }
            } else {
                currentWord += c;
            }
        }
        words[wordIdx] = currentWord;
        return words;
    }
    public static String[][] getWordData2D(String[] words) {
        String[][] data = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            data[i][0] = words[i];
            data[i][1] = String.valueOf(getLength(words[i]));
        }
        return data;
    }
    public static int[] findMinMaxIndices(String[][] data) {
        int minIdx = 0;
        int maxIdx = 0;
        int minVal = Integer.parseInt(data[0][1]);
        int maxVal = Integer.parseInt(data[0][1]);

        for (int i = 1; i < data.length; i++) {
            int currentLen = Integer.parseInt(data[i][1]);

            if (currentLen < minVal) {
                minVal = currentLen;
                minIdx = i;
            }
            if (currentLen > maxVal) {
                maxVal = currentLen;
                maxIdx = i;
            }
        }
        return new int[]{minIdx, maxIdx};
    }
}