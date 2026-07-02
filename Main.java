import java.util.InputMismatchException;
import java.util.Scanner;

import inventory.Inventory;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean status = true;
        int choosenOption = 0;
        while (status) {
            System.out.println("\n=====Product Inventory Management=====");
            System.out.println("Options:");
            System.out.println("[1] Add Product\n[2] Display Product\n[3] Search Product\n[4] Exit");

            try {
                 System.out.print("What would you like to do: ");
                 choosenOption = scan.nextInt();
                 
            }catch (InputMismatchException inputMismatch){
                System.out.println("Notice: Invalid Input");
                scan.nextLine();
            }


            if (choosenOption >0 && choosenOption < 5 ) {

                switch (choosenOption) {
                    case 1:
                        boolean categoryStatus = true;
                        while (categoryStatus) {
                            System.out.println("\nCategory Options:");
                            System.out.println("[1] Beverages\n[2] Snacks\n[3] Household Items\n[4] Exit");
                            int choosenCategory = 0;

                            try {
                                System.out.print("Select Category: ");
                                choosenCategory = scan.nextInt();
                            }catch (InputMismatchException inputMismatch){
                                System.out.println("Notice: Invalid Input");
                                scan.nextLine();
                            }
                            
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
                            }else if (choosenCategory <0 || choosenCategory > 4){
                                System.out.println("Notice: Invalid Input");
                            } 
                            
                        }
                        break;
                        
                    case 2:
                        Inventory displayProduct = new Inventory();
                        displayProduct.displayProduct();
                        break;
                    case 3:
                        System.out.println("=====Search Product=====");
                        System.out.print("Product Name: ");
                        String productName = scan.nextLine();
                        scan.nextLine();
                        
                        Inventory searchProduct = new Inventory();
                        searchProduct.searchProduct(productName);
                        break;
                    case 4:
                        status = false;
                        break;

            }
            }else if (choosenOption < 0 || choosenOption > 4) {
                System.out.println("Notice: Invalid Input");
            }
        }
        
            
        

        scan.close();
    }
}