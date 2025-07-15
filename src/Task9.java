import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task9 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Poll",24),
                new Person("Ivan",13),
                new Person("Liza",18))
                ;
        List<String> name =  people.stream().map(Person::getName).toList();
        System.out.println(name);
    }
}
