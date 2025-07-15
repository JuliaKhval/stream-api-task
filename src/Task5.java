import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, -8, 9, 10);
        boolean isPositive = numbers.stream().allMatch(number -> number > 0);
        System.out.println(isPositive);
    }
}
