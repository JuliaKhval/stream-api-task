import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TAsk30 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("banana", "apple", "orange", "banana");
        String filtred = list.stream()
                .filter(x -> x.length() > 3)
                .map(String::toUpperCase).sorted()
                .collect(Collectors.joining(" |"));
        System.out.println(filtred);
    }
}
