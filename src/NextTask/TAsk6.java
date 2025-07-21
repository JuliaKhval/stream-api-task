package NextTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Student {
    private String name;
    private String group;
    private List<Integer> grades;
    private List<String> subjects;

    public Student(String name, String group, List<Integer> grades, List<String> subjects) {
        this.name = name;
        this.group = group;
        this.grades = grades;
        this.subjects = subjects;
    }

    // Геттеры
    public String getGroup() { return group; }
    public List<Integer> getGrades() { return grades; }
    public List<String> getSubjects() { return subjects; }


    public double getAverageGrade() {
        return grades.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }
}
public class TAsk6 {
    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("Иван", "Группа1", Arrays.asList(5, 4, 5), Arrays.asList("Математика", "Физика")),
                new Student("Мария", "Группа1", Arrays.asList(5, 5, 5), Arrays.asList("Математика", "Химия")),
                new Student("Алексей", "Группа1", Arrays.asList(4, 3, 4), Arrays.asList("Физика", "Химия")),
                new Student("Ольга", "Группа2", Arrays.asList(5, 5, 4), Arrays.asList("Математика", "Информатика")),
                new Student("Дмитрий", "Группа2", Arrays.asList(5, 5, 5), Arrays.asList("Математика", "Физика")),
                new Student("Елена", "Группа3", Arrays.asList(3, 4, 3), Arrays.asList("История", "Литература")),
                new Student("Сергей", "Группа3", Arrays.asList(4, 4, 3), Arrays.asList("История", "Философия"))
        );

        Map<String, Map<String, Object>> result = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGroup,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                groupStudents -> {
                                    long totalStudents = groupStudents.size();
                                    long successfulStudents = groupStudents.stream()
                                            .filter(s -> s.getAverageGrade() > 4.0)
                                            .count();

                                    if ((double) successfulStudents / totalStudents > 0.7) {

                                        Map<String, Object> stats = new HashMap<>();

                                        stats.put("studentCount", totalStudents);

                                        double groupAvg = groupStudents.stream()
                                                .flatMap(s -> s.getGrades().stream())
                                                .mapToInt(Integer::intValue)
                                                .average()
                                                .orElse(0.0);
                                        stats.put("averageGrade", groupAvg);

                                        String popularSubject = groupStudents.stream()
                                                .flatMap(s -> s.getSubjects().stream())
                                                .collect(Collectors.groupingBy(
                                                        Function.identity(),
                                                        Collectors.counting()
                                                ))
                                                .entrySet().stream()
                                                .max(Map.Entry.comparingByValue())
                                                .map(Map.Entry::getKey)
                                                .orElse("Нет данных");
                                        stats.put("popularSubject", popularSubject);

                                        return stats;
                                    }
                                    return null;
                                }
                        )
                ))
                .entrySet().stream()
                .filter(e -> e.getValue() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));



        result.forEach((group, stats) -> {
            System.out.println("Группа " + group);
            System.out.println("Количество студентов" + stats.get("studentCount"));
            System.out.printf("Средний балл группы %.2f\n", stats.get("averageGrade"));
            System.out.println("Самый популярный предмет " + stats.get("popularSubject"));
        });
    }
    }
