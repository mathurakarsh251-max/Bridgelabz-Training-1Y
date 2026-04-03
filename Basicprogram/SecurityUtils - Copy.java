public interface SecurityUtils {
    static boolean isPasswordStrong(String password) {
        if (password == null) return false;
        boolean hasMinimumLength = password.length() >= 8;
        boolean hasDigit = password.matches(".*\\d.*");

        return hasMinimumLength && hasDigit;
    }
}
public class InsurancePortal {
    public static void main(String[] args) {
        String userPass1 = "secret123";
        String userPass2 = "weak";
        System.out.println("Checking 'secret123': " + SecurityUtils.isPasswordStrong(userPass1));
        System.out.println("Checking 'weak': " + SecurityUtils.isPasswordStrong(userPass2));
    }
}