import java.util.Scanner;

public class ArrayBoundsDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many names would you like to enter? ");
        int size = scanner.nextInt();
        String[] names = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter name #" + (i + 1) + ": ");
            names[i] = scanner.next();
        }
        handleException(names);

        scanner.close();
    }
    public static void generateException(String[] names) {
        System.out.println("\n--- Attempting to access an index beyond array length ---");
        String ghostName = names[names.length]; 
        
        System.out.println("This will never print: " + ghostName);
    }
    public static void handleException(String[] names) {
        System.out.println("\n--- Demonstrating Try-Catch for Array Bounds ---");
        
        try {
            int badIndex = names.length + 10;
            System.out.println("Trying to access index: " + badIndex);
            
            String name = names[badIndex];
            System.out.println("Name found: " + name);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: That index is outside the array!");
            System.out.println("Error details: " + e.toString());
            
        } catch (RuntimeException e) {
            System.out.println("Caught a generic RuntimeException: " + e.getMessage());
        } finally {
            System.out.println("Array access attempt finished.");
        }
    }
}