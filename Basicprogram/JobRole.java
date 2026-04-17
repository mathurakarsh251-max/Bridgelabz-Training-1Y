import java.util.*;
abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() { return candidateName; }

    public abstract String getRoleName();

    @Override
    public String toString() {
        return getRoleName() + " Resume - Candidate: " + candidateName;
    }
}
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) { super(candidateName); }
    @Override
    public String getRoleName() { return "Software Engineer"; }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) { super(candidateName); }
    @Override
    public String getRoleName() { return "Data Scientist"; }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) { super(candidateName); }
    @Override
    public String getRoleName() { return "Product Manager"; }
}
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() { return jobRole; }

    @Override
    public String toString() {
        return jobRole.toString();
    }
}
class ScreeningPipeline {
    public static void processResumes(List<? extends JobRole> resumes) {
        System.out.println("Processing resumes...");
        for (JobRole r : resumes) {
            System.out.println("- " + r);
        }
    }
}
public class ResumeScreeningDemo {
    public static void main(String[] args) {
        List<SoftwareEngineer> seResumes = new ArrayList<>();
        seResumes.add(new SoftwareEngineer("Alice"));
        seResumes.add(new SoftwareEngineer("Bob"));
        List<DataScientist> dsResumes = new ArrayList<>();
        dsResumes.add(new DataScientist("Charlie"));
        dsResumes.add(new DataScientist("Diana"));
        List<ProductManager> pmResumes = new ArrayList<>();
        pmResumes.add(new ProductManager("Ethan"));
        pmResumes.add(new ProductManager("Fiona"));
        ScreeningPipeline.processResumes(seResumes);
        ScreeningPipeline.processResumes(dsResumes);
        ScreeningPipeline.processResumes(pmResumes);
    }
}
