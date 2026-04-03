import java.util.Objects;

public class GameScoreboard {
    public static void main(String[] args) {
        Integer[] playerScores = {1500, null, 2400, 0, null, 850};

        int notPlayedCount = 0;
        int totalValidScore = 0;
        int activePlayers = 0;

        System.out.println("--- Game Scoreboard Analysis ---");

        for (Integer score : playerScores) {
            if (score == null) {
                notPlayedCount++;
            } else {
                totalValidScore += score; 
                activePlayers++;
                System.out.println("Active Player Score: " + score);
            }
        }
        System.out.println("\n--- Final Statistics ---");
        System.out.println("Players who haven't played (null): " + notPlayedCount);
        System.out.println("Total active players: " + activePlayers);
        System.out.println("Total sum of valid scores: " + totalValidScore);
    }
}