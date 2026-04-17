interface Reservable {
    void reserveItem(String memberId);
    boolean checkAvailability();
}
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrowerId; 

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    public abstract int getLoanDuration();
    public void getItemDetails() {
        System.out.println("[" + itemId + "] Title: " + title + " | Author/Creator: " + author);
    }
    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    protected String getBorrowerId() { return borrowerId; }
    public void setBorrowerId(String borrowerId) { this.borrowerId = borrowerId; }
}
class Book extends LibraryItem implements Reservable {
    private boolean isReserved = false;

    public Book(String id, String title, String author) { super(id, title, author); }

    @Override
    public int getLoanDuration() { return 21; } 

    @Override
    public void reserveItem(String memberId) { this.isReserved = true; }

    @Override
    public boolean checkAvailability() { return !isReserved; }
}

class Magazine extends LibraryItem {
    public Magazine(String id, String title, String author) { super(id, title, author); }

    @Override
    public int getLoanDuration() { return 7; } 
}

class DVD extends LibraryItem implements Reservable {
    private boolean isReserved = false;

    public DVD(String id, String title, String author) { super(id, title, author); }

    @Override
    public int getLoanDuration() { return 3; } 

    @Override
    public void reserveItem(String memberId) { this.isReserved = true; }

    @Override
    public boolean checkAvailability() { return !isReserved; }
}
import java.util.*;

public class LibraryApp {
    public static void main(String[] args) {
        List<LibraryItem> catalog = new ArrayList<>();

        catalog.add(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        catalog.add(new Magazine("M002", "National Geographic", "Various"));
        catalog.add(new DVD("D003", "Inception", "Christopher Nolan"));

        System.out.println("--- Library Catalog Status ---");
        for (LibraryItem item : catalog) {
            item.getItemDetails();
            System.out.println(" - Loan Period: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable res = (Reservable) item;
                String status = res.checkAvailability() ? "Available" : "Reserved";
                System.out.println(" - Status: " + status);
            } else {
                System.out.println(" - Status: Reference Only (Not Reservable)");
            }
            System.out.println("--------------------------------");
        }
    }
}