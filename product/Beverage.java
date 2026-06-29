package product;

import inventory.Inventory;

public class Beverage extends Product{
    private String productVolume;
    
     public Beverage(int productID, String productName, String productVolume, int productCategory, double productPrice, int productQuantity) {
        super(productID, productName, productCategory, productPrice, productQuantity);
        this.productVolume = productVolume;

        
     }
    
     public String getVolume() {
        return productVolume;
     }
    
}