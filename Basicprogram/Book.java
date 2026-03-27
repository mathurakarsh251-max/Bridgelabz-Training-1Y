class Book {
    int bookId;
    String title;
    double price;
    static String libraryName = "City Global Library";
    public Book(int bookId, String title, double price) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
    }
    public double calculateFine(int daysLate) {
        return 0; 
    }

    public void displayInfo() {
        System.out.println("ID: " + bookId + " | Title: " + title + " | Library: " + libraryName);
    }
}

class TextBook extends Book {
    public TextBook(int bookId, String title, double price) {
        super(bookId, title, price);
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 2.0; 
    }
}

class Magazine extends Book {
    public Magazine(int bookId, String title, double price) {
        super(bookId, title, price);
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 5.0; 
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new TextBook(101, "Java Programming", 500);
        Book b2 = new Magazine(202, "Tech Today", 150);

        int lateDays = 10;

        b1.displayInfo();
        System.out.println("Fine for TextBook: ₹" + b1.calculateFine(lateDays));

        System.out.println("---");

        b2.displayInfo();
        System.out.println("Fine for Magazine: ₹" + b2.calculateFine(lateDays));
    }
}