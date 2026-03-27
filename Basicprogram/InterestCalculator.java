public class InterestCalculator {


    public static double calculateInterest(double amount, double rate, int years) 
            throws IllegalArgumentException {
        

        if (amount < 0) {
            throw new IllegalArgumentException("Principal amount cannot be negative: " + amount);
        }
        if (rate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative: " + rate + "%");
        }

        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        try {
            double result = calculateInterest(1000, 5.5, 2);
            System.out.println("Calculated Interest: $" + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nAttempting calculation with negative rate...");
            double result = calculateInterest(5000, -1.5, 3);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("Caught an Exception: " + e.getMessage());
        }
    }
}