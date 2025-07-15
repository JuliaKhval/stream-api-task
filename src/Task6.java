import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task6 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Poll",24),
                new Person("Ivan",13),
                new Person("Liza",18))
                ;
        List<Person> peopleFilter = people.stream().filter(p-> p.getAge() > 18).toList();
        peopleFilter.forEach(System.out::println);
    }
}
