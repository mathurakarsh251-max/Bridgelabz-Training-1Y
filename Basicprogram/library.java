package library.books;

public class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }

    public void displayBook() {
        System.out.println("Book: " + title + " by " + author + " [ISBN: " + isbn + "]");
    }
}
package library.members;

public class Member {
    private String name;
    private int memberId;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() { return name; }

    public void displayMember() {
        System.out.println("Member: " + name + " (ID: " + memberId + ")");
    }
}
package library.transactions;

import library.books.Book;
import library.members.Member;
import java.time.LocalDate;

public class Transaction {
    public void issueBook(Book book, Member member) {
        System.out.println("--- Transaction Log ---");
        System.out.println("Action: Issuing Book");
        System.out.println("Book '" + book.getTitle() + "' issued to " + member.getName());
        System.out.println("Date: " + LocalDate.now());
    }
}
import library.books.Book;
import library.members.Member;
import library.transactions.Transaction;

public class LibraryApp {
    public static void main(String[] args) {
        Book b1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        b1.displayBook();
        Member m1 = new Member("Akarsh", 5001);
        m1.displayMember();

        System.out.println();
        Transaction librarySystem = new Transaction();
        librarySystem.issueBook(b1, m1);
    }
}