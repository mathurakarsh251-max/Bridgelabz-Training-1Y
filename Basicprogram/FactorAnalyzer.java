import java.util.Arrays;

public class FactorAnalyzer {

    public static void main(String[] args) {
        int number = 12;
        int[] factors = findFactors(number);
        System.out.println("Factors of " + number + ": " + Arrays.toString(factors));
        int greatest = findGreatestFactor(factors);
        System.out.println("Greatest Factor: " + greatest);
        int sum = findSumOfFactors(factors);
        System.out.println("Sum of Factors: " + sum);
        long product = findProductOfFactors(factors);
        System.out.println("Product of Factors: " + product);
        double cubeProduct = findProductOfCubes(factors);
        System.out.printf("Product of Cubes of Factors: %.2e%n", cubeProduct);
    }
    public static int[] findFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }
    public static int findGreatestFactor(int[] factors) {
        if (factors.length == 0) return 0;
        int max = factors[0];
        for (int f : factors) {
            max = Math.max(max, f);
        }
        return max;
    }
    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) {
            sum += f;
        }
        return sum;
    }
    public static long findProductOfFactors(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= f;
        }
        return product;
    }
    public static double findProductOfCubes(int[] factors) {
        double product = 1.0;
        for (int f : factors) {
            product *= Math.pow(f, 3);
        }
        return product;
    }
}