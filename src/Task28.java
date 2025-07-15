import java.util.Arrays;
import java.util.List;

public class Task28 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int sum = list.stream().filter(x -> x % 2 == 0).mapToInt(n -> n*n).sum();
        System.out.println(sum);
    }
}
