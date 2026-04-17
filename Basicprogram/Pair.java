class Pair<T, U> {
    private T first;
    private U second;
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
    public T getFirst() {
        return first;
    }
    public U getSecond() {
        return second;
    }
}
public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> student = new Pair<>("Amol", 20);
        String name = student.getFirst();
        Integer age = student.getSecond();

        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        Pair<Double, Boolean> status = new Pair<>(98.6, true);
        System.out.println("Reading: " + status.getFirst() + " | Active: " + status.getSecond());
    }
}