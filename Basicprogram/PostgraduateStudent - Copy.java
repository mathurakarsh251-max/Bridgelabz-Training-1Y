class Student {
    public int rollNumber;
    protected String name;
    private double cgpa;
    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }
    public double getCgpa() {
        return cgpa;
    }
    public void setCgpa(double newCgpa) {
        if (newCgpa >= 0.0 && newCgpa <= 10.0) {
            this.cgpa = newCgpa;
        } else {
            System.out.println("Invalid CGPA value!");
        }
    }
}
class PostgraduateStudent extends Student {
    String researchTopic;

    public PostgraduateStudent(int rollNumber, String name, double cgpa, String researchTopic) {
        super(rollNumber, name, cgpa); 
        this.researchTopic = researchTopic;
    }

    public void displayPGDetails() {
        System.out.println("--- Postgraduate Student Record ---");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name:        " + name); 
        System.out.println("Research:    " + researchTopic);
        System.out.println("CGPA:        " + getCgpa());
        System.out.println("-----------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(501, "Aryan Khan", 8.5, "AI in Healthcare");
        pg.rollNumber = 502; 
        pg.setCgpa(9.2);
        pg.displayPGDetails();
    }
}