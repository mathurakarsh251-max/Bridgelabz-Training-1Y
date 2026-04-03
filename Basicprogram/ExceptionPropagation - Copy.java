public class ExceptionPropagation {


    public static void method1() {
        System.out.println("Inside method1: Attempting division...");
        int result = 10 / 0; 
        System.out.println("Result: " + result); 
    }
    public static void method2() {
        System.out.println("Inside method2: Calling method1...");
        method1();
        System.out.println("Back in method2."); 
    }

    public static void main(String[] args) {
        System.out.println("Inside main: Calling method2...");
        
        try {
            method2();
        } catch (ArithmeticException e) {
            System.err.println("Exception handled in main: " + e.toString());
        }

        System.out.println("Program continues normally after handling the error.");
    }
}