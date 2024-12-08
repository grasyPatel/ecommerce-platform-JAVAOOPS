//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import models.Product;
import services.CartService;
import services.OrderService;
import services.ProductService;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ProductService productService=new ProductService();
        CartService cartService=new CartService();
        OrderService orderService=new OrderService();
        Scanner scan=new Scanner(System.in);
        Boolean running=true;
        System.out.println("Welcome to Ecommerce-Platform!!");
        while (running){
            System.out.println("\nMain Menu:");
            System.out.println("1. Seller Operations");
            System.out.println("2. Buyer Operations");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice=scan.nextInt();
            switch (choice){
                case 1:
                    handleSellerOperation(scan,productService);
                    break;
                case 2:
                    handleBuyerOperation(scan,cartService,productService,orderService);
                    break;
                case 3:
                    running=false;
                    System.out.println("Exiting the application. Goodbye!!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");

            }
        }

    }
    public static  void handleSellerOperation(Scanner scan, ProductService productService){
        System.out.println("\nSeller Menu:");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.print("Choose an option: ");
        int choice=scan.nextInt();
        switch (choice){
            case 1:
                productService.addProduct();
                break;
            case 2:
                productService.removeProduct();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    public static void handleBuyerOperation(Scanner scan ,CartService cartService,ProductService productService,OrderService orderService){
        System.out.println("\nBuyer Menu:");
        System.out.println("1. Add Product to Cart");
        System.out.println("2. Checkout");
        System.out.println("3. View Order History");
        System.out.print("Choose an option: ");
        int choice =scan.nextInt();
        switch (choice){
            case 1:
                productService.displayProducts(); // Display available products to select
                System.out.print("Enter product ID to add to cart: ");
                int productId = scan.nextInt();
                Product product = productService.getProductById(productId);
                if (product != null) {
                    System.out.print("Enter quantity: ");
                    int quantity = scan.nextInt();
                    cartService.addItem(product, quantity);
                } else {
                    System.out.println("Invalid Product ID.");
                }
                break;

            case 2:
                orderService.checkout(cartService);
                break;
            case 3:
                orderService.viewOrderHistory();
                break;
            default:
                System.out.println("Invalid Choice.");
        }

    }

}