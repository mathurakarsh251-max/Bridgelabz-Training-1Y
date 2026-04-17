import java.util.ArrayList;
import java.util.List;

public class MathOperations {
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(10, 20, 30);
        System.out.println("Sum of Integers: " + sumNumbers(intList));
        List<Double> doubleList = List.of(1.5, 2.5, 3.0);
        System.out.println("Sum of Doubles: " + sumNumbers(doubleList));
    }
}