import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task11 {
    public static void main(String[] args) {
        List<List<Integer>> listOfList = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6)
        );
        List<Integer> list = listOfList.stream().flatMap(List::stream).toList();
    }
}
