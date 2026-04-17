import java.util.Scanner;

public class HandshakeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = input.nextInt();
        long handshakes = (long) n * (n - 1) / 2;
        System.out.println("For " + n + " students, the maximum number of handshakes is: " + handshakes);

        input.close();
    }
}