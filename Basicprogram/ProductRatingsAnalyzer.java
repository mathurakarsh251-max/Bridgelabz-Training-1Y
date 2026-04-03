import java.util.ArrayList;
import java.util.Objects;

public class ProductRatingsAnalyzer {
    public static void main(String[] args) {
        int[] oldSystemRatings = {4, 5, 3};
        ArrayList<Integer> newSystemRatings = new ArrayList<>();
        newSystemRatings.add(5);
        newSystemRatings.add(null); 
        newSystemRatings.add(2);
        newSystemRatings.add(4);
        ArrayList<Integer> unifiedRatings = new ArrayList<>();
        for (int rating : oldSystemRatings) {
            unifiedRatings.add(rating);
        }
        for (Integer rating : newSystemRatings) {
            if (Objects.nonNull(rating)) {
                unifiedRatings.add(rating);
            }
        }
        double sum = 0;
        for (Integer rating : unifiedRatings) {
            sum += rating;
        }

        double average = unifiedRatings.isEmpty() ? 0.0 : sum / unifiedRatings.size();
        System.out.println("Unified Ratings: " + unifiedRatings);
        System.out.println("Total Ratings Count (Non-null): " + unifiedRatings.size());
        System.out.printf("Average Product Rating: %.2f\n", average);
    }
}