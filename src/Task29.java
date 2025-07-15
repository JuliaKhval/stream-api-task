import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task29 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Poll",24),
                new Person("Ivan",13),
                new Person("Liza",18))
                ;
        Map<Boolean, Map<Character, List<Person>>> groupedPeople = people.stream()
                .collect(Collectors.groupingBy(
                        p -> p.getAge() >= 18,
                        Collectors.groupingBy(p -> p.getName().charAt(0))
                ));


        System.out.println(groupedPeople.keySet());
    }
}
