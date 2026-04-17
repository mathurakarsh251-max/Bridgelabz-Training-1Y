package com.school.data;

import java.util.Arrays;

public class Student {
    private String name;
    private double[] marks; 

    public Student(String name, double m1, double m2, double m3) {
        this.name = name;
        this.marks = new double[]{m1, m2, m3};
    }

    public String getName() { return name; }
    public double[] getMarks() { return marks; }
    @Override
    public String toString() {
        return "Student Name: " + name + " | Marks: " + Arrays.toString(marks);
    }
}
package com.school.util;

import com.school.data.Student;

public class Analyzer {
    public double calculateAverage(Student s) {
        double sum = 0;
        for (double mark : s.getMarks()) {
            sum += mark;
        }
        return sum / s.getMarks().length;
    }
    public String findGrade(double average) {
        if (average >= 90) return "A+";
        if (average >= 75) return "A";
        if (average >= 60) return "B";
        if (average >= 50) return "C";
        return "F (Fail)";
    }
}
package com.school.main;
import com.school.data.*;
import com.school.util.*;

public class MainApp {
    public static void main(String[] args) {
        Student student = new Student("Akarsh", 85.5, 92.0, 78.5);
        Analyzer analyzer = new Analyzer();
        double avg = analyzer.calculateAverage(student);
        String grade = analyzer.findGrade(avg);
        System.out.println("--- Performance Report ---");
        System.out.println(student.toString()); // Uses our custom toString()
        System.out.printf("Average Marks: %.2f\n", avg);
        System.out.println("Final Grade: " + grade);
    }
}