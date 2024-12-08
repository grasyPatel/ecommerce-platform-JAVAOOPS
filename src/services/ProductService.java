package services;

import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private List<Product> products1=new ArrayList<>();

    public ProductService() {
        // Initialize with some dummy products
        products1.add(new Product(1, "Laptop", 1000.0, 10));
        products1.add(new Product(2, "Phone", 500.0, 20));
        products1.add(new Product(3, "Headphones", 50.0, 15));
    }

    public void displayProducts() {
        System.out.println("Available Products:");
        for (Product p : products1) {
            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Price: $" + p.getPrice() + ", Stock: " + p.getStock());
        }
    }

    public Product getProductById(int id) {
        for (Product product : products1) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(){
        System.out.println("Adding a new Product........");
        System.out.println("Enter Product Details: ");
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the Product ID: ");

        int id=scan.nextInt();
        System.out.println("Enter Product name: ");
        String name=scan.next();
        System.out.println("Enter Product Price: ");
        double price=scan.nextDouble();
        System.out.println("Enter how many Product available: ");
        int stock=scan.nextInt();

        Product product=new Product(id+1,name,price,stock);
        products1.add(product);
        System.out.println("Product Added successfully....!");
    }
    public  void removeProduct(){
        Scanner sc=new Scanner(System.in);
        if(products1.isEmpty()){
            System.out.println("No Product available to remove.");
            return;
        }
        System.out.println("Available Products are: ");
        for(Product product:products1){
            System.out.println("ID: "+product.getId()+", Name: "+product.getName()+", Price: "+product.getPrice()+", Stock: "+product.getStock());
        }

        System.out.println("Enter the id of the Product that needs to remove : ");
        int Product_id=sc.nextInt();
        products1.remove(Product_id);
        System.out.println("Product Removed successfully!");

    }
    public List<Product> getAllProducts() {
        if (products1.isEmpty()) {
            System.out.println("No products available.");
        }
        return products1;
    }

}
