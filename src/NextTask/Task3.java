package NextTask;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;
    private int age;
    private List<String> projects;

    public Employee(String name, String department, double salary, int age, List<String> projects) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.projects = projects;
    }


    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }
    public List<String> getProjects() { return projects; }
    public String getName() { return name; }


}

public class Task3 {
    public static void main(String[] args) {
        // Создаем тестовых сотрудников
        List<Employee> employees = Arrays.asList(
                new Employee("Иван", "IT", 75000, 35, Arrays.asList("ProjectA", "ProjectB", "ProjectC")),
                new Employee("Мария", "IT", 80000, 28, Arrays.asList("ProjectA", "ProjectB")),
                new Employee("Алексей", "IT", 90000, 32, Arrays.asList("ProjectA", "ProjectB", "ProjectC", "ProjectD")),
                new Employee("Ольга", "HR", 45000, 31, Arrays.asList("ProjectX", "ProjectY")),
                new Employee("Дмитрий", "HR", 55000, 35, Arrays.asList("ProjectX", "ProjectY", "ProjectZ")),
                new Employee("Елена", "Finance", 60000, 33, Arrays.asList("Project1", "Project2", "Project3")),
                new Employee("Сергей", "Finance", 48000, 29, Arrays.asList("Project1"))
        );
        Map<String, List<Employee>> result = employees.stream()

                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet().stream()
                .filter(entry -> entry.getValue().stream()
                        .mapToDouble(Employee::getSalary)
                        .average()
                        .orElse(0) > 50000)

                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .filter(e -> e.getAge() > 30)
                                .filter(e -> e.getProjects().size() > 2)
                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                .collect(Collectors.toList())
                ));
        System.out.println("Департаменты со средней зарплатой > 50000 и их сотрудники:");
        result.forEach((department, empList) -> {
            System.out.println("\nДепартамент: " + department);
            System.out.println("Сотрудники (старше 30 лет, >2 проектов):");
            empList.forEach(System.out::println);
        });
    }
}
