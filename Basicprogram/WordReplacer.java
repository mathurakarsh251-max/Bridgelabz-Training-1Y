import java.util.Scanner;

public class WordReplacer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        
        System.out.print("Word to replace: ");
        String target = scanner.next();
        
        System.out.print("Replace with: ");
        String replacement = scanner.next();
        
        String result = replaceWord(sentence, target, replacement);
        
        System.out.println("\nOriginal: " + sentence);
        System.out.println("Modified: " + result);
        
        scanner.close();
    }

    public static String replaceWord(String sentence, String target, String replacement) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                sb.append(replacement);
            } else {
                sb.append(words[i]);
            }
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}