package services;

import models.Product;

import java.util.HashMap;
import java.util.Map;

public class CartService {
    private Map<Product, Integer> cartItems = new HashMap<>();

    public void addItem(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            System.out.println("Invalid product or quantity.");
            return;
        }
        if (product.getStock() < quantity) {
            System.out.println("Insufficient stock for product: " + product.getName());
            return;
        }
        product.setStock(product.getStock() - quantity);
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
        System.out.println(quantity + " X " + product.getName() + " added to cart.");
    }

    public Map<Product, Integer> getCartItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
        System.out.println("Cart cleared.");
    }
}
