import java.util.Scanner;

public class ZaraBonusCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] oldSalaries = new double[10];
        int[] yearsOfService = new int[10];
        double[] bonuses = new double[10];
        double totalBonusPayout = 0.0;

        System.out.println("--- Zara Employee Bonus System ---");

        for (int i = 0; i < 10; i++) {
            System.out.println("\nEmployee #" + (i + 1));
            System.out.print("Enter Current Salary: ");
            oldSalaries[i] = input.nextDouble();
            System.out.print("Enter Years of Service: ");
            yearsOfService[i] = input.nextInt();

            double bonusPercentage;
            if (yearsOfService[i] > 10) {
                bonusPercentage = 0.15; 
            } else if (yearsOfService[i] >= 5) {
                bonusPercentage = 0.10; 
            } else {
                bonusPercentage = 0.05; 
            }

            bonuses[i] = oldSalaries[i] * bonusPercentage;
            totalBonusPayout += bonuses[i];
        }
        System.out.println("\n===============================================================");
        System.out.printf("%-12s %-12s %-10s %-12s %-12s\n", 
                          "Employee", "Old Salary", "Years", "Bonus", "New Salary");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            double newSalary = oldSalaries[i] + bonuses[i];
            System.out.printf("Employee %-2d  $%-11.2f %-10d $%-11.2f $%-11.2f\n", 
                              (i + 1), oldSalaries[i], yearsOfService[i], bonuses[i], newSalary);
        }

        System.out.println("===============================================================");
        System.out.printf("Total Bonus Payout for Zara: $%.2f\n", totalBonusPayout);

        input.close();
    }
}