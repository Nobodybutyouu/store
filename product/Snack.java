package product;

import inventory.Inventory;

public class Snack extends Product {
    private String flavor;

    public Snack(int productID, String productName, String flavor, int productCategory, double productPrice, int productQuantity) {
        super(productID, productName, productCategory, productPrice, productQuantity);
        this.flavor = flavor;

        
     }
     public String getFlavor() {
        return flavor;
     }
}
