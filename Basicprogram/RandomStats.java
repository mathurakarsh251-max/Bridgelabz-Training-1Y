import java.util.Scanner;

public class RandomStats {

    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);
        System.out.println("Generated 4-Digit Numbers:");
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n----------------------------");
        double[] stats = findAverageMinMax(randomNumbers);
        System.out.printf("Average Value: %.2f%n", stats[0]);
        System.out.println("Minimum Value: " + (int)stats[1]);
        System.out.println("Maximum Value: " + (int)stats[2]);
    }
    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random() * 9000) + 1000;
        }
        return arr;
    }
    public static double[] findAverageMinMax(int[] numbers) {
        if (numbers.length == 0) return new double[]{0, 0, 0};

        int min = numbers[0];
        int max = numbers[0];
        double sum = 0;

        for (int num : numbers) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
        }

        double average = sum / numbers.length;
        return new double[]{average, (double)min, (double)max};
    }
}