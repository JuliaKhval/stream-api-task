import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long count =  numbers.stream().filter(number -> number > 5 ).count();
        System.out.println(count);
    }
}
