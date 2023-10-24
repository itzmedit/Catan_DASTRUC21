// This is the "Product" class
// This class represents the products available for sale, with attributes such as product ID, name, price, and stock quantity
// It also includes methods for updating price and stock

import java.util.ArrayList;
import java.util.Scanner;

public class Product {
   Scanner scan = new Scanner(System.in);

   public void updatePrice(ArrayList<Double> p, int n) {
      System.out.println("\n---UPDATE PRICE---");
         
      System.out.println("Current Price: " + p.get(n-1));
      System.out.print("Enter the new price: ");
      p.set(n-1, scan.nextDouble());
      System.out.println("Product Price Updated!");
   }
   
   public void updateStock(ArrayList<Integer> s, int n) {
      System.out.println("\n---UPDATE STOCK---");
         
      System.out.println("Current Stock: " + s.get(n-1));
      System.out.print("Enter the new stock: ");
      s.set(n-1, scan.nextInt());
      System.out.println("Stock Quantity Updated!");
   } 
}