import java.util.Scanner;
import java.util.Random;

public class StudentScorecard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[][] scores = generateScores(n);
        double[][] stats = calculateStats(scores);
        String[][] grades = calculateGrades(stats);

        displayScorecard(scores, stats, grades);
        scanner.close();
    }

    public static int[][] generateScores(int n) {
        Random rand = new Random();
        int[][] pcm = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                pcm[i][j] = 10 + rand.nextInt(90); 
            }
        }
        return pcm;
    }

    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double pct = (total / 300.0) * 100.0;
            stats[i][0] = total;
            stats[i][1] = Math.round(avg * 100.0) / 100.0;
            stats[i][2] = Math.round(pct * 100.0) / 100.0;
        }
        return stats;
    }

    public static String[][] calculateGrades(double[][] stats) {
        String[][] grades = new String[stats.length][1];
        for (int i = 0; i < stats.length; i++) {
            double pct = stats[i][2];
            if (pct >= 80) grades[i][0] = "A";
            else if (pct >= 70) grades[i][0] = "B";
            else if (pct >= 60) grades[i][0] = "C";
            else if (pct >= 50) grades[i][0] = "D";
            else if (pct >= 40) grades[i][0] = "E";
            else grades[i][0] = "R";
        }
        return grades;
    }

    public static void displayScorecard(int[][] sc, double[][] st, String[][] gr) {
        System.out.printf("\n%-10s | %-3s | %-4s | %-4s | %-5s | %-5s | %-5s | %-5s\n", 
                          "Student", "Phy", "Chem", "Mat", "Total", "Avg", "Pct", "Grade");
        System.out.println("-".repeat(65));
        for (int i = 0; i < sc.length; i++) {
            System.out.printf("Student %-2d | %-3d | %-4d | %-4d | %-5.0f | %-5.2f | %-5.2f | %-5s\n",
                              (i+1), sc[i][0], sc[i][1], sc[i][2], st[i][0], st[i][1], st[i][2], gr[i][0]);
        }
    }
}