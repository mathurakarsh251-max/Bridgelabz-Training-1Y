class Student {
    String name;
    int rollNumber;
    double marks;
    Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    String calculateGrade() {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "Fail";
        }
    }
    void displayReport() {
        System.out.println("--------- Student Report ---------");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name:        " + name);
        System.out.println("Marks:       " + marks + "%");
        System.out.println("Grade:       " + calculateGrade());
        System.out.println("----------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Rohit Sharma", 22, 88.5);
        Student student2 = new Student("Sneha Verma", 45, 42.0);
        student1.displayReport();
        student2.displayReport();
    }
}