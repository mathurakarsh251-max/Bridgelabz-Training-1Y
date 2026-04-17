import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        for (Number n : src) {
            dest.add(n);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3);
        List<Number> numList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();
        copyList(numList, intList);
        System.out.println("numList after copy: " + numList);
        copyList(objList, intList);
        System.out.println("objList after copy: " + objList);
    }
}