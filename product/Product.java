package product;

import inventory.Inventory;

public class Product {
    public int productID;
    public String productName;
    public int productCategory;
    public double productPrice;
    public int productQuantity;

    public Product (int productID, String productName, int productCategory, double productPrice, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;

        Inventory.products.add(this);
    }
    @Override
    public String toString() {
        return "Product ID: " + productID + 
               ", Name: " + productName + 
               ", Category: " + productCategory + 
               ", Price: " + productPrice + 
               ", Quantity: " + productQuantity;
    }



}
