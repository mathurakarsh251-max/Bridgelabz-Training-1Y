import java.util.Arrays;

public class ZaraBonusCalculator {

    public static void main(String[] args) {
        double[][] employeeData = generateInitialData(10);
        double[][] bonusResults = calculateBonuses(employeeData);
        displayPayrollReport(employeeData, bonusResults);
    }
    public static double[][] generateInitialData(int count) {
        double[][] data = new double[count][2];
        for (int i = 0; i < count; i++) {
            data[i][0] = (Math.random() * 90000) + 10000;
            data[i][1] = (int) (Math.random() * 10) + 1;
        }
        return data;
    }
    public static double[][] calculateBonuses(double[][] initialData) {
        double[][] results = new double[initialData.length][2];
        for (int i = 0; i < initialData.length; i++) {
            double oldSalary = initialData[i][0];
            double years = initialData[i][1];
            double bonusRate = (years > 5) ? 0.05