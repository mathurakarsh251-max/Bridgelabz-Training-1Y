class PalindromeChecker {
    String text;
    PalindromeChecker(String text) {
        this.text = text;
    }
    boolean isPalindrome() {
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        String reversed = "";

        for (int i = cleanText.length() - 1; i >= 0; i--) {
            reversed += cleanText.charAt(i);
        }

        return cleanText.equals(reversed);
    }
    void displayResult() {
        System.out.println("Input Text: " + text);
        if (isPalindrome()) {
            System.out.println("Result: It is a Palindrome!");
        } else {
            System.out.println("Result: Not a Palindrome.");
        }
        System.out.println("---------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        PalindromeChecker pc1 = new PalindromeChecker("Radar");
        PalindromeChecker pc2 = new PalindromeChecker("Hello World");

        pc1.displayResult();
        pc2.displayResult();
    }
}
class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = "Not Assigned";
        this.price = 0.0;
    }
    void bookTicket(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Success: Ticket booked for " + movieName);
    }
    void displayTicketDetails() {
        System.out.println("******* MOVIE TICKET *******");
        System.out.println("Movie:  " + movieName);
        System.out.println("Seat:   " + seatNumber);
        System.out.println("Price:  ₹" + price);
        System.out.println("****************************");
    }
}

public class Main {
    public static void main(String[] args) {
        MovieTicket myTicket = new MovieTicket("The Dark Knight");
        myTicket.bookTicket("A-12", 450.00);
        myTicket.displayTicketDetails();
    }
}