import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Task24 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        IntSummaryStatistics stats = numbers.stream().mapToInt(a->a).summaryStatistics();
    }
}
