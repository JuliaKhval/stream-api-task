package NextTask;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Sale {
    private String productName;
    private String category;
    private double amount;
    private String date;
    private String salesPerson;

    public Sale(String productName, String category, double amount, String date, String salesPerson) {
        this.productName = productName;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.salesPerson = salesPerson;
    }

    // Геттеры
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getDate() { return date; }
    public String getSalesPerson() { return salesPerson; }


}
public class Task1 {
    public static void main(String[] args) {

        List<Sale> sales = Arrays.asList(
                new Sale("Ноутбук", "Электроника", 1500.0, "2023-01-10", "Иванов"),
                new Sale("Телефон", "Электроника", 800.0, "2023-01-15", "Петрова"),
                new Sale("Куртка", "Одежда", 1200.0, "2023-02-05", "Сидоров"),
                new Sale("Худи", "Одежда", 2000.0, "2023-02-10", "Иванова"),
                new Sale("Хлеб", "Продукты", 500.0, "2023-03-01", "Петров"),
                new Sale("Телевизор", "Электроника", 3000.0, "2023-03-15", "Смирнов"),
                new Sale("Молоко", "Продукты", 1500.0, "2023-04-20", "Козлова")
        );


        List<Map.Entry<String, Double>> topCategories = sales.stream()
                .filter(s -> s.getAmount() >= 1000)
                .collect(Collectors.groupingBy(
                        Sale::getCategory,
                        Collectors.summingDouble(Sale::getAmount)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());



        topCategories.forEach(entry ->
                System.out.printf("%s: %.2f руб.%n", entry.getKey(), entry.getValue())
        );
    }
}
