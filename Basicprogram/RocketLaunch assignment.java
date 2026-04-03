import java.util.Scanner;

public class RocketLaunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the countdown start value: ");
        int startValue = scanner.nextInt();

        System.out.println("Rocket preparing for launch...");
        for (int i = startValue; i >= 1; i--) {
            System.out.println(i + "...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Launch aborted!");
            }
        }
        System.out.println("0! 🚀 BLAST OFF!");

        scanner.close();
    }
}