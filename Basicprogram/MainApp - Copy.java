module collegeinfo {
    exports college.student;
}
package college.student;

public class Student {
    public void display() {
        System.out.println("Modular Student: Access granted from collegeinfo module.");
    }
}
module app {
    requires collegeinfo;
}
package main;
import college.student.Student;

public class MainApp {
    public static void main(String[] args) {
        Student s = new Student();
        s.display();
    }
}