class HotelBooking {
    String guestName;
    String roomType;
    int nights;
    HotelBooking() {
        this.guestName = "Pending";
        this.roomType = "Not Assigned";
        this.nights = 0;
        System.out.println("Default Constructor: Created a blank booking slot.");
    }
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
        System.out.println("Parameterized Constructor: Created booking for " + guestName);
    }
    HotelBooking(HotelBooking existingBooking) {
        this.guestName = existingBooking.guestName;
        this.roomType = existingBooking.roomType;
        this.nights = existingBooking.nights;
        System.out.println("Copy Constructor: Cloned booking from " + existingBooking.guestName);
    }
    void displayBooking() {
        System.out.println("--------- Reservation Details ---------");
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type:  " + roomType);
        System.out.println("Duration:   " + nights + " nights");
        System.out.println("---------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        HotelBooking booking1 = new HotelBooking("Vikram Singh", "Deluxe Suite", 3);
        booking1.displayBooking();
        HotelBooking booking2 = new HotelBooking(booking1);
        booking2.displayBooking();
        HotelBooking emptyBooking = new HotelBooking();
        emptyBooking.displayBooking();
    }
}