import java.util.Scanner;

public class CharacterFrequency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to find character frequencies:");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("The string is empty.");
            return;
        }
        String[][] frequencyTable = getFrequencyArray(input);
        System.out.println("\n--- Character Frequencies ---");
        System.out.printf("%-12s | %-10s\n", "Character", "Frequency");
        System.out.println("-----------------------------");
        for (int i = 0; i < frequencyTable.length; i++) {
            String charDisplay = frequencyTable[i][0].equals(" ") ? "[Space]" : frequencyTable[i][0];
            System.out.printf("%-12s | %-10s\n", charDisplay, frequencyTable[i][1]);
        }

        scanner.close();
    }
    public static String[][] getFrequencyArray(String text) {
        int[] counts = new int[256];
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i)]++;
        }
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (counts[i] > 0) uniqueCount++;
        }