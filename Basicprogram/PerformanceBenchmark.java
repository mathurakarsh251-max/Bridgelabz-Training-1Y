import java.util.ArrayList;

public class PerformanceBenchmark {
    public static void main(String[] args) {
        int size = 1,000,000;
        long startPrimitive = System.currentTimeMillis();
        int[] primitiveArray = new int[size];
        long sumPrimitive = 0;

        for (int i = 0; i < size; i++) {
            primitiveArray[i] = i;
        }
        for (int num : primitiveArray) {
            sumPrimitive += num;
        }
        long endPrimitive = System.currentTimeMillis();
        long startWrapper = System.currentTimeMillis();
        ArrayList<Integer> wrapperList = new ArrayList<>(size);
        long sumWrapper = 0;

        for (int i = 0; i < size; i++) {
            wrapperList.add(i); 
        }
        for (Integer num : wrapperList) {
            sumWrapper += num; 
        }
        long endWrapper = System.currentTimeMillis();
        System.out.println("--- Performance Results (1 Million Elements) ---");
        System.out.println("Primitive int[] time: " + (endPrimitive - startPrimitive) + " ms");
        System.out.println("ArrayList<Integer> time: " + (endWrapper - startWrapper) + " ms");
        System.out.println("------------------------------------------------");
        System.out.println("Check: Sums match? " + (sumPrimitive == sumWrapper));
    }
}