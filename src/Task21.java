import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task21 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbers2 = numbers.stream().map(n->n*n).toList();
        System.out.println(numbers2);
    }

}
