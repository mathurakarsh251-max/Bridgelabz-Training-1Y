import java.util.Scanner;

public class GradeSystem2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the total number of students: ");
        int numStudents = input.nextInt();
        double[][] subjectMarks = new double[numStudents][3];
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            double currentStudentTotal = 0;

            for (int j = 0; j < 3; j++) {
                String subjectName = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                System.out.print("Enter marks for " + subjectName + ": ");
                double score = input.nextDouble();
                if (score < 0) {
                    System.out.println("Error: Marks cannot be negative. Please re-enter.");
                    j--; 
                } else {
                    subjectMarks[i][j] = score;
                    currentStudentTotal += score;
                }
            }
            percentages[i] = (currentStudentTotal / 300) * 100;
            if (percentages[i] >= 80) {
                grades[i] = "A (Level 4)";
            } else if (percentages[i] >= 70) {
                grades[i] = "B (Level 3)";
            } else if (percentages[i] >= 60) {
                grades[i] = "C (Level 2)";
            } else if (percentages[i] >= 50) {
                grades[i] = "D (Level 1)";
            } else if (percentages[i] >= 40) {
                grades[i] = "E (Level 1-)";
            } else {
                grades[i] = "R (Remedial)";
            }
        }
        System.out.println("\n" + "=".repeat(70));
        System.out.printf("%-10s %-10s %-10s %-10s %-12s %-15s\n", 
                          "Student", "Physics", "Chem", "Maths", "Percentage", "Grade");
        System.out.println("-".repeat(70));

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("Std %-6d %-10.1f %-10.1f %-10.1f %-12.2f %-15s\n", 
                              (i + 1), 
                              subjectMarks[i][0], 
                              subjectMarks[i][1], 
                              subjectMarks[i][2], 
                              percentages[i], 
                              grades[i]);
        }
        System.out.println("=".repeat(70));

        input.close();
    }
}