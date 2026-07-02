package inventory;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import product.Product;
import product.Snack;
import product.Beverage;
import product.HouseholdItem;

public class Inventory {
    public static ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Scanner scan, int productCategory) {
        

        boolean status = true;
        int productQuantity = 0;
        boolean productSaved = false;
        int productID = 0;
        String stringCategory = "";
        while (status) {  

            
            

           try {
            System.out.println("\n=====Add Product=====");
            System.out.print("Product Quantity to add: ");
            productQuantity = scan.nextInt();
            scan.nextLine();
            
           }catch (InputMismatchException inputMismatch){
            System.out.println("Notice: Invalid Input");
            scan.nextLine();
           }
           

            for (int i = 0; i < productQuantity; i++) {

                for (Product prodID : products) {
                productID = prodID.productID;
            }
            productID ++;

                System.out.print("Product " + (i + 1) + " name: ");
                String productName = scan.nextLine();
                

                String productVolume = "";
                String flavor = "";
                String materialType = "";

                switch(productCategory) {
                    case 1:
                        stringCategory = "Beverages";
                        System.out.print("Product Volume: ");
                        productVolume = scan.nextLine();
                        break;
                    case 2:
                        stringCategory = "Snack";
                        System.out.print("Flavor: ");
                        flavor = scan.nextLine();
                        break;
                    case 3:
                        stringCategory = "Household Item";
                        boolean case3Status = true;
                        while (case3Status) {
                            System.out.println("\nMaterial Type Options: ");
                            System.out.println("[1] Wooden\n[2] Plastic\n[3] Steel\n[4] Exit");
                            System.out.print("Select Material Type: ");
                            int choosenType = scan.nextInt();

                            if (choosenType > 0 && choosenType < 5) {
                                switch(choosenType) {
                                    case 1: 
                                        materialType = "Wooden";
                                        break;
                                    case 2:
                                        materialType = "Plastic";
                                        break;
                                    case 3:
                                        materialType = "Steel";
                                        break;
                                    case 4:
                                        case3Status = false;
                                        break;
                                    

                                }
                            }
                            break;    
                        }
                        

                }

                System.out.print("Price: ");
                double price = scan.nextDouble();
                System.out.print("Product Quantity: ");
                int prodQuantity = scan.nextInt();
                scan.nextLine();

                switch(productCategory) {
                    case 1:
                        Beverage addBeverage = new Beverage(productID, productName,  productVolume, stringCategory, price, prodQuantity);
                        break;
                    case 2:
                        Snack addSnack = new Snack(productID, productName,  flavor, stringCategory, price, prodQuantity);
                        break;
                    case 3:
                        HouseholdItem addHouseholdItem =  new HouseholdItem(productID, productName,  materialType, stringCategory, price, prodQuantity);
                        break;
                }
                 System.out.println("*Product Saved*");
                 productSaved = true;
                
                
        }  
        if (productSaved) {
            break;
        }
       
        
        }

           
        
    }

    public void displayProduct() {
        int maxProductIDWidth ="ProductID".length();
        int maxNameWidth ="Product Name".length();
        int maxCategoryWidth ="Category".length();
        int maxVolumeWidth ="Volume".length();
        int maxFlavorWidth ="Flavor".length();
        int maxMaterialTypeWidth ="Material Type".length();
        int maxPriceWidth ="Price".length();
        int maxQuantity ="Stock".length();



        for (Product product:products) {
            maxProductIDWidth = Math.max(maxProductIDWidth, String.valueOf(product.productID).length());
            maxNameWidth = Math.max(maxNameWidth, product.productName.length());

            if (product instanceof Beverage beverage) {
                maxCategoryWidth = Math.max(maxCategoryWidth, "Beverage".length());
                maxVolumeWidth = Math.max(maxVolumeWidth, beverage.getVolume().length());
            }else if (product instanceof Snack snack) {
                maxCategoryWidth = Math.max(maxCategoryWidth, "Snack".length());
                maxFlavorWidth = Math.max(maxFlavorWidth, snack.getFlavor().length());
            }else if(product instanceof HouseholdItem householdItem) {
                maxCategoryWidth = Math.max(maxCategoryWidth, "Household Item".length());
                maxMaterialTypeWidth = Math.max(maxMaterialTypeWidth, householdItem.getMaterialType().length());
            }
            maxPriceWidth = Math.max(maxPriceWidth, String.valueOf(product.productPrice).length());
            maxQuantity = Math.max(maxQuantity, String.valueOf(product.productQuantity).length());

        }
        int padding = 3;
        String formatTemplate = "%-" + (maxProductIDWidth + padding) + "s" +
                                "%-" + (maxNameWidth + padding) + "s" +
                                "%-" + (maxCategoryWidth + padding) + "s" +
                                "%-" + (maxVolumeWidth + padding) + "s" +
                                "%-" + (maxFlavorWidth + padding) + "s" +
                                "%-" + (maxMaterialTypeWidth + padding) + "s" + 
                                "%-" + (maxPriceWidth + padding) + "s" +
                                "%-" + (maxQuantity + padding) + "s%n";

        String dataTemplate =   "%-" + (maxProductIDWidth + padding) + "d" +
                                "%-" + (maxNameWidth + padding) + "s" +
                                "%-" + (maxCategoryWidth + padding) + "s" +
                                "%-" + (maxVolumeWidth + padding) + "s" +
                                "%-" + (maxFlavorWidth + padding) + "s" +
                                "%-" + (maxMaterialTypeWidth + padding) + "s" + 
                                "%-" + (maxPriceWidth + padding) + ".2f" +
                                "%-" + (maxQuantity + padding) + "d%n";

        System.out.printf(formatTemplate, "ProductID", "Name", "Category", "Volume", "Flavor", "Material Type", "Price", "Stock");
        int maxWidth = maxProductIDWidth + maxNameWidth +
                       maxVolumeWidth + maxFlavorWidth +
                       maxMaterialTypeWidth + maxPriceWidth +
                       maxQuantity + maxCategoryWidth + (padding * 8);
        System.out.println("-".repeat(maxWidth));

        

        for (Product product:products) {
            if (product instanceof Beverage beverage) {
                System.out.printf(dataTemplate, product.productID, product.productName, product.productCategory, beverage.getVolume(), "N/A", "N/A", product.productPrice, product.productQuantity);
            }else if(product instanceof Snack snack) {
                System.out.printf(dataTemplate, product.productID, product.productName, product.productCategory, "N/A", snack.getFlavor(), "N/A", product.productPrice, product.productQuantity);
            }else if(product instanceof HouseholdItem househodItem) {
                System.out.printf(dataTemplate, product.productID, product.productName, product.productCategory, "N/A", "N/A", househodItem.getMaterialType(), product.productPrice, product.productQuantity);
            }
            
            
        }
        System.out.println("-".repeat(maxWidth));
        System.out.println();
    }
    boolean productFound = false;
    public void searchProduct(String productName) {
        
        for(Product searchProduct : products) {
            if (searchProduct.productName.toLowerCase().contains(productName.toLowerCase())) {
                System.out.println("Found: " + searchProduct.productName);
                productFound = true;
            } 
            
        }
        if (!productFound) {
                System.out.println("No product found for: " + productName);
            }
    }
    
}
