import java.util.Scanner;

public class NestedLoopFrequency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to find frequencies (using nested loops):");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Input is empty.");
            return;
        }
        String[] results = findFrequencyNested(input);
        System.out.println("\n--- Character Frequencies ---");
        for (String record : results) {
            System.out.println(record);
        }

        scanner.close();
    }
    public static String[] findFrequencyNested(String text) {
        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];
        int uniqueCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                continue;
            }

            freq[i] = 1; 

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
            uniqueCount++;
        }
        String[] resultData = new String[uniqueCount];
        int resultIndex = 0;
        char[] originalChars = text.toCharArray(); 
            if (chars[i] != '0') {
                String charLabel = (originalChars[i] == ' ') ? "[Space]" : String.valueOf(originalChars[i]);
                resultData[resultIndex++] = charLabel + " : " + freq[i];
            }
        }

        return resultData;
    }
}