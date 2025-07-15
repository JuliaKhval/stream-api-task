import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task12 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a","b","a","e","f","g","h","i","j","a","a");
        List<String> uniqueStrings = strings.stream().distinct().sorted().toList();
        System.out.println(uniqueStrings);
    }
}
