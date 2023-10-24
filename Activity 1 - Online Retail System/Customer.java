// This is the "Customer" class inherit from the "User" class
// This class has attributes and methods related to placing orders and viewing order history

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {
   Scanner scan = new Scanner(System.in);
   private String customerID, address;
   
   public void placeOrder(Admin admin, ArrayList<String> a, ArrayList<String> b, ArrayList<Double> c, ArrayList<Integer> d, int num) { 
      System.out.println("\n---PLACE ORDER---");
      System.out.println("Department: " + admin.getDepartment());
      System.out.println("List of Product/s: " + num + " item/s");
      
      for (int index = 0; index < num; index++) {
         System.out.print("[" + (index+1) + "]" + " Product ID: " + a.get(index));
         System.out.print("      Product Name: " + b.get(index));
         System.out.print("      Product Price: " + c.get(index));
         System.out.print("      Stock Quantity: " + d.get(index) + "\n");
      }
   }   
   
   public void viewOrderHistory(Order order, ArrayList<String> a, ArrayList<String> b, ArrayList<Double> c, ArrayList<Integer> d, int count) {
      System.out.println("\n---ORDER HISTORY---");
      System.out.println("Order ID: " + order.getOrderID());
      System.out.println("Customer ID: " + customerID);
      System.out.println("Address: " + address);
      System.out.println("Order Date: " + order.getOrderDate());
      
      for (int index = 0; index < count; index++) {
         System.out.print("Product ID: " + a.get(index));
         System.out.print("      Product Name: " + b.get(index));
         System.out.print("      Product Price: " + c.get(index));
         System.out.print("      Stock Quantity: " + d.get(index) + "\n");
      }
      
      System.out.println("Total Amount: " + order.getTotalAmount() + "\n");
   } 
   
   public void setCustomerID(String _customerID) { customerID = _customerID; }
   
   public void setAddress() { 
      System.out.println("---CUSTOMER---");
      System.out.print("Enter the address: ");
      address = scan.next();
      System.out.println();
   }
   
   public String getCustomerID() { return customerID; }
   public String getAddress() { return address; }
}