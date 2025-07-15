import java.util.Arrays;
import java.util.List;

public class Task18 {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("banana", "apple", "orange", "banana");
        int counter = words.stream().mapToInt(w -> w.length()).sum();
        System.out.println(counter);
    }
}
