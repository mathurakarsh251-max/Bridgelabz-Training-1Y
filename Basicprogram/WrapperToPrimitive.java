public class WrapperToPrimitive {
    public static void main(String[] args) {
        Double doubleObject = 45.67;
        double primitiveDouble = doubleObject;
        int primitiveInt = (int) doubleObject.doubleValue();
        System.out.println("Wrapper Double object: " + doubleObject);
        System.out.println("Primitive double value: " + primitiveDouble);
        System.out.println("Primitive int value (after casting): " + primitiveInt);
    }
}