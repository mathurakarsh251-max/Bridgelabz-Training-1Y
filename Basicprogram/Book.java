class Book {
    String title;
    String author;
    double price;
    Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
        System.out.println("Default Constructor Called: Empty book created.");
    }
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        System.out.println("Parameterized Constructor Called: Book '" + title + "' created.");
    }
    void displayBookInfo() {
        System.out.println("Title:  " + title);
        System.out.println("Author: " + author);
        System.out.println("Price:  ₹" + price);
        System.out.println("---------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Book emptyBook = new Book();
        emptyBook.displayBookInfo();
        Book favoriteBook = new Book("The Alchemist", "Paulo Coelho", 350.00);
        favoriteBook.displayBookInfo();
    }
}