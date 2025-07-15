import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task13 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Poll",24),
                new Person("Ivan",13),
                new Person("Liza",18))
                ;
        Map<String,Integer> nameAndAge = people.stream().collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println(nameAndAge);
    }
}
