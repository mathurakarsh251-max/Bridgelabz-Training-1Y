import java.util.Scanner;

public class RocketLaunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the countdown start value: ");
        int counter = scanner.nextInt();

        System.out.println("Rocket preparing for launch...");
        while (counter >= 1) {
            System.out.println(counter + "...");
            counter--; 
            try {
                Thread.sleep(1000); // Waits for 1 second
            } catch (InterruptedException e) {
                System.err.println("Countdown interrupted!");
            }
        }
        System.out.println("0! 🚀 BLAST OFF!");

        scanner.close();
    }
}