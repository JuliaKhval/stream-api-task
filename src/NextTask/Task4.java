package NextTask;

import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    private String id;
    private String userId;
    private double amount;
    private String type; // "DEBIT" или "CREDIT"
    private Date timestamp;

    public Transaction(String id, String userId, double amount, String type, Date timestamp) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
    }


    public String getUserId() { return userId; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public Date getTimestamp() { return timestamp; }
}
public class Task4 {
    public static void main(String[] args) {
        // Создаем тестовые данные
        List<Transaction> transactions = Arrays.asList(
                new Transaction("1", "user1", 5000, "DEBIT", new Date(123, 0, 15)), // Январь 2023
                new Transaction("2", "user1", 3000, "CREDIT", new Date(123, 0, 20)),
                new Transaction("3", "user1", 2000, "DEBIT", new Date(123, 1, 10)), // Февраль 2023
                new Transaction("4", "user2", 8000, "DEBIT", new Date(123, 0, 5)),
                new Transaction("5", "user2", 7000, "CREDIT", new Date(123, 1, 15)),
                new Transaction("6", "user3", 1000, "DEBIT", new Date(123, 0, 10)),
                new Transaction("7", "user3", 500, "CREDIT", new Date(123, 1, 20))
        );


        Map<String, Double> userTotalTurnover = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getUserId,
                        Collectors.summingDouble(t -> Math.abs(t.getAmount()))
                ));


        List<Map.Entry<String, Map.Entry<YearMonth, Double>>> result = transactions.stream()
                .filter(t -> userTotalTurnover.getOrDefault(t.getUserId(), 0.0) >= 10000)
                .collect(Collectors.groupingBy(
                        Transaction::getUserId,
                        Collectors.groupingBy(
                                t -> YearMonth.from(t.getTimestamp().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()),
                                Collectors.summingDouble(t -> Math.abs(t.getAmount()))
                        )
                ))
                .entrySet().stream()
                .map(userEntry -> {

                    Map.Entry<YearMonth, Double> maxMonthEntry = userEntry.getValue().entrySet().stream()
                            .max(Map.Entry.comparingByValue())
                            .orElse(null);

                    return maxMonthEntry != null
                            ? new AbstractMap.SimpleEntry<>(userEntry.getKey(), maxMonthEntry)
                            : null;
                })
                .filter(Objects::nonNull)

                .sorted(Map.Entry.<String, Map.Entry<YearMonth, Double>>comparingByValue(
                        Map.Entry.comparingByValue(Comparator.reverseOrder())
                ))
                .collect(Collectors.toList());


        System.out.println("Месяцы с максимальным оборотом по пользователям:");
        result.forEach(entry -> {
            String userId = entry.getKey();
            YearMonth month = entry.getValue().getKey();
            double turnover = entry.getValue().getValue();
            System.out.printf("Пользователь: %s, Месяц: %s, Оборот: %.2f%n",
                    userId, month, turnover);
        });
    }
}
