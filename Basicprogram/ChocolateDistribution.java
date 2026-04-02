import java.util.Scanner;

public class ChocolateDistribution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of chocolates (N): ");
        int numberOfChocolates = input.nextInt();

        System.out.print("Enter the number of children (M): ");
        int numberOfChildren = input.nextInt();
        if (numberOfChildren <= 0) {
            System.out.println("The number of children must be greater than zero.");
        } else {
            int[] results = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
            System.out.println("Each child gets: " + results[0] + " chocolates.");
            System.out.println("Remaining chocolates: " + results[1]);
        }

        input.close();
    }
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;   
        int remainder = number % divisor;  
        
        return new int[]{quotient, remainder};
    }
}