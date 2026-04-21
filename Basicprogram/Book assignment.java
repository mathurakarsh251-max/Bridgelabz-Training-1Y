class Book {
    String title;
    String author;
    double price;
    boolean isAvailable;
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true; 
    }
    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Success: You have borrowed '" + title + "'.");
        } else {
            System.out.println("Sorry: '" + title + "' is already checked out.");
        }
    }
    void returnBook() {
        isAvailable = true;
        System.out.println("Success: '" + title + "' has been returned.");
    }
    void displayStatus() {
        String status = isAvailable ? "Available" : "Checked Out";
        System.out.println("Title:  " + title);
        System.out.println("Author: " + author);
        System.out.println("Price:  ₹" + price);
        System.out.println("Status: " + status);
        System.out.println("---------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Book myBook = new Book("The White Tiger", "Aravind Adiga", 450.00);
        myBook.displayStatus();
        myBook.borrowBook();
        myBook.borrowBook();
        myBook.displayStatus();
    }
}