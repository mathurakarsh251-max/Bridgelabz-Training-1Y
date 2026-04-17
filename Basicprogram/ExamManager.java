class Student {
    String id;
    String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() { return name + " (" + id + ")"; }
}

class Question {
    int id;
    String text;

    public Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() { return "Q" + id + ": " + text; }
}
import java.util.*;

public class ExamManager {
    private List<Question> questionBank = new ArrayList<>();
    private Set<String> registeredStudentIDs = new HashSet<>();
    private Queue<Student> examQueue = new LinkedList<>();
    private Stack<Question> backHistory = new Stack<>();
    public void enrollStudent(Student student) {
        if (registeredStudentIDs.add(student.id)) {
            examQueue.add(student);
            System.out.println("Enrolled: " + student.name);
        } else {
            System.out.println("Error: Student ID " + student.id + " is already logged in.");
        }
    }
    public void initializeExam(List<Question> questions) {
        this.questionBank.addAll(questions);
        Collections.shuffle(this.questionBank); 
        System.out.println("Exam initialized with " + questionBank.size() + " randomized questions.");
    }
    public void startExamCycle() {
        while (!examQueue.isEmpty()) {
            Student currentStudent = examQueue.poll();
            System.out.println("\nNow starting exam for: " + currentStudent);
            conductExam();
        }
    }
    private void conductExam() {
        backHistory.clear();
        for (Question q : questionBank) {
            System.out.println("Current: " + q);
            backHistory.push(q);
        }
        
        if (!backHistory.isEmpty()) {
            System.out.println("Navigating back to last question: " + backHistory.peek());
        }
    }
}