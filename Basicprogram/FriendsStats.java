import java.util.Scanner;

public class FriendsStats {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter details for Amar:");
        System.out.print("Age: ");
        int ageAmar = input.nextInt();
        System.out.print("Height (cm): ");
        double heightAmar = input.nextDouble();
        System.out.println("\nEnter details for Akbar:");
        System.out.print("Age: ");
        int ageAkbar = input.nextInt();
        System.out.print("Height (cm): ");
        double heightAkbar = input.nextDouble();
        System.out.println("\nEnter details for Anthony:");
        System.out.print("Age: ");
        int ageAnthony = input.nextInt();
        System.out.print("Height (cm): ");
        double heightAnthony = input.nextDouble();
        String youngest;
        if (ageAmar <= ageAkbar && ageAmar <= ageAnthony) {
            youngest = "Amar";
        } else if (ageAkbar <= ageAmar && ageAkbar <= ageAnthony) {
            youngest = "Akbar";
        } else {
            youngest = "Anthony";
        }
        String tallest;
        if (heightAmar >= heightAkbar && heightAmar >= heightAnthony) {
            tallest = "Amar";
        } else if (heightAkbar >= heightAmar && heightAkbar >= heightAnthony) {
            tallest = "Akbar";
        } else {
            tallest = "Anthony";
        }
        System.out.println("\n--- Final Results ---");
        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);

        input.close();
    }
}