package product;

public class Beverage extends Product{

     public Beverage(int productID, String productName, int productCategory, double productPrice, int productQuantity) {
        super(productID, productName, productCategory, productPrice, productQuantity);
    }
    String volume;
}