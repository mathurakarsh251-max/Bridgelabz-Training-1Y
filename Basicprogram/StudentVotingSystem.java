import java.util.Scanner;
import java.util.Random;

public class StudentVotingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students (e.g., 10): ");
        int n = scanner.nextInt();
        int[] ages = generateRandomAges(n);
        String[][] votingData = processVotingEligibility(ages);
        displayVotingTable(votingData);

        scanner.close();
    }
    public static int[] generateRandomAges(int n) {
        Random random = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = random.nextInt(100); 
        }
        return ages;
    }
    public static String[][] processVotingEligibility(int[] ages) {
        String[][] data = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            int currentAge = ages[i];
            boolean canVote = false;
            if (currentAge >= 18) {
                canVote = true;
            } else if (currentAge < 0) {
                canVote = false; 
            }

            data[i][0] = String.valueOf(currentAge);
            data[i][1] = String.valueOf(canVote);
        }
        return data;
    }
    public static void displayVotingTable(String[][] table) {
        System.out.println("\n----------------------------");
        System.out.printf("%-10s | %-12s\n", "Student Age", "Can Vote?");
        System.out.println("----------------------------");

        for (int i = 0; i < table.length; i++) {
            String age = table[i][0];
            String eligibility = table[i][1];
            String status = eligibility.equals("true") ? "YES" : "NO";

            System.out.printf("%-11s | %-12s\n", age, status);
        }
        System.out.println("----------------------------");
    }
}