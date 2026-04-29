public class UnitConvertor {
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }
    public static void main(String[] args) {
        System.out.println("--- Length Conversions ---");
        System.out.printf("10 Yards to Feet: %.2f ft%n", convertYardsToFeet(10));
        System.out.printf("9 Feet to Yards: %.2f yd%n", convertFeetToYards(9));
        System.out.printf("2 Meters to Inches: %.2f in%n", convertMetersToInches(2));
        System.out.printf("36 Inches to Meters: %.4f m%n", convertInchesToMeters(36));
        System.out.printf("5 Inches to Centimeters: %.2f cm%n", convertInchesToCentimeters(5));
    }
}