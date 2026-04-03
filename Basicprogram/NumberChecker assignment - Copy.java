public class NumberChecker {

    public static void main(String[] args) {
        int testNumber = 153; 
        
        System.out.println("Analyzing Number: " + testNumber);
        int count = countDigits(testNumber);
        System.out.println("Digit Count: " + count);
        int[] digits = getDigitsArray(testNumber);
        System.out.println("Is Duck Number? " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number? " + isArmstrong(testNumber, digits));
        int[] largestPair = findTwoLargest(digits);
        System.out.println("Largest: " + largestPair[0] + ", Second Largest: " + largestPair[1]);
        int[] smallestPair = findTwoSmallest(digits);
        System.out.println("Smallest: " + smallestPair[0] + ", Second Smallest: " + smallestPair[1]);
    }
    public static int countDigits(int num) {
        if (num == 0) return 1;
        return String.valueOf(Math.abs(num)).length();
    }
    public static int[] getDigitsArray(int num) {
        String s = String.valueOf(Math.abs(num));
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return digits;
    }
    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }
    public static boolean isArmstrong(int original, int[] digits) {
        int n = digits.length;
        long sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, n);
        }
        return sum == original;
    }
    public static int[] findTwoLargest(int[] digits) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        for (int d : digits) {
            if (d > first) {
                second = first;
                first = d;
            } else if (d > second && d != first) {
                second = d;
            }
        }
        return new int[]{first, second};
    }
    public static int[] findTwoSmallest(int[] digits) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for (int d : digits) {
            if (d < first) {
                second = first;
                first = d;
            } else if (d < second && d != first) {
                second = d;
            }
        }
        return new int[]{first, second};
    }
}