import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task19 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "orange", "banana");
        List<String> filtred = words.stream().filter(w -> w.length() > 5).toList();
        System.out.println(filtred);
    }
}
