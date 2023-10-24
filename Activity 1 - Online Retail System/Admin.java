// This is the "Admin" class inherit from the "User" class
// This class has attributes and methods related to product and inventory management

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Admin extends User {
   Scanner scan = new Scanner(System.in);
   private String adminID, department, productID = "";
   
   public void addProduct(ArrayList<String> a, ArrayList<String> b, ArrayList<Double> c, ArrayList<Integer> d) {
      Random rand = new Random();
      for (int i = 0; i < 8; i++) productID+=rand.nextInt(9)+1;
      a.add(productID);
      
      System.out.print("Product Name: ");
      b.add(scan.next());
      
      System.out.print("Product Price: ");
      c.add(scan.nextDouble());

      System.out.print("Product Quantity: ");
      d.add(scan.nextInt());

      productID = "";
   }
   
   public void removeProduct(ArrayList<String> a, ArrayList<String> b, ArrayList<Double> c, ArrayList<Integer> d, int num) {
      for (int index = 0; index < num; index++) {
         System.out.print("[" + (index+1) + "]" + " Product ID: " + a.get(index)); 
         System.out.print("      Product Name: " + b.get(index));
         System.out.print("      Product Price: " + c.get(index)); 
         System.out.print("      Stock Quantity: " + d.get(index) + "\n");
      }

      System.out.print("Enter the product number: ");
      int ind = scan.nextInt();
      a.remove(ind-1);
      b.remove(ind-1);
      c.remove(ind-1);
      d.remove(ind-1);
   }
   
   public void manageInventory(ArrayList<String> a, ArrayList<String> b, ArrayList<Double> c, ArrayList<Integer> d, int num) {
      Product product = new Product();
      int ask1 = 1;
      
      while (ask1 == 1) {
         System.out.println("\n---INVENTORY---"); 
         System.out.println("Department: " + department);
         System.out.println("List of Product/s: " + num + " item/s");
      
         for (int index = 0; index < num; index++) {
            System.out.print("[" + (index+1) + "]" + " Product ID: " + a.get(index)); 
            System.out.print("      Product Name: " + b.get(index));
            System.out.print("      Product Price: " + c.get(index)); 
            System.out.print("      Stock Quantity: " + d.get(index) + "\n");
         }

         System.out.println("\n[1] Update Price \n[2] Update Stock \n[3] Back to Menu");
         int ask2 = scan.nextInt();
      
         switch (ask2) {
            case 1:
               System.out.println("Enter the product number: ");
               int x = scan.nextInt();
               product.updatePrice(c, x);
               break;
            
            case 2: 
               System.out.println("Enter the product number: ");
               int y = scan.nextInt();
               product.updateStock(d, y);
               break;
         }
         
         if (ask2 != 3) {
            System.out.println("\nDo you want to continue? \n[1] Yes \n[2] No");
            ask1 = scan.nextInt();
         }
         else
            ask1 = 2;
      }
   } 
    
   public void setAdminID(String _adminID) { adminID = _adminID; }
   
   public void setDepartment() {
      System.out.println("---ADMIN---");
      System.out.print("Enter the department: "); 
      department = scan.next(); 
      System.out.println();
   }
   
   public String getAdminID() { return adminID; }
   public String getDepartment() { return department; }
}