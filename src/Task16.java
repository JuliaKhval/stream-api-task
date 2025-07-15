import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task16 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        String joined = words.stream()
                .collect(Collectors.joining(", "));
        System.out.println(joined);
    }
}
