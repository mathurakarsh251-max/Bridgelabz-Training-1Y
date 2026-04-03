import java.util.Scanner;

public class StudentGradingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the total number of students: ");
        int numStudents = input.nextInt();
        double[][] marks = new double[numStudents][3];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\n--- Entering marks for Student " + (i + 1) + " ---");
            
            String[] subjects = {"Physics", "Chemistry", "Maths"};
            double totalForStudent = 0;

            for (int j = 0; j < 3; j++) {
                System.out.print("Enter marks for " + subjects[j] + ": ");
                double entry = input.nextDouble();
                if (entry < 0) {
                    System.out.println("Invalid input! Please enter positive values.");
                    j--; // Decrement subject index to retry this subject
                } else {
                    marks[i][j] = entry;
                    totalForStudent += entry;
                }
            }
            percentages[i] = (totalForStudent / 300) * 100;
            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }
        System.out.println("\n==========================================================");
        System.out.