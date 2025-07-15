import java.util.Arrays;
import java.util.List;

public class Task20 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "orange", "banana");
        List<Character> FirstLetters = words.stream().map(w->w.charAt(0)).toList();
        System.out.println(FirstLetters);
    }
}
