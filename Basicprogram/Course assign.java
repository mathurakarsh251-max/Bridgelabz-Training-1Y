class Course {
    String courseName;
    int duration; 
    double fee;
    static String instituteName = "Global Learning Academy";
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " Months");
        System.out.println("Fee: ₹" + fee);
        System.out.println("Institute: " + instituteName);
        System.out.println("-----------------------------------");
    }
    static void updateInstituteName(String newName) {
        instituteName = newName;
        System.out.println(">> Institute name updated to: " + newName + " <<");
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Course javaCourse = new Course("Java Full Stack", 6, 45000.0);
        Course pythonCourse = new Course("Python Data Science", 4, 38000.0);
        javaCourse.displayCourseDetails();
        pythonCourse.displayCourseDetails();
        Course.updateInstituteName("Advanced Tech Institute");
        javaCourse.displayCourseDetails();
        pythonCourse.displayCourseDetails();
    }
}