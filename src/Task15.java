import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task15 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Poll",24),
                new Person("Ivan",13),
                new Person("Liza",18))
                ;
        List<Person> filteredPeople = people.stream().
                filter(person -> person.getName().startsWith("A") && person.getAge() > 20)

                .toList();
        System.out.println(filteredPeople);
    }

}
