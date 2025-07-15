import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task27 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200.0, "Electronics"),
                new Product("Smartphone", 800.0, "Electronics"),
                new Product("TV", 1500.0, "Electronics"),
                new Product("Headphones", 200.0, "Electronics"),
                new Product("Shirt", 50.0, "Clothing"),
                new Product("Jeans", 80.0, "Clothing"),
                new Product("Dress", 120.0, "Clothing"),
                new Product("Shoes", 150.0, "Clothing"),
                new Product("Milk", 2.5, "Groceries"),
                new Product("Bread", 3.0, "Groceries"),
                new Product("Cheese", 5.0, "Groceries")
        );
        int n = 4;
        List<Product> topN = products.stream()
                .sorted(Comparator.comparing(Product::getPrice)
                        .reversed())
                .limit(n)
                .toList();
    }
}
