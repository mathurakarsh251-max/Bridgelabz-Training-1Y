import java.util.ArrayList;

public class StudentMarksReport {
    public static void main(String[] args) {
        Object[] rawInputs = {"85", 95, Integer.valueOf(88), "null", "abc", 72};

        ArrayList<Integer> validMarks = new ArrayList<>();

        System.out.println("--- Processing Student Marks ---");

        for (Object input : rawInputs) {
            try {
                if (input == null || input.equals("null")) {
                    continue; 
                }

                Integer mark = null;
                if (input instanceof String) {
                    mark = Integer.parseInt((String) input);
                } 
                else if (input instanceof Integer) {
                    mark = (Integer) input;
                }

                if (mark != null) {
                    validMarks.add(mark);
                    System.out.println("Valid Mark Added: " + mark);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid Entry Skipped: " + input);
            }
        }
        double sum = 0;
        for (Integer m : validMarks) {
            sum += m; 
        }

        double average = validMarks.isEmpty() ? 0.0 : sum / validMarks.size();

        System.out.println("\n--- Marks Report Summary ---");
        System.out.println("Total Valid Records: " + validMarks.size());
        System.out.printf("Class Average: %.2f\n", average);
    }
}