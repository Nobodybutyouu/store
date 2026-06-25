import java.util.Scanner;

import option.Option;
import inventory.Inventory;
import product.Beverage;

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
                            System.out.println("Category:");
                            System.out.println("[1] Beverages\n[2] Snacks\n[3] Household Items\n[4] Exit");
                            System.out.print("Choose Category: ");
                            int choosenCategory = scan.nextInt();
                            
                            if (choosenCategory >0 && choosenCategory < 5 ) {
                                   switch (choosenOption) {
                                    case 1:
                                       Inventory addProduct = new Inventory();
                                       Beverages.addProduct(scan, choosenCategory);
                                       Beverages addBeverages = new Beverages();
                                        break;
                                    case 2:
                                        
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

                        break;
                    case 2:
                        
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