class Student implements Comparable<Student> {
    String id;
    String name;
    double marks;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    @Override
    public int compareTo(Student other) {
        return Double.compare(other.marks, this.marks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
import java.util.*;

public class AdmissionSystem {
    private List<Student> allApplicants = new ArrayList<>();
    private Set<Student> shortlistedCandidates = new HashSet<>();
    private Queue<Student> interviewQueue = new LinkedList<>();
    private TreeSet<Student> meritList = new TreeSet<>();
    public void apply(Student s) {
        allApplicants.add(s);
    }
    public void shortlistStudents(double cutoff) {
        for (Student s : allApplicants) {
            if (s.marks >= cutoff) {
                shortlistedCandidates.add(s);
            }
        }
    }
    public void prepareInterviews() {
        interviewQueue.addAll(shortlistedCandidates);
    }
    public void finalizeAdmission(Student s) {
        if (interviewQueue.contains(s)) {
            meritList.add(s);
            interviewQueue.remove(s);
        }
    }
}