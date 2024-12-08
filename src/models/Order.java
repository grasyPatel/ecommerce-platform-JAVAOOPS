package models;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Product, Integer> items; // Map to store product and their respective quantities
    private double totalAmount;

    // Constructor
    public Order() {
        this.items = new HashMap<>();
        this.totalAmount = 0.0;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addItem(Product product, int quantity) {
        if (product != null && quantity > 0) {
            items.put(product, items.getOrDefault(product, 0) + quantity);
            totalAmount += product.getPrice() * quantity;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            sb.append("Product: ").append(entry.getKey().getName())
                    .append(", Quantity: ").append(entry.getValue())
                    .append(", Price: $").append(entry.getKey().getPrice())
                    .append("\n");
        }
        sb.append("Total Paid: $").append(totalAmount);
        return sb.toString();
    }
}
