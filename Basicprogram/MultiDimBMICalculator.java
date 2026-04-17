import java.util.Scanner;

public class MultiDimBMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of persons in the team: ");
        int n = input.nextInt();
        double[][] personData = new double[n][3];
        String[] statuses = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nDetails for Person " + (i + 1) + ":");
            
            System.out.print("Enter weight (kg): ");
            personData[i][0] = input.nextDouble(); 
            
            System.out.print("Enter height (m): ");
            personData[i][1] = input.nextDouble(); 
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);
            double currentBMI = personData[i][2];
            if (currentBMI <= 18.4) {
                statuses[i] = "Underweight";
            } else if (currentBMI <= 24.9) {
                statuses[i] = "Normal";
            } else if (currentBMI <= 39.9) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        System.out.println("\n===============================================================");
        System.out.printf("%-10s %-10s %-10s %-10s %-15s