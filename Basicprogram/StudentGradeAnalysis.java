import java.util.Scanner;

public class StudentGradeAnalysis {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();
        int[][] pcmScores = generateRandomScores(numStudents);
        double[][] metrics = calculateMetrics(pcmScores);
        displayScorecard(pcmScores, metrics);

        input.close();
    }
    public static int[][] generateRandomScores(int num) {
        int[][] scores = new int[num][3]; 
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int) (Math.random() * 90) + 10;
            }
        }
        return scores;
    }
    public static double[][] calculateMetrics(int[][] pcm) {
        double[][] stats = new double[pcm.length][3];
        for (int i = 0; i < pcm.length; i++) {
            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            stats[i][0] = total;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }