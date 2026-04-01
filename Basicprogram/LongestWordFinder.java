import java.util.Scanner;

public class LongestWordFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a sentence: " );
        String sentence = scanner.nextLine();
        String[] words = sentence.split("\\s+");
        
        String longestWord = "";

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            
            if (cleanWord.length() > longestWord.length()) {
                longestWord = cleanWord;
            }
        }

        System.out.println("The longest word is: " + longestWord);
        System.out.println("Length: " + longestWord.length());
        
        scanner.close();
    }
}