import java.util.Map;
import java.util.TreeMap;

public class LibraryCatalog {
    public static void main(String[] args) {
        Map<String, String> library = new TreeMap<>();
        library.put("978-0142437230", "Don Quixote");
        library.put("978-0451524935", "1984");
        library.put("978-0743273565", "The Great Gatsby");
        library.put("978-0345339706", "The Fellowship of the Ring");
        String searchIsbn = "978-0451524935";
        System.out.println("Searching for ISBN " + searchIsbn + "...");
        if (library.containsKey(searchIsbn)) {
            System.out.println("Found: " + library.get(searchIsbn));
        } else {
            System.out.println("Book not found.");
        }
        library.remove("978-0743273565");
        System.out.println("\n--- Full Library Catalog (Sorted by ISBN) ---");
        for (Map.Entry<String, String> entry : library.entrySet()) {
            System.out.println("ISBN: " + entry.getKey() + " | Title: " + entry.getValue());
        }
        System.out.println("\n--- Title Search ---");
        searchByTitle(library, "1984");
        searchByTitle(library, "The Hobbit");
    }
    public static void searchByTitle(Map<String, String> catalog, String title) {
        boolean found = false;
        for (Map.Entry<String, String> entry : catalog.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(title)) {
                System.out.println("Title '" + title + "' found with ISBN: " + entry.getKey());
                found = true;
                break; 
            }
        }
        if (!found) {
            System.out.println("Title '" + title + "' not found in catalog.");
        }
    }
}