public class SignupValidator {

    public static void main(String[] args) {
        String[] testInputs = {"25", "17", "abc", "18", "21.5"};

        System.out.println("--- Signup Age Validation ---");
        for (String input : testInputs) {
            boolean result = isValidAge(input);
            System.out.println("Input: \"" + input + "\" -> Eligible for Signup: " + result);
        }
    }
    public static boolean isValidAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr);
            if (age >= 18) {
                return true;
            } else {
                System.out.println("[Validation] User is under 18.");
                return false;
            }

        } catch (NumberFormatException e) {
            System.out.println("[Error] Invalid input: '" + ageStr + "' is not a valid integer.");
            return false;
        }
    }
}