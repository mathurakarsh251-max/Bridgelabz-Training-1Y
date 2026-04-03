import java.util.Scanner;

public class WordLengthTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine().trim();
        String[] words = splitManually(input);
        String[][] wordData = getWordData2D(words);
        System.out.println("\n---------------------------");
        System.out.printf("%-15s | %-10s\n", "Word", "Length");
        System.out.println("---------------------------");

        for (int i = 0; i < wordData.length; i++) {
            String word = wordData[i][0];
            int length = Integer.parseInt(wordData[i][1]);
            
            System.out.printf("%-15s | %-10d\n", word, length);
        }
        System.out.println("---------------------------");

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
        if (textLen == 0) return new String[0];

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
                words[wordIdx++] = currentWord;
                currentWord = "";
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
            int len = getLength(words[i]);
            data[i][1] = String.valueOf(len);
        }
        return data;
    }
}