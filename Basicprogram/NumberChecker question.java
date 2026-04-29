public class NumberChecker {

    public static void main(String[] args) {
        int[] testNumbers = {6, 12, 8, 145};

        for (int n : testNumbers) {
            System.out.println("--- Analysis for: " + n + " ---");
            int divisorSum = sumOfProperDivisors(n);
            System.out.println("Sum of Proper Divisors: " + divisorSum);
            System.out.println("Is Perfect?   " + isPerfect(n, divisorSum));
            System.out.println("Is Abundant?  " + isAbundant(n, divisorSum));
            System.out.println("Is Deficient? " + isDeficient(n, divisorSum));
            System.out.println("Is Strong?    " + isStrong(n));
            System.out.println();
        }
    }
    public static int sumOfProperDivisors(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
    public static boolean isPerfect(int n, int divisorSum) {
        return n > 0 && divisorSum == n;
    }
    public static boolean isAbundant(int n, int divisorSum) {
        return n > 0 && divisorSum > n;
    }
    public static boolean isDeficient(int n, int divisorSum) {
        return n > 0 && divisorSum < n;
    }
    public static boolean isStrong(int n) {
        int original = n;
        int sum = 0;
        if (n == 0) return false;
        
        while (n > 0) {
            int digit = n % 10;
            sum += factorial(digit);
            n /= 1