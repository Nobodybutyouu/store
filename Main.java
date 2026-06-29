import java.util.Scanner;

import option.Option;
import inventory.Inventory;
import product.Beverage;
import product.HouseholdItem;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean status = true;

        while (status) {
            System.out.println("=====Product Inventory Management=====");
            System.out.println("Options:");
            System.out.println("[1] Add Product\n[2] Display Product\n[3] Search Product\n[4] Exit");
            System.out.print("What would you like to do: ");
            int choosenOption = scan.nextInt();

            if (choosenOption >0 && choosenOption < 5 ) {

                switch (choosenOption) {
                    case 1:
                        boolean categoryStatus = true;
                        while (categoryStatus) {
                            System.out.println("\nCategory Options:");
                            System.out.println("[1] Beverages\n[2] Snacks\n[3] Household Items\n[4] Exit");
                            System.out.print("Select Category: ");
                            int choosenCategory = scan.nextInt();
                            
                            if (choosenCategory >0 && choosenCategory < 5 ) {
                                   switch (choosenCategory) {
                                    case 1:
                                       Inventory beverageProduct = new Inventory();
                                       beverageProduct.addProduct(scan, choosenCategory);
                                        break;
                                    case 2:
                                        Inventory snackProduct = new Inventory();
                                        snackProduct.addProduct(scan, choosenCategory);
                                        break;
                                    case 3:
                                        Inventory householdItemProduct = new Inventory();
                                        householdItemProduct.addProduct(scan, choosenCategory);
                                         break;
                                    case 4:
                                        categoryStatus = false;
                                        break;
                                    }
                            } else {
                                System.out.println("Notice: Invalid Input");
                            } 
                            break;
                        }
                        break;
                        
                    case 2:
                        Inventory displayProduct = new Inventory();
                        displayProduct.displayProduct();
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        status = false;
                        break;

            }
            } else {
                System.out.println("Notice: Invalid Input");
            }
        }
        
            
        

        scan.close();
    }
}