class Movie {
    String title;
    String genre;

    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return title + " (" + genre + ")";
    }
}
import java.util.*;

public class StreamingSystem {
    private List<Movie> library = new ArrayList<>();        
    private Stack<Movie> watchHistory = new Stack<>();      
    private Set<String> watchedGenres = new HashSet<>();    
    private Queue<Movie> upNextQueue = new LinkedList<>(); 
    public void addToQueue(Movie movie) {
        upNextQueue.add(movie);
        System.out.println("Added to Up Next: " + movie.title);
    }
    public void watchCurrentMovie() {
        if (!upNextQueue.isEmpty()) {
            Movie current = upNextQueue.poll();
            watchHistory.push(current);
            watchedGenres.add(current.genre);
            
            System.out.println("Finished watching: " + current.title);
        } else {
            System.out.println("Your 'Up Next' queue is empty.");
        }
    }
    public void displayRecommendations() {
        System.out.println("\n--- Recommendations For You ---");
        for (Movie m : library) {
            if (watchedGenres.contains(m.genre) && !watchHistory.contains(m)) {
                System.out.println("Because you like " + m.genre + ": " + m.title);
            }
        }
    }
    
    public void addMovieToLibrary(Movie m) {
        library.add(m);
    }
}