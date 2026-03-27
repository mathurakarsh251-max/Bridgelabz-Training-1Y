import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of persons in the team: ");
        int n = input.nextInt();
        double[] weights = new double[n];
        double[] heights = new double[n];
        double[] bmis = new double[n];
        String[] statuses = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nDetails for Person " + (i + 1) + ":");
            System.out.print("Enter weight in kg: ");
            weights[i] = input.nextDouble();
            System.out.print("Enter height in meters: ");
            heights[i] = input.nextDouble();
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            if (bmis[i] <= 18.4) {
                statuses[i] = "Underweight";
            } else if (bmis[i] <= 24.9) {
                statuses[i] = "Normal";
            } else if (bmis[i] <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        System.out.println("\n===============================================================");
        System.out.printf("%-10s %-10s %-10s %-10s %-15s\n", 
                          "Person", "Weight", "Height", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-15s\n", 
                              (i + 1), weights[i], heights[i], bmis[i], statuses[i]);
        }
        System.out.println("===============================================================");

        input.close();
    }
}