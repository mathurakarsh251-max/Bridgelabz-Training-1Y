import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many rounds would you like to play? ");
        int totalGames = scanner.nextInt();
        String[] userChoices = new String[totalGames];
        String[] computerChoices = new String[totalGames];
        String[] winners = new String[totalGames];

        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < totalGames; i++) {
            System.out.println("\n--- Round " + (i + 1) + " ---");
            System.out.print("Enter choice (0: Rock, 1: Paper, 2: Scissors): ");
            int userChoiceInt = scanner.nextInt();
            
            userChoices[i] = convertChoice(userChoiceInt);
            computerChoices[i] = getComputerChoice();
            
            winners[i] = determineWinner(userChoices[i], computerChoices[i]);
            
            if (winners[i].equals("User")) userWins++;
            else if (winners[i].equals("Computer")) computerWins++;
            
            System.out.println("Computer chose: " + computerChoices[i]);
            System.out.println("Result: " + (winners[i].equals("Tie") ? "It's a Tie!" : winners[i] + " wins!"));
        }
        String[][] stats = calculateStats(userWins, computerWins, totalGames);
        displayFinalResults(userChoices, computerChoices, winners, stats);

        scanner.close();
    }
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3); 
        return convertChoice(choice);
    }

    private static String convertChoice(int choice) {
        if (choice == 0) return "Rock";
        if (choice == 1) return "Paper";
        return "Scissors";
    }
    public static String determineWinner(String user, String computer) {
        if (user.equals(computer)) return "Tie";
        if ((user.equals("Rock") && computer.equals("Scissors")) ||
            (user.equals("Paper") && computer.equals("Rock")) ||
            (user.equals("Scissors") && computer.equals("Paper"))) {
            return "User";
        }
        return "Computer";
    }
    public static String[][] calculateStats(int uWins, int cWins, int total) {
        String[][] stats = new String[2][3]; 

        double uAvg = (double) uWins / total;
        double cAvg = (double) cWins / total;

        stats[0][0] = String.valueOf(uWins);
        stats[0][1] = String.format("%.2f", uAvg);
        stats[0][2] = String.format("%.1f%%", uAvg * 100);

        stats[1][0] = String.valueOf(cWins);
        stats[1][1] = String.format("%.2f", cAvg);
        stats[1][2] = String.format("%.1f%%", cAvg * 100);

        return stats;
    }
    public static void displayFinalResults(String[] uChars, String[] cChars, String[] wins, String[][] stats) {
        System.out.println("\n--- GAME HISTORY ---");
        System.out.printf("%-10s | %-10s | %-10s | %-10s\n", "Round", "User", "Computer", "Winner");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < uChars.length; i++) {
            System.out.printf("%-10d | %-10s | %-10s | %-10s\n", (i + 1), uChars[i], cChars[i], wins[i]);
        }

        System.out.println("\n--- FINAL STATISTICS ---");
        System.out.printf("%-10s | %-10s | %-10s | %-10s\n", "Player", "Wins", "Average", "Percentage");
        System.out.println("-------------------------------------------------");
        System.out.printf("%-10s | %-10s | %-10s | %-10s\n", "User", stats[0][0], stats[0][1], stats[0][2]);
        System.out.printf("%-10s | %-10s | %-10s | %-10s\n", "Computer", stats[1][0], stats[1][1], stats[1][2]);
    }
}