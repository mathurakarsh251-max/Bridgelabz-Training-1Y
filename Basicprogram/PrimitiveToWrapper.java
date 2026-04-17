import java.util.Scanner;

public class PrimitiveToWrapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int primitiveInt = scanner.nextInt();
        Integer wrapperInt = Integer.valueOf(primitiveInt);
        System.out.println("\n--- Conversion Results ---");
        System.out.println("Primitive int value: " + primitiveInt);
        System.out.println("Integer Object value: " + wrapperInt);
        if (wrapperInt instanceof Integer) {
            System.out.println("Success: The value has been converted to an Integer object.");
        }

        scanner.close();
    }
}