// This is the "Order" class
// This class is used to represent customer orders, including details like order ID, customer ID, products in the order, total amount, and order date
// It includes methods for calculating the total order amount, adding products to the order, and confirming the order

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Random;

public class Order {
   Scanner scan = new Scanner(System.in);
   private double totalAmount = 0.0; 
   private String orderID = "", orderDate = "";
   
   public void calculateTotalAmount(ArrayList<Double> price, int count, ArrayList<Integer> qty) {
      for (int index = 0; index < count; index++) totalAmount+=(price.get(index)*qty.get(index));
   }
   
   public void addProductToOrder(Admin admin, Customer customer, ArrayList<String> a, ArrayList<String> b, ArrayList<Double> c, ArrayList<Integer> d, ArrayList<String> e, ArrayList<String> f, ArrayList<Double> g, ArrayList<Integer> h, int num) {
      System.out.print("\n---ADD PRODUCT TO ORDER---");
      customer.placeOrder(admin, a, b, c, d, num);
      
      System.out.println("\nEnter the product number: ");
      int index = scan.nextInt();
         
      System.out.println("Enter the quantity: ");
      int qty = scan.nextInt();
      
      e.add(a.get(index-1));
      f.add(b.get(index-1));
      g.add(c.get(index-1));
      h.add(qty);
      d.set(index-1, d.get(index-1)-qty);
   }
   
   public void confirmOrder(Customer customer, ArrayList<String> a, ArrayList<String> b, ArrayList<Double> c, ArrayList<Integer> d, int count) {
      System.out.println("\n---CONFIRMED ORDER---");
      
      LocalDate orderdate = LocalDate.now();
      orderDate = orderdate.toString();
      
      Random rand = new Random();
      for (int i = 0; i < 8; i++) orderID+=rand.nextInt(9)+1;
      
      System.out.println("\n---ORDER RECEIPT---");
      System.out.println("Order ID: " + orderID);
      System.out.println("Customer ID: " + customer.getUserID());
      System.out.println("Address: " + customer.getAddress());
      System.out.println("Order Date: " + orderDate);
      
      for (int index = 0; index < count; index++) {
         System.out.print("Product ID: " + a.get(index));
         System.out.print("      Product Name: " + b.get(index));
         System.out.print("      Product Price: " + c.get(index));
         System.out.print("      Stock Quantity: " + d.get(index) + "\n");
      }
      
      calculateTotalAmount(c,count,d);
      System.out.println("Total Amount: " + totalAmount + "\n");
   }

   public double getTotalAmount() { return totalAmount; }
   public String getOrderID() { return orderID; }
   public String getOrderDate() { return orderDate; }
}