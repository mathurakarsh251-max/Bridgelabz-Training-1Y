class Student {
    int rollNo;
    String name;
    double marks;

    public Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public String calculateGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 75) return "A";
        else if (marks >= 60) return "B";
        else return "C";
    }

    public void displayResult() {
        System.out.println("Roll No: " + rollNo + " | Name: " + name);
        System.out.println("Result: " + calculateGrade());
    }
}

class EngineeringStudent extends Student {
    String branch;

    public EngineeringStudent(int rollNo, String name, double marks, String branch) {
        super(rollNo, name, marks);
        this.branch = branch;
        this.name = name + " [" + branch + "]";
    }

    @Override
    public void displayResult() {
        System.out.println("--- Engineering Faculty Result ---");
        super.displayResult();
    }
}

public class UniversitySystem {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice Gupta", 88.5);
        Student s2 = new EngineeringStudent(502, "Rahul Sharma", 92.0, "Mechanical");

        s1.displayResult();
        System.out.println();
        s2.displayResult();
    }
}