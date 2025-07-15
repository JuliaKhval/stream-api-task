import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        words.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
