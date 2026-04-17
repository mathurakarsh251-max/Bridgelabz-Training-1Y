class Book {
    String isbn;
    String title;
    boolean isAvailable;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return title + " (ISBN: " + isbn + ")";
    }
}
import java.util.*;

public class LibraryManager {
    private List<Book> totalInventory = new ArrayList<>();
    private Set<String> memberIds = new HashSet<>();
    private Queue<Book> issueQueue = new LinkedList<>();
    private Stack<Book> returnedStack = new Stack<>();
    public void addBook(Book book) {
        totalInventory.add(book);
        System.out.println("Added to inventory: " + book.title);
    }
    public void registerMember(String memberId) {
        if (memberIds.add(memberId)) {
            System.out.println("Member " + memberId + " registered.");
        } else {
            System.out.println("Member ID " + memberId + " already exists.");
        }
    }
    public void requestBook(Book book) {
        if (book.isAvailable) {
            issueQueue.add(book);
            book.isAvailable = false;
            System.out.println("Book queued for issue: " + book.title);
        }
    }

    public void processIssue() {
        if (!issueQueue.isEmpty()) {
            Book b = issueQueue.poll();
            System.out.println("Issued: " + b.title);
        }
    }
    public void returnBook(Book book) {
        book.isAvailable = true;
        returnedStack.push(book);
        System.out.println("Book returned: " + book.title + ". Placed on quick-access stack.");
    }

    public void quickReissue() {
        if (!returnedStack.isEmpty()) {
            Book recent = returnedStack.pop();
            recent.isAvailable = false;
            System.out.println("Quick Re-issued: " + recent.title);
        } else {
            System.out.println("No recently returned books available for quick re-issue.");
        }
    }
}