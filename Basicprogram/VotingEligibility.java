import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the age of 10 students:");
        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter age for student " + i + ": ");
            if (input.hasNextInt()) {
                int age = input.nextInt();
                if (age >= 18) {
                    System.out.println("Student " + i + ": Eligible to vote.");
                } else if (age < 0) {
                    System.out.println("Student " + i + ": Invalid age entered.");
                } else {
                    System.out.println("Student " + i + ": Not eligible to vote.");
                }
            } else {
                System.out.println("Invalid input! Please enter a whole number.");
                input.next();
                i--; 
            }
        }
        
        input.close(); 
    }
}