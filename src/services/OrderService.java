package services;

import models.Cart;
import models.Order;
import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {
    private List<Order> orderHistory = new ArrayList<>();

    public void checkout(CartService cartService) {
        if (cartService == null || cartService.getCartItems().isEmpty()) {
            System.out.println("Your cart is empty. Cannot proceed with checkout.");
            return;
        }

        Order newOrder = new Order();
        for (Map.Entry<Product, Integer> entry : cartService.getCartItems().entrySet()) {
            newOrder.addItem(entry.getKey(), entry.getValue());
        }

        orderHistory.add(newOrder);
        cartService.clearCart();
        System.out.println("Checkout successful. Order has been placed.");
    }

    public void viewOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("You have no previous orders.");
        } else {
            System.out.println("Order History:");
            for (int i = 0; i < orderHistory.size(); i++) {
                System.out.println("Order #" + (i + 1) + ": ");
                for (Map.Entry<Product, Integer> entry : orderHistory.get(i).getItems().entrySet()) {
                    System.out.println(" - Product: " + entry.getKey().getName() +
                            ", Quantity: " + entry.getValue() +
                            ", Price: $" + entry.getKey().getPrice());
                }
                System.out.println("Total Paid: $" + orderHistory.get(i).getTotalAmount());
                System.out.println("------------------------------------");
            }
        }
    }
}
