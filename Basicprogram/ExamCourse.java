import java.util.*;
abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract String getEvaluationType();

    @Override
    public String toString() {
        return getEvaluationType() + " Course: " + name;
    }
}
class ExamCourse extends CourseType {
    public ExamCourse(String name) { super(name); }
    @Override
    public String getEvaluationType() { return "Exam-Based"; }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String name) { super(name); }
    @Override
    public String getEvaluationType() { return "Assignment-Based"; }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String name) { super(name); }
    @Override
    public String getEvaluationType() { return "Research-Based"; }
}
class Course<T extends CourseType> {
    private T courseType;

    public Course(T courseType) {
        this.courseType = courseType;
    }

    public T getCourseType() { return courseType; }

    @Override
    public String toString() {
        return courseType.toString();
    }
}
class CourseUtils {
    public static void displayCourses(List<? extends CourseType> courses) {
        System.out.println("Courses offered:");
        for (CourseType c : courses) {
            System.out.println("- " + c);
        }
    }
}
public class UniversityCourseDemo {
    public static void main(String[] args) {
        List<ExamCourse> examCourses = new ArrayList<>();
        examCourses.add(new ExamCourse("Mathematics"));
        examCourses.add(new ExamCourse("Physics"));
        List<AssignmentCourse> assignmentCourses = new ArrayList<>();
        assignmentCourses.add(new AssignmentCourse("Computer Science"));
        assignmentCourses.add(new AssignmentCourse("Economics"));
        List<ResearchCourse> researchCourses = new ArrayList<>();
        researchCourses.add(new ResearchCourse("Biotechnology"));
        researchCourses.add(new ResearchCourse("Artificial Intelligence"));
        CourseUtils.displayCourses(examCourses);
        CourseUtils.displayCourses(assignmentCourses);
        CourseUtils.displayCourses(researchCourses);
    }
}
