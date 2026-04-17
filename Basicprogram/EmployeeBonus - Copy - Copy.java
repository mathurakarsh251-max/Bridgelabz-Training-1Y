import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter years of service: ");
        int yearsOfService = scanner.nextInt();

        double bonusAmount = 0.0;
        if (yearsOfService > 5) {
            bonusAmount = salary * 0.05;
            System.out.println("Congratulations! You are eligible for a 5% bonus.");
        } else {
            System.out.println("Bonus is only applicable for more than 5 years of service.");
        }
        System.out.println("----------------------------");
        System.out.println("Base Salary: " + salary);
        System.out.println("Bonus Amount: " + bonusAmount);
        System.out.println("Total Payout: " + (salary + bonusAmount));
        
        scanner.close();
    }
}