public class WrapperUtilities {
    public static void main(String[] args) {
        int intValue = Integer.parseInt("123");
        double doubleValue = Double.parseDouble("3.14");
        boolean boolValue = Boolean.parseBoolean("true");
        String binaryString = Integer.toBinaryString(10);
        boolean checkDigit = Character.isDigit('5');
        char upperCaseChar = Character.toUpperCase('a');
        System.out.println("--- Parsing Methods ---");
        System.out.println("Integer.parseInt(\"123\")    -> " + intValue);
        System.out.println("Double.parseDouble(\"3.14\")  -> " + doubleValue);
        System.out.println("Boolean.parseBoolean(\"true\") -> " + boolValue);

        System.out.println("\n--- Conversion Methods ---");
        System.out.println("Integer.toBinaryString(10)   -> " + binaryString);

        System.out.println("\n--- Character Methods ---");
        System.out.println("Character.isDigit('5')       -> " + checkDigit);
        System.out.println("Character.toUpperCase('a')   -> " + upperCaseChar);
    }
}