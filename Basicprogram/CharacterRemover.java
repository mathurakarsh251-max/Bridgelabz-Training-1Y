import java.util.Scanner;

public class CharacterRemover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        System.out.print("Enter the character to remove: ");
        char target = scanner.next().charAt(0);
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current != target) {
                sb.append(current);
            }
        }

        System.out.println("Modified String: " + sb.toString());
        
        scanner.close();
    }
}