package college.student;

public class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getInfo() {
        return "Student: " + name + " (ID: " + id + ")";
    }
}
package college.faculty;

public class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getInfo() {
        return "Faculty: " + name + " | Specialization: " + specialization;
    }
}
package college.department;

import static java.lang.Math.*; 

public class Department {
    private String deptName;
    private int capacity;

    public Department(String name, int cap) {
        this.deptName = name;
        this.capacity = cap;
    }

    public void displayDeptStats(int currentEnrollment) {
        System.out.println("Department: " + deptName);
        int remaining = max(0, capacity - currentEnrollment); 
        System.out.println("Capacity: " + capacity + " | Available Seats: " + remaining);
    }
}
import college.student.Student;
import college.faculty.Faculty;
import college.department.Department;

public class MainApp {
    public static void main(String[] args) {
        Student s1 = new Student("Akarsh", 2025001);
        Faculty f1 = new Faculty("Dr. Kapoor", "Artificial Intelligence");
        Department d1 = new Department("Computer Science", 120);
        System.out.println("========== COLLEGE MANAGEMENT SYSTEM ==========");
        System.out.println(s1.getInfo());
        System.out.println(f1.getInfo());
        System.out.println("-----------------------------------------------");
        d1.displayDeptStats(85); 
        System.out.println("===============================================");
    }
}