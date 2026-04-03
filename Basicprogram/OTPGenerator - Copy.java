import java.util.Arrays;

public class OTPGenerator {

    public static void main(String[] args) {
        int[] otpList = new int[10];

        System.out.println("Generating 10 OTPs...");
        for (int i = 0; i < otpList.length; i++) {
            otpList[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otpList[i]);
        }
        if (isUnique(otpList)) {
            System.out.println("\nValidation Success: All 10 OTPs are unique.");
        } else {
            System.out.println("\nValidation Failure: Duplicate OTP detected!");
        }
    }
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }
    public static boolean isUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}