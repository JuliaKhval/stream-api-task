import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TAsk17 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        Optional<String> longest = words.stream().max(Comparator.comparing(String::length));
        System.out.println(longest.get());
    }
}
