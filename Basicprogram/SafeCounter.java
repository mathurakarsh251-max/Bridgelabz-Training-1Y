import java.util.*;
class SafeCounter<E> {
    private final Set<E> set = new HashSet<>(); 
    private int addCount = 0;

    public void add(E e) {
        addCount++;
        set.add(e);
    }

    public void addAll(Collection<? extends E> c) {
        addCount += c.size();
        set.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}

public class Main {
    public static void main(String[] args) {
        SafeCounter<String> counter = new SafeCounter<>();
        counter.addAll(Arrays.asList("Java", "Python", "C++"));
        System.out.println("Total elements added: " + counter.getAddCount());
    }
}