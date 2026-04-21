import java.util.Scanner;

public class CharTypeTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to analyze character types:");
        String input = scanner.nextLine();
        String[][] charData = analyzeString(input);
        displayTable(charData);

        scanner.close();
    }
    public static String getCharacterType(char ch) {
        char originalChar = ch;
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }
    public static String[][] analyzeString(String text) {
        String[][] data = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            data[i][0] = String.valueOf(ch);        
            data[i][1] = getCharacterType(ch);    
        }
        return data;
    }
    public static void displayTable(String[][] table) {
        System.out.println("\n-----------------------------");
        System.out.printf("%-12s | %-15s\n", "Character", "Type");
        System.out.println("-----------------------------");

        for (int i = 0; i < table.length; i++) {
            String displayChar = table[i][0].equals(" ") ? "[Space]" : table[i][0];
            
            System.out.printf("%-12s | %-15s\n", displayChar,