import java.util.Scanner;

public class LeapYearNested {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year (1582 or later): ");
        int year = scanner.nextInt();
        if (year < 1582) {
            System.out.println("The Gregorian calendar leap year rules do not apply before 1582.");
        } else {
            if (year % 400 == 0) {
                System.out.println(year + " is a Leap Year.");
            } else if (year % 100 == 0) {
                System.out.println(year + " is NOT a Leap Year.");
            } else if (year % 4 == 0) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is NOT a Leap Year.");
            }
        }
        scanner.close();
    }
}