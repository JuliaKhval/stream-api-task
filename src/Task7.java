import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task7 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Poll",24),
                new Person("Ivan",13),
                new Person("Liza",18))
                ;
        List<Person> sortByAge = people.stream().sorted(Comparator.comparing(Person::getAge)).toList();
        sortByAge.forEach(System.out::println);
    }
}
