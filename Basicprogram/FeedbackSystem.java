import java.util.*;

public class FeedbackSystem {
    private List<String> feedbackLog = new ArrayList<>();  
    private Set<String> uniqueFeedback = new HashSet<>();    
    private Queue<String> processingQueue = new LinkedList<>(); 
    private Stack<String> recentReviewStack = new Stack<>(); 
    public void addFeedback(String message) {
        feedbackLog.add(message);
        if (uniqueFeedback.add(message)) {
            processingQueue.add(message);
            System.out.println("Feedback added to queue.");
        } else {
            System.out.println("Duplicate feedback ignored for processing.");
        }
    }
    public void processNext() {
        if (!processingQueue.isEmpty()) {
            String current = processingQueue.poll(
            recentReviewStack.push(current);
            
            System.out.println("Processed: " + current);
        } else {
            System.out.println("No feedback to process.");
        }
    }
    public void showRecentReviews(int count) {
        System.out.println("\n--- Quick Review (Recent First) ---");
        int displayed = 0;
        for (int i = recentReviewStack.size() - 1; i >= 0 && displayed < count; i--) {
            System.out.println((displayed + 1) + ". " + recentReviewStack.get(i));
            displayed++;
        }
    }
}