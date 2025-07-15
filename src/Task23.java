import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Task23 {
    record Stats(int min, int max) {}

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Stats stats = numbers.stream().collect(Collectors.teeing(
                Collectors.minBy(Integer::compareTo),
                Collectors.maxBy(Integer::compareTo),
                (minOpt, maxOpt) -> new Stats(minOpt.get(), maxOpt.get())
        ));

        System.out.println("Min: " + stats.min());
        System.out.println("Max: " + stats.max());
    }
}
