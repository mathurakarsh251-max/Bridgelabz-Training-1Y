import java.util.Scanner;

public class StudentVoteChecker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] studentAges = new int[10];

        System.out.println("Enter the ages of 10 students:");
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Age for student " + (i + 1) + ": ");
            studentAges[i] = input.nextInt();
        }

        System.out.println("\n--- Voting Eligibility Results ---");
        for (int i = 0; i < studentAges.length; i++) {
            int age = studentAges[i];
            if (canStudentVote(age)) {
                System.out.println("Student " + (i + 1) + " (Age " + age + "): Can Vote");
            } else {
                System.out.println("Student " + (i + 1) + " (Age " + age + "): Cannot Vote");
            }
        }

        input.close();
    }
    public static boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }
}