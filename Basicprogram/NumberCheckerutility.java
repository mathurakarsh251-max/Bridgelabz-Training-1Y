import java.util.Arrays;

public class NumberChecker {

    public static void main(String[] args) {
        int testNumber = 121; 
        
        System.out.println("Analyzing Number: " + testNumber);
        int count = countDigits(testNumber);
        int[] originalDigits = getDigitsArray(testNumber, count);
        int[] reversedDigits = reverseArray(originalDigits);
        boolean isPalin = isPalindrome(originalDigits, reversedDigits);
        System.out.println("Original Array: " + Arrays.toString(originalDigits));
        System.out.println("Reversed Array: " + Arrays.toString(reversedDigits));
        System.out.println("Is Palindrome? " + isPalin);
        System.out.println("Is Duck Number? " + isDuckNumber(originalDigits));
    }
    public static int countDigits(int num) {
        if (num == 0) return 1;
        return String.valueOf(Math.abs(num)).length();
    }
    public static int[] getDigitsArray(int num, int size) {
        int[] digits = new int[size];
        int temp = Math.abs(num);
        for (int i = size - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }
    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }