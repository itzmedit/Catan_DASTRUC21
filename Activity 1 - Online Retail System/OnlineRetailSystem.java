// This is the "Online Retail System" class contains the main method
// This scenario demonstrates inheritance, where the "Customer" and "Admin" classes inherit attributes and methods from the "User" class
// This allowing for code reuse and modeling relationships in an online retail system

import java.util.Scanner;
import java.util.ArrayList;

public class OnlineRetailSystem {
   static public void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      Admin newAdmin = new Admin();
      Customer newCustomer = new Customer();
      Order newOrder = new Order();
      int numberOfProd = 0, numberOfOrd = 0;
      
      ArrayList<String> productID = new ArrayList<String>();
      ArrayList<String> productName = new ArrayList<String>();
      ArrayList<Double> productPrice = new ArrayList<Double>();
      ArrayList<Integer> stockQuantity = new ArrayList<Integer>();
      
      ArrayList<String> prodID = new ArrayList<String>();
      ArrayList<String> prodName = new ArrayList<String>();
      ArrayList<Double> prodPrice = new ArrayList<Double>();
      ArrayList<Integer> stockQty = new ArrayList<Integer>();
         
      System.out.println("---ONLINE SHOP---");
      System.out.println("[1] Log In \n[2] Exit");
      int ask1 = scan.nextInt();
      
      while (ask1 == 1) {
         System.out.println("\n---LOG IN as---");
         System.out.println("[1] Admin \n[2] Customer \n[3] Cancel");
         int ask2 = scan.nextInt();
         
         switch (ask2) {
            case 1:
               System.out.println("\n---ADMIN---");
               newAdmin.logIn();
               newAdmin.setDepartment();
               
               int ask3a = 1;
            
               while (ask3a == 1) {
                  System.out.println("---ADMIN---");
                  newAdmin.setAdminID(newAdmin.getUserID());
                  System.out.println("Admin ID: " + newAdmin.getAdminID());
                  System.out.println("[1] Add Product \n[2] Remove Product \n[3] Manage Inventory \n[4] Cancel");
                  int ask4a = scan.nextInt();
                  
                  switch (ask4a) {
                     case 1: 
                        int ask5a = 1, addedProd = 0;
                        
                        while (ask5a == 1) {
                           System.out.println("\n---ADD PRODUCT---");
                           newAdmin.addProduct(productID, productName, productPrice, stockQuantity);
                           numberOfProd++;
                           addedProd++;
                           
                           System.out.println("\nDo you want to add more? \n[1] Yes \n[2] No");
                           ask5a = scan.nextInt();
                        }
                        
                        System.out.println("Number of added product/s: " + addedProd);                        
                        break;
                        
                     case 2:
                        int ask5b = 1, removedProd = 0;
      
                        while (ask5b == 1) {
                           System.out.println("\n---REMOVE PRODUCT---");
                           newAdmin.removeProduct(productID, productName, productPrice, stockQuantity, numberOfProd);
                           numberOfProd--;
                           removedProd++;
      
                           System.out.println("\nDo you want to remove more? \n[1] Yes \n[2] No");
                           ask5b = scan.nextInt();
                        }   
                        
                        System.out.println("Number of removed product/s: " + removedProd);
                        break;
                        
                     case 3:
                        newAdmin.manageInventory(productID, productName, productPrice, stockQuantity, numberOfProd);                        
                        break;
                  }
                  
                  System.out.println("\n[1] Back to Menu \n[2] Log Out");
                  ask3a = scan.nextInt();
               } 
               
               if (ask3a == 2)
                  newAdmin.logOut();
                     
               break;
         
            case 2:
               System.out.println("\n---CUSTOMER---");
               newCustomer.logIn();
               newCustomer.setAddress();
               
               int ask3b = 1;
               
               while (ask3b == 1) {
                  System.out.println("---CUSTOMER---");
                  newCustomer.setCustomerID(newCustomer.getUserID());
                  System.out.println("Customer ID: " + newCustomer.getCustomerID());
                  System.out.println("[1] Place Order \n[2] View Order History \n[3] Cancel");
                  int ask4b = scan.nextInt(); 
                  
                  switch (ask4b) {
                     case 1:
                        newCustomer.placeOrder(newAdmin, productID, productName, productPrice, stockQuantity, numberOfProd);
                        
                        System.out.println("\n[1] Add Product To Order \n[2] Cancel");
                        int ask5d = scan.nextInt();
                        
                        switch (ask5d) {
                           case 1: 
                              int ask6a = 1;
      
                              while (ask6a == 1) {
                                 newOrder.addProductToOrder(newAdmin, newCustomer, productID, productName, productPrice, stockQuantity, prodID, prodName, prodPrice, stockQty, numberOfProd);
                                 
                                 numberOfOrd++;

                                 System.out.println("\nDo you want to add more? \n[1] Yes \n[2] No");
                                 ask6a = scan.nextInt();
                              }

                              System.out.println("\n[1] Confirm Order [2] Cancel");
                              int ask7a = scan.nextInt();
                                 
                              switch (ask7a) {
                                 case 1: 
                                    newOrder.confirmOrder(newCustomer, prodID, prodName, prodPrice, stockQty, numberOfOrd);
                                    break;
                              }

                              break;
                        }
                        
                        break;
                        
                     case 2:
                        newCustomer.viewOrderHistory(newOrder, prodID, prodName, prodPrice, stockQty, numberOfOrd);
                        break;
                  } 
               
                  System.out.println("[1] Back to Menu \n[2] Log Out");
                  ask3b = scan.nextInt();
               }
               
               if (ask3b == 2)
                  newCustomer.logOut();
               
               break;
         }  

         System.out.println("[1] Log In \n[2] Exit");
         ask1 = scan.nextInt();
      }

      scan.close();
   }
}