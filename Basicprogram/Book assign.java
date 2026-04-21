class Book {
    public String isbn;
    protected String title;
    private String author;
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        if (author != null && !author.isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Invalid Author Name!");
        }
    }
}
class EBook extends Book {
    double fileSizeMB;

    public EBook(String isbn, String title, String author, double fileSizeMB) {
        super(isbn, title, author); 
        this.fileSizeMB = fileSizeMB;
    }

    public void displayEBookInfo() {
        System.out.println("======= E-Book Details =======");
        System.out.println("ISBN:   " + isbn); 
        System.out.println("Title:  " + title); 
        System.out.println("Author: " + getAuthor());
        
        System.out.println("Size:   " + fileSizeMB + " MB");
        System.out.println("==============================");
    }
}

public class Main {
    public static void main(String[] args) {
        EBook myEBook = new EBook("978-3-16", "The Digital Age", "Dr. Arjun", 15.5);
        myEBook.isbn = "978-0-00"; 
        myEBook.setAuthor("Arjun Singh");
        myEBook.displayEBookInfo();
    }
}