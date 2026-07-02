package product;


public class Snack extends Product {
    private String flavor;

    public Snack(int productID, String productName, String flavor, String productCategory, double productPrice, int productQuantity) {
        super(productID, productName, productCategory, productPrice, productQuantity);
        this.flavor = flavor;

        
     }
     public String getFlavor() {
        return flavor;
     }
}
