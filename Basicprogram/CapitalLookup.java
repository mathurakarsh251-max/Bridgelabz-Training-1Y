import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class CapitalLookup {
    public static void main(String[] args) {
        Map<String, String> capitals = new TreeMap<>();
        capitals.put("India", "New Delhi");
        capitals.put("Japan", "Tokyo");
        capitals.put("Brazil", "Brasília");
        capitals.put("Canada", "Ottawa");
        capitals.put("France", "Paris");
        capitals.put("Egypt", "Cairo");
        capitals.put("Australia", "Canberra");
        capitals.put("Germany", "Berlin");
        performLookup(capitals, "Japan");
        performLookup(capitals, "Mexico");
        System.out.println("\n--- Global Capital Directory (Alphabetical) ---");
        for (Map.Entry<String, String> entry : capitals.entrySet()) {
            System.out.println("Country: " + entry.getKey() + " | Capital: " + entry.getValue());
        }
    }
    public static void performLookup(Map<String, String> map, String country) {
        System.out.print("Looking up " + country + ": ");
        if (map.containsKey(country)) {
            System.out.println("The capital is " + map.get(country));
        } else {
            System.out.println("Unknown country");
        }
    }
}