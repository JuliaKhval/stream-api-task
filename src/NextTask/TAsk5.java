package NextTask;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class OrderItem {
    private String productId;
    private int quantity;
    private double price;

    public OrderItem(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }


    public String getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
}

class Order {
    private String orderId;
    private String customerId;
    private List<OrderItem> items;

    public Order(String orderId, String customerId, List<OrderItem> items) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
    }


    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public List<OrderItem> getItems() { return items; }


    public double getTotalAmount() {
        return items.stream()
                .mapToDouble(item -> item.getQuantity() * item.getPrice())
                .sum();
    }
}
public class TAsk5 {
    public static void main(String[] args) {
    List<Order> orders = Arrays.asList(
            new Order("O1", "C1", Arrays.asList(
                    new OrderItem("P1", 2, 100),
                    new OrderItem("P2", 1, 200)
            )),
            new Order("O2", "C2", Arrays.asList(
                    new OrderItem("P1", 1, 150),
                    new OrderItem("P3", 3, 120)
            )),
            new Order("O3", "C3", Arrays.asList(
                    new OrderItem("P2", 2, 300),
                    new OrderItem("P4", 1, 50)
            )),
            new Order("O4", "C4", Arrays.asList(
                    new OrderItem("P1", 1, 200),
                    new OrderItem("P3", 2, 130),
                    new OrderItem("P5", 1, 100)
            )),
            new Order("O5", "C5", Arrays.asList(
                    new OrderItem("P3", 5, 110)
            )),
            new Order("O6", "C6", Arrays.asList(
                    new OrderItem("P4", 3, 60),
                    new OrderItem("P5", 2, 120)
            ))
    );

        Map<String, Long> popularProducts = orders.stream()
                .filter(order -> order.getTotalAmount() > 500)
                .flatMap(order -> order.getItems().stream())
                .collect(Collectors.groupingBy(
                        OrderItem::getProductId,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
}
}

