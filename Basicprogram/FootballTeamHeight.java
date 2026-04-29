import java.util.Scanner;

public class FootballTeamHeight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;

        System.out.println("Enter the heights of 11 football players (in cm or meters):");
        for (int i = 0; i < 11; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = input.nextDouble();
        }
        for (int i = 0; i < 11; i++) {
            sum += heights[i];
        }
        double meanHeight = sum / 11;
        System.out.println("\n--- Results ---");
        System.out.printf("Total Sum of Heights: %.2f\n", sum);
        System.out.printf("The Mean Height of the team is: %.2f\n", meanHeight);

        input.close();
    }
}