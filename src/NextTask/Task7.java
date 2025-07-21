package NextTask;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Event {
    private String eventId;
    private String userId;
    private String eventType;
    private LocalDateTime timestamp;
    private Map<String, Object> data;

    public Event(String eventId, String userId, String eventType,
                 LocalDateTime timestamp, Map<String, Object> data) {
        this.eventId = eventId;
        this.userId = userId;
        this.eventType = eventType;
        this.timestamp = timestamp;
        this.data = data;
    }

    // Геттеры
    public String getUserId() { return userId; }
    public String getEventType() { return eventType; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public Map<String, Object> getData() { return data; }
}

public class Task7 {

    public static void main(String[] args) {
        List<Event> events = Arrays.asList(
                new Event("E1", "U1", "PURCHASE", LocalDateTime.now().minusDays(10),
                        Map.of("amount", 150, "product", "A")),
                new Event("E2", "U1", "PURCHASE", LocalDateTime.now().minusDays(5),
                        Map.of("amount", 200, "product", "B")),
                new Event("E3", "U1", "VIEW", LocalDateTime.now().minusDays(3),
                        Map.of("page", "home")),
                new Event("E4", "U1", "PURCHASE", LocalDateTime.now().minusDays(2),
                        Map.of("amount", 300, "product", "C")),
                new Event("E5", "U1", "PURCHASE", LocalDateTime.now().minusDays(1),
                        Map.of("amount", 400, "product", "D")),
                new Event("E6", "U1", "PURCHASE", LocalDateTime.now().minusHours(12),
                        Map.of("amount", 500, "product", "E")),
                new Event("E7", "U1", "PURCHASE", LocalDateTime.now().minusHours(6),
                        Map.of("amount", 600, "product", "F")),
                new Event("E8", "U2", "PURCHASE", LocalDateTime.now().minusDays(15),
                        Map.of("amount", 1000, "product", "G")),
                new Event("E9", "U2", "PURCHASE", LocalDateTime.now().minusDays(7),
                        Map.of("amount", 1500, "product", "H")),
                new Event("E10", "U3", "PURCHASE", LocalDateTime.now().minusDays(20),
                        Map.of("amount", 50, "product", "I"))
        );

        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);

        Map<String, Double> userTotalPurchases = events.stream()
                .filter(e -> e.getEventType().equals("PURCHASE"))
                .filter(e -> e.getTimestamp().isAfter(thirtyDaysAgo))
                .collect(Collectors.groupingBy(
                        Event::getUserId,
                        Collectors.summingDouble(e -> ((Number) e.getData().getOrDefault("amount", 0)).doubleValue())
                ));


        Map<String, Long> result = userTotalPurchases.entrySet().stream()
                .filter(entry -> events.stream()
                        .filter(e -> e.getUserId().equals(entry.getKey()))
                        .filter(e -> e.getEventType().equals("PURCHASE"))
                        .filter(e -> e.getTimestamp().isAfter(thirtyDaysAgo))
                        .count() > 5)
                .collect(Collectors.groupingBy(
                        entry -> {
                            double total = entry.getValue();
                            int decade = (int) (total / 1000) * 1000;
                            return decade + "-" + (decade + 999);
                        },
                        Collectors.counting()
                ));



        result.forEach((decade, count) ->
                System.out.println(decade + ": " + count + " пользователей")
        );
    }
}
