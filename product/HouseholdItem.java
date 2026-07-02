package product;


public class HouseholdItem extends Product{
    private String materialType;

    public HouseholdItem(int productID, String productName, String materialType, String productCategory, double productPrice, int productQuantity) {
        super(productID, productName, productCategory, productPrice, productQuantity);
        this.materialType = materialType;

        
    }
    public String getMaterialType(){
        return materialType;
    }
}
