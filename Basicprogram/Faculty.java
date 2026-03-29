package college.student;

public class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public void displayStudentDetails() {
        System.out.println("--- Student Information ---");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }
}
package college.faculty;

public class Faculty {
    private String name;
    private String subject;

    public Faculty(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void displayFacultyDetails() {
        System.out.println("--- Faculty Information ---");
        System.out.println("Name: " + name);
        System.out.println("Subject: " + subject);
    }
}
import college.student.Student;
import college.faculty.Faculty;

public class CollegeManagement {
    public static void main(String[] args) {
        Student s1 = new Student("Akarsh", 101); 
        Faculty f1 = new Faculty("Dr. Sharma", "Computer Science");
        s1.displayStudentDetails();
        System.out.println();
        f1.displayFacultyDetails();
    }
}