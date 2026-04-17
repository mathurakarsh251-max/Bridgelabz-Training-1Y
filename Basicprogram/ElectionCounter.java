import java.util.HashMap;
import java.util.Map;

public class ElectionCounter {
    public static void main(String[] args) {
        Map<String, Integer> votes = new HashMap<>();
        String[] castVotes = {
            "Alice", "Bob", "Charlie", "Alice", "Alice", 
            "Bob", "Charlie", "Alice", "Charlie", "Bob"
        };

        for (String candidate : castVotes) {
            // Check if exists: if yes, increment; if no, set to 1
            votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        }
        System.out.println("--- Election Results ---");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
        String winner = "";
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("\nWinner: " + winner + " with " + maxVotes + " votes!");
    }
}