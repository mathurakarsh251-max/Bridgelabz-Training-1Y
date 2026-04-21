import java.util.Scanner;

public class CustomUniversityFee {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the University Fee (INR): ");
        double fee = input.nextDouble();
        System.out.print("Enter the Discount Percentage (%): ");
        double discountPercent = input.nextDouble();
        double discountAmount = (discountPercent / 100) * fee;
        double finalFee = fee - discountAmount;
        System.out.println("The discount amount is INR " + discountAmount + 
                           " and final discounted fee is INR " + finalFee);

        input.close();
    }
}