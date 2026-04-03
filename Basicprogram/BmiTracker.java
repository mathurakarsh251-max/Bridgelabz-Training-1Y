import java.util.Scanner;

public class BmiTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] rawData = new double[10][2];
        
        System.out.println("--- BMI Organization Exercise (10 Members) ---");
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("  Weight (kg): ");
            rawData[i][0] = scanner.nextDouble();
            System.out.print("  Height (cm): ");
            rawData[i][1] = scanner.nextDouble();
        }
        String[][] finalData = processBmiData(rawData);
        displayTable(finalData);

        scanner.close();
    }
    public static String[] computeIndividualBmi(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        
        String status;
        if (bmi <= 18.4) status = "Underweight";
        else if (bmi <= 24.9) status = "Normal";
        else if (bmi <= 39.9) status = "Overweight";
        else status = "Obese";
        return new String[]{String.format("%.1f", bmi), status};
    }
    public static String[][] processBmiData(double[][] rawData) {
        String[][] results = new String[rawData.length][4];

        for (int i = 0; i < rawData.length; i++) {
            double weight = rawData[i][0];
            double height = rawData[i][1];
            String[] bmiInfo = computeIndividualBmi(weight, height);

            results[i]