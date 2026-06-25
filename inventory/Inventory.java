package inventory;

import java.util.Scanner;
import java.util.ArrayList;
import product.Product;

public class Inventory {
    public static ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Scanner scan, int productCategory) {
           System.out.println("=====Add Product=====");
           System.out.print("Product Quantity to add: ");
           int productQuantity = scan.nextInt();
           scan.nextLine();

            for (int i = 0; i < productQuantity; i++) {
                System.out.print("ProductID: ");
                int productID = scan.nextInt();
                System.out.print("Product " + (i + 1) + " name: ");
                String productName = scan.nextLine();
                System.out.print("Price: ");
                double price = scan.nextDouble();
                System.out.print("Product Quantity: ");
                int prodQuantity = scan.nextInt();
                scan.nextLine();

                Product newProduct = new Product(productID, productName, productCategory, price, prodQuantity);
        }
        System.out.println("*Product Saved*");
    }

    public void displayProduct() {

    }

    public void searchProduct() {

    }
    
}
