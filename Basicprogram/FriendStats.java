import java.util.Scanner;

public class FriendStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter details for Amar:");
        System.out.print("Age: ");
        int ageAmar = scanner.nextInt();
        System.out.print("Height (cm): ");
        double heightAmar = scanner.nextDouble();

        System.out.println("\nEnter details for Akbar:");
        System.out.print("Age: ");
        int ageAkbar = scanner.nextInt();
        System.out.print("Height (cm): ");
        double heightAkbar = scanner.nextDouble();

        System.out.println("\nEnter details for Anthony:");
        System.out.print("Age: ");
        int ageAnthony = scanner.nextInt();
        System.out.print("Height (cm): ");
        double heightAnthony = scanner.nextDouble();

        System.out.println("\n----------------------------");
        System.out.print("The youngest friend is: ");
        if (ageAmar <= ageAkbar && ageAmar <= ageAnthony) {
            System.out.println("Amar");
        } else if (ageAkbar <= ageAmar && ageAkbar <= ageAnthony) {
            System.out.println("Akbar");
        } else {
            System.out.println("Anthony");
        }
        System.out.print("The tallest friend is: ");
        if (heightAmar >= heightAkbar && heightAmar >= heightAnthony) {
            System.out.println("Amar");
        } else if (heightAkbar >= heightAmar && heightAkbar >= heightAnthony) {
            System.out.println("Akbar");
        } else {
            System.out.println("Anthony");
        }
        
        System.out.println("----------------------------");
        scanner.close();
    }
}