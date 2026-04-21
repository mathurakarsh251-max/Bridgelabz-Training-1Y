class Course {
    int courseId;
    String courseName;
    double price;
    
    static String platformName = "EduPulse Academy";

    public Course(int courseId, String courseName, double price) {
        this.courseId = courseId;
        this.price = price;
        this.courseName = toTitleCase(courseName);
    }
    private String toTitleCase(String input) {
        if (input == null || input.isEmpty()) return input;
        
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toLowerCase().toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toUpperCase(c);
                nextTitleCase = false;
            }
            titleCase.append(c);
        }
        return titleCase.toString();
    }

    public double getFinalPrice() {
        return price;
    }

    public void displayDetails() {
        System.out.printf("[%d] Course: %-25s | Platform: %s%n", 
                          courseId, courseName, platformName);
    }
}

class RecordedCourse extends Course {
    public RecordedCourse(int courseId, String courseName, double price) {
        super(courseId, courseName, price);
    }

    @Override
    public double getFinalPrice() {
        return price * 0.90;
    }
}

class LiveCourse extends Course {
    public LiveCourse(int courseId, String courseName, double price) {
        super(courseId, courseName, price);
    }

    @Override
    public double getFinalPrice() {
        return price * 0.95; 
    }
}

public class LearningPlatform {
    public static void main(String[] args) {
        Course[] catalog = {
            new RecordedCourse(101, "java programming for beginners", 1000),
            new LiveCourse(202, "ADVANCED DATA SCIENCE", 5000),
            new RecordedCourse(303, "web development bootCAMP", 2500)
        };

        System.out.println("--- " + Course.platformName + " Catalog ---");
        for (Course c : catalog) {
            c.displayDetails();
            System.out