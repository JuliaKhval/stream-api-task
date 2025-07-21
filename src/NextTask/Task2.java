package NextTask;


import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> logs = List.of(
                "2024-01-15 ERROR UserService: User not found",
                "2024-01-15 INFO AuthService: Login successful",
                "2024-01-15 ERROR PaymentService: Transaction failed",
                "2024-01-16 ERROR UserService: Invalid token",
                "2024-01-15 WARN DatabaseService: Connection timeout",
                "2024-01-15 ERROR AuthService: Invalid credentials",
                "2024-01-15 ERROR PaymentService: Insufficient funds"
        );
        String targetDate = "2024-01-15";
        String result = logs.stream()
                .filter(log -> log.startsWith(targetDate) && log.contains(" ERROR "))


                .map(log -> {
                    String[] parts = log.split(" ");
                    return parts[2].split(":")[0];
                })
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println(result);

    }
}
