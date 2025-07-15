import java.util.Arrays;
import java.util.List;

public class Task10 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Poll",24),
                new Person("Ivan",13),
                new Person("Liza",18))
                ;
        double averageAge = people.stream().mapToInt(Person::getAge).average().orElse(0);
        System.out.println(averageAge);
    }
}
