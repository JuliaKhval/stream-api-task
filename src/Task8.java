import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task8 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Poll",24),
                new Person("Ivan",13),
                new Person("Liza",18))
                ;
        Map<Integer,List<Person>> groupByAge = people.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(groupByAge);
    }
}
