import java.util.Scanner;

public class HandshakeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.util.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();
        int totalHandshakes = calculateMaxHandshakes(numberOfStudents);
        System.out.println("The maximum number of handshakes among " + 
                           numberOfStudents + " students is: " + totalHandshakes);

        input.close();
    }
    public static int calculateMaxHandshakes(int n) {
        if (n < 2) {
            return 0;
        }
        return (n * (n - 1)) / 2;
    }
}