package com.university.department.cse;

public class Course {
    private String courseName;
    private String courseCode;

    public Course(String name, String code) {
        this.courseName = name;
        this.courseCode = code;
    }

    public void displayCourseDetails() {
        System.out.println("--- Course Details ---");
        System.out.println("Department: Computer Science & Engineering");
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Code: " + courseCode);
    }
}
import com.university.department.cse.Course;

public class MainApp {
    public static void main(String[] args) {
        Course myCourse = new Course("Object Oriented Programming", "CSE-101");
        myCourse.displayCourseDetails();
    }
}