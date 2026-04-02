import java.util.Scanner;

public class UniqueFrequencyAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to analyze character frequencies:");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("Input is empty.");
            return;
        }
        String[][] frequencyData = getFrequencyWithUnique(input);
        System.out.println("\n--- Frequency Report ---");
        System.out.printf("%-12s | %-10s\n", "Character", "Frequency");
        System.out.println("-------------------------");
        
        for (int i = 0; i < frequencyData.length; i++) {
            String charLabel = frequencyData[i][0].equals(" ") ? "[Space]" : frequencyData[i][0];
            System.out.printf("%-12s | %-10s\n", charLabel, frequencyData[i][1]);
        }

        scanner.close();
    }
    public static char[] uniqueCharacters(String text) {
        int len = text.length();
        char[] temp = new char[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    is