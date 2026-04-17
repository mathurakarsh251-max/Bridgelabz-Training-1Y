import java.util.Scanner;

public class CalendarGenerator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter month (1-12) and year (e.g., 07 2005): ");
        int m = input.nextInt();
        int y = input.nextInt();
        String monthName = getMonthName(m);
        int numDays = getDaysInMonth(m, y);
        int startDay = getFirstDayOfMonth(1, m, y);
        System.out.println("\n   " + monthName + " " + y);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }
        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%3d ", day);
            if (((day + startDay) % 7 == 0) || (day == numDays)) {
                System.out.println();
            }
        }
    }
    public static String getMonthName(int m) {
        String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[m];
    }
    public static int getDaysInMonth(int m, int y) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (m == 2 && isLeapYear(y)) return 29;
        return days[m];
    }

    public static boolean isLeapYear(int y) {
        return (y % 400 == 0) || (y % 4 == 0 && y % 100 != 0);
    }