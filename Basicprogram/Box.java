class Box<T> {
    private T value;
    public void set(T value) {
        this.value = value;
    }
    public T get() {
        return value;
    }
}
public class Main {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.set(123);
        System.out.println("Integer Value: " + integerBox.get());
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics");
        System.out.println("String Value: " + stringBox.get());
        Box<Double> doubleBox = new Box<>();
        doubleBox.set(45.67);
        System.out.println("Double Value: " + doubleBox.get());
    }
}