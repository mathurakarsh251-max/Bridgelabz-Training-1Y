import java.util.Scanner;

public class FrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        int[] freq = new int[256];
        for (int i = 0; i < input.length(); i++) {
            freq[input.charAt(i)]++;
        }
        int maxCount = -1;
        char result = ' ';
        
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (maxCount < freq[currentChar]) {
                maxCount = freq[currentChar];
                result = currentChar;
            }
        }
        
        System.out.println("Most Frequent Character: '" + result + "'");
        System.out.println("Frequency: " + maxCount);
        
        scanner.close();
    }
}