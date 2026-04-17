import java.util.*;
import java.util.stream.Collectors;

class Movie {
    String title;
    double rating;
    int releaseYear;

    public Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public double getRating() { return rating; }
    public int getReleaseYear() { return releaseYear; }

    @Override
    public String toString() {
        return String.format("%-20s | Rating: %.1f | Year: %d", title, rating, releaseYear);
    }
}

public class TrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Inception", 8.8, 2010),
            new Movie("The Dark Knight", 9.0, 2008),
            new Movie("Interstellar", 8.6, 2014),
            new Movie("The Godfather", 9.2, 1972),
            new Movie("Parasite", 8.6, 2019),
            new Movie("Avengers: Endgame", 8.4, 2019),
            new Movie("The Matrix", 8.7, 1999),
            new Movie("Pulp Fiction", 8.9, 1994)
        );
        List<Movie> trendingMovies = movies.stream()
            .filter(m -> m.getRating() > 8.5)
            .sorted(Comparator.comparing(Movie::getRating).reversed()
                              .thenComparing(Comparator.comparing(Movie::getReleaseYear).reversed()))
            
            .limit(5)
            .collect(Collectors.toList());

        System.out.println("--- Top 5 Trending Movies ---");
        trendingMovies.forEach(System.out::println);
    }
}