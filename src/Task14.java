import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task14 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Map<Boolean,List<Integer>> partioning = numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(partioning);
    }
}
