package services;

import models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private List<Product> products1=new ArrayList<>();

    public void addProduct(){
        System.out.println("Adding a new Product........");
        System.out.println("Enter Product Details: ");
        Scanner scan=new Scanner(System.in);

        int id=products1.size();
        System.out.println("Enter Product name: ");
        String name=scan.next();
        System.out.println("Enter Product Price: ");
        double price=scan.nextDouble();
        System.out.println("Enter how many Product available: ");
        int stock=scan.nextInt();

        Product product=new Product(id,name,price,stock);
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
