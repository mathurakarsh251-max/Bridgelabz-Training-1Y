import java.util.*;

public class WebsiteVisitTracker {
    public static void main(String[] args) {
        Map<String, Integer> visitCounts = new HashMap<>();
        String[] sessionLogs = {
            "home", "about", "products", "home", 
            "products", "contact", "home", "products", "products"
        };
        for (String page : sessionLogs) {
            recordVisit(visitCounts, page);
        }
        printSessionReport(visitCounts);
        printMostVisited(visitCounts);
    }
    public static void recordVisit(Map<String, Integer> map, String page) {
        map.merge(page, 1, Integer::sum);
    }
    public static void printSessionReport(Map<String, Integer> map) {
        System.out.println("--- Session Summary (Sorted by Popularity) ---");
        
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(map.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " visits");
        }
    }
    public static void printMostVisited(Map<String, Integer> map) {
        if (map.isEmpty()) return;

        String topPage = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
        int visitCount = map.get(topPage);

        System.out.println("\n🔥 Most Visited Page: " + topPage + " (" + visitCount + " visits)");
    }
}