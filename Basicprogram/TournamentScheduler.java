import java.util.Objects;

class Team implements Comparable<Team> {
    String name;
    int points;

    public Team(String name) {
        this.name = name;
        this.points = 0;
    }

    @Override
    public int compareTo(Team other) {
        if (this.points != other.points) {
            return Integer.compare(other.points, this.points);
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;
        Team team = (Team) o;
        return name.equalsIgnoreCase(team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }
}

class Match {
    Team teamA, teamB;
    public Match(Team a, Team b) { this.teamA = a; this.teamB = b; }
}

class Result {
    String summary;
    public Result(String summary) { this.summary = summary; }
}
import java.util.*;

public class TournamentScheduler {
    private Set<Team> registeredTeams = new HashSet<>();
    private Queue<Match> matchSchedule = new LinkedList<>();
    private List<Result> matchHistory = new ArrayList<>();
    private TreeSet<Team> leaderboard = new TreeSet<>();
    public void registerTeam(String name) {
        Team t = new Team(name);
        if (registeredTeams.add(t)) {
            System.out.println("Team " + name + " registered.");
        }
    }
    public void scheduleMatch(Team a, Team b) {
        if (registeredTeams.contains(a) && registeredTeams.contains(b)) {
            matchSchedule.add(new Match(a, b));
        }
    }
    public void processNextMatch(String winnerName) {
        if (!matchSchedule.isEmpty()) {
            Match m = matchSchedule.poll();
            String summary = m.teamA.name + " vs " + m.teamB.name + " -> Winner: " + winnerName;
            if (m.teamA.name.equals(winnerName)) m.teamA.points += 3;
            else if (m.teamB.name.equals(winnerName)) m.teamB.points += 3;

            matchHistory.add(new Result(summary));
            System.out.println("Match Processed: " + summary);
        }
    }
    public void displayLeaderboard() {
        leaderboard.clear();
        leaderboard.addAll(registeredTeams);

        System.out.println("\n--- Current Standings ---");
        int rank = 1;
        for (Team t : leaderboard) {
            System.out.println(rank++ + ". " + t.name + " - " + t.points + " pts");
        }
    }
}