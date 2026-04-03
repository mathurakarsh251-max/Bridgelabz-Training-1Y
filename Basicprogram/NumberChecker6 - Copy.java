public class NumberChecker {

    public static void main(String[] args) {
        int[] testNumbers = {7, 9, 22, 25, 1124};

        for (int n : testNumbers) {
            System.out.println("--- Analysis for: " + n + " ---");
            System.out.println("Is Prime?       " + isPrime(n));
            System.out.println("Is Neon?        " + isNeon(n));
            System.out.println("Is Spy?         " + isSpy(n));
            System.out.println("Is Automorphic? " + isAutomorphic(n));
            System.out.println("Is Buzz?        " + isBuzz(n));
            System.out.println();
        }
    }
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static boolean isNeon(int n) {
        int square = n * n;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == n;
    }
    public static boolean isSpy(int n) {
        int sum = 0;
        int product = 1;
        int temp = Math.abs(n);
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }
    public static boolean isAutomorphic(int n) {
        int square = n * n;
        String s1 = Integer.toString(n);
        String s2 = Integer.toString(square);
        return s2.endsWith(s1);
    }
    public static boolean isBuzz(int n) {
        return (n % 7 == 0) || (n % 10 == 7);
    }
}