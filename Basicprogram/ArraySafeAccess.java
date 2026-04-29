public class ArraySafeAccess {
    public static void main(String[] args) {
        int[] myNumbers = {10, 20, 30, 40, 50};
        printValueAtIndex(myNumbers, 2); 
        printValueAtIndex(myNumbers, 10); 
        int[] emptyArray = null;
        printValueAtIndex(emptyArray, 0); 
    }

    public static void printValueAtIndex(int[] arr, int index) {
        try {
            int value = arr[index]; 
            System.out.println("Value at index " + index + ": " + value);

        } catch (NullPointerException e) {
            System.err.println("Error: The array has not been initialized (it is null).");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Index " + index + " is out of range. The array size is " + (arr != null ? arr.length : 0) + ".");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}