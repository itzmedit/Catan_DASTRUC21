// This program is an interactive online retail system

// These are the needed packages for this program 
import java.util.Scanner; // Scanner class
import java.util.Random; // Random class
import java.util.ArrayList; // ArrayList class
import java.time.LocalDate; // LocalDate class

/* In this scenario, we have a class hierarchy where both Customer and Admin 
   inherit from the User class. In addition, this scenario demonstrates inheritance, 
   where the Customer and Admin classes inherit attributes and methods from the User class, 
   allowing for code reuse and modeling relationships in an online retail system */

/* The User class contains common attributes and 
   methods related to user authentication and management */
class User {
   private String userID = "", userName, email;
   
   public void logIn() { // logIn method
      Scanner scan = new Scanner(System.in);
      Random rand = new Random();
      for (int i = 0; i < 8; i++) userID+=rand.nextInt(9)+1; // for userID

      System.out.print("Username: "); 
      userName = scan.next(); // for userName
      System.out.print("Email: ");
      email = scan.next(); // for email
      System.out.println("Logged In!\n");

      System.out.println("---> ADCCOUNT <---");
      System.out.println("UserID: " + userID);
      System.out.println("Username: " + userName);
      System.out.println("Email: " + email + "\n");
   }
   
   public void logOut() { System.out.println("Logged Out!\n"); } // logOut method
   
   // Getter methods
   public String getUserID() { return userID; }
   public String getUserName() { return userName; }
   public String getEmail() { return email; }
}

/* The Customer class has additional attributes and 
   methods related to placing orders and viewing order history */
class Customer extends User {
   private String customerID, address;
   private Product product = new Product();
   private Admin admin = new Admin();
   private Order order = new Order();
   
   public void placeOrder() { // placeOrder method  
      System.out.println("\n---> PLACE ORDER <---");
      System.out.println("Department: " + admin.getDepartment());
      System.out.println("List of Product/s: " + product.numberOfProd + " item/s");
      
      for (int index = 0; index < product.numberOfProd; index++) {
         System.out.print("[" + (index+1) + "]" + " Product ID: " + product.productID.get(index));
         System.out.print("      Product Name: " + product.productName.get(index));
         System.out.print("      Product Price: " + product.productPrice.get(index));
         System.out.print("      Stock Quantity: " + product.stockQuantity.get(index) + "\n");
      }
   }   
   
   public void viewOrderHistory() { // viewOrderHistory method
      System.out.println("\n---> ORDER HISTORY <---");
      System.out.println("Order ID: " + order.getOrderID());
      System.out.println("Customer ID: " + customerID);
      System.out.println("Address: " + address);
      System.out.println("Order Date: " + order.getOrderDate());
      System.out.println("List of Order/s: " + order.numberOfOrd + " item/s");
      
      for (int index = 0; index < order.numberOfOrd; index++) {
         System.out.print("Product ID: " + order.prodID.get(index));
         System.out.print("      Product Name: " + order.prodName.get(index));
         System.out.print("      Product Price: " + order.prodPrice.get(index));
         System.out.print("      Stock Quantity: " + order.stockQty.get(index) + "\n");
      }
      
      System.out.println("Total Amount: " + order.getTotalAmount() + "\n");
   } 
   
   // Setter methods
   public void setCustomerID(String _customerID) { customerID = _customerID; }
   public void setAddress() { 
      Scanner scan = new Scanner(System.in);
      System.out.println("---> CUSTOMER <---");
      System.out.print("Enter the address: ");
      address = scan.next();
      System.out.println();
   }
   
   // Getter methods
   public String getCustomerID() { return customerID; }
   public String getAddress() { return address; }
}

/* The Admin class has attributes and methods 
   related to product and inventory management */
class Admin extends User {
   private String adminID, department;
   private Product product = new Product();
   
   public void addProduct() { // addProduct method
      Scanner scan = new Scanner(System.in);
      int ask = 1, addedProd = 0;
      
      while (ask == 1) {
         System.out.println("\n---> ADD PRODUCT <---");
         
         String produID = "";
         Random rand = new Random();
         for (int i = 0; i < 8; i++) produID+=rand.nextInt(9)+1;
         product.productID.add(produID);
      
         System.out.print("Product Name: ");
         product.productName.add(scan.next());
      
         System.out.print("Product Price: ");
         product.productPrice.add(scan.nextDouble());

         System.out.print("Product Quantity: ");
         int stock = scan.nextInt();
         product.stockQuantity.add(stock);
         
         product.numberOfProd++; // increases the number of list of products
         addedProd++; // counts the added list of products
                           
         System.out.println("\nDo you want to add more? \n[1] Yes \n[2] No");
         ask = scan.nextInt();
      }
      
      System.out.println("Number of added product/s: " + addedProd);                     
   }
   
   public void removeProduct() { // removeProduct method
      Scanner scan = new Scanner(System.in);
      int ask = 1, removedProd = 0;
      
      while (ask == 1) {
         System.out.println("\n---> REMOVE PRODUCT <---");
         
         for (int index = 0; index < product.numberOfProd; index++) {
            System.out.print("[" + (index+1) + "]" + " Product ID: " + product.productID.get(index)); 
            System.out.print("      Product Name: " + product.productName.get(index));
            System.out.print("      Product Price: " + product.productPrice.get(index)); 
            System.out.print("      Stock Quantity: " + product.stockQuantity.get(index) + "\n");
         }

         System.out.print("Enter the product number: ");
         int ind = scan.nextInt();
         
         product.productID.remove(ind-1);
         product.productName.remove(ind-1);
         product.productPrice.remove(ind-1);
         product.stockQuantity.remove(ind-1);
      
         product.numberOfProd--; // decreases the number of list of products
         removedProd++; // counts the removed list of products 
      
         System.out.println("\nDo you want to remove more? \n[1] Yes \n[2] No");
         ask = scan.nextInt();
      }   
                        
      System.out.println("Number of removed product/s: " + removedProd);
   }
   
   public void manageInventory() { // manageInventory method
      Scanner scan = new Scanner(System.in);
      int ask1 = 1;
      
      while (ask1 == 1) {
         System.out.println("\n---> INVENTORY <---"); 
         System.out.println("Department: " + department);
         System.out.println("List of Product/s: " + product.numberOfProd + " item/s");
      
         for (int index = 0; index < product.numberOfProd; index++) {
            System.out.print("[" + (index+1) + "]" + " Product ID: " + product.productID.get(index)); 
            System.out.print("      Product Name: " + product.productName.get(index));
            System.out.print("      Product Price: " + product.productPrice.get(index)); 
            System.out.print("      Stock Quantity: " + product.stockQuantity.get(index) + "\n");
         }

         System.out.println("\n[1] Update Price \n[2] Update Stock \n[3] Back to Menu");
         int ask2 = scan.nextInt();
      
         switch (ask2) {
            case 1:
               System.out.println("Enter the product number: ");
               int x = scan.nextInt();
               product.updatePrice(x);
               break;
            
            case 2: 
               System.out.println("Enter the product number: ");
               int y = scan.nextInt();
               product.updateStock(y);
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
    
   // Setter methods 
   public void setAdminID(String _adminID) { adminID = _adminID; }
   public void setDepartment() {
      Scanner scan = new Scanner(System.in);
      System.out.println("---> ADMIN <---");
      System.out.print("Enter the department: "); 
      department = scan.next(); 
      System.out.println();
   }
   
   // Getter methods
   public String getAdminID() { return adminID; }
   public String getDepartment() { return department; }
}

/* The Product class represents the products available for sale, with attributes 
   such as product ID, name, price, and stock quantity. 
   It also includes methods for updating price and stock */
class Product {
   static int numberOfProd;
   
   static ArrayList<String> productID; 
   static ArrayList<String> productName; 
   static ArrayList<Double> productPrice;
   static ArrayList<Integer> stockQuantity;

   public Product() { // constructor
      productID = new ArrayList<String>();
      productName = new ArrayList<String>();
      productPrice = new ArrayList<Double>();
      stockQuantity = new ArrayList<Integer>();
      numberOfProd = 0;
   }

   public void updatePrice(int n) { // updatePrice method
      Scanner scan = new Scanner(System.in);
      System.out.println("\n---> UPDATE PRICE <---");
         
      System.out.println("Current Price: " + productPrice.get(n-1));
      System.out.print("Enter the new price: ");
      productPrice.set(n-1, scan.nextDouble());
      System.out.println("Product Price Updated!");
   }
   
   public void updateStock(int n) { // updateStock method
      Scanner scan = new Scanner(System.in);
      System.out.println("\n---> UPDATE STOCK <---");
         
      System.out.println("Current Stock: " + stockQuantity.get(n-1));
      System.out.print("Enter the new stock: ");
      stockQuantity.set(n-1, scan.nextInt());
      System.out.println("Stock Quantity Updated!");
   } 
}

/* The Order class is used to represent customer orders, 
   including details like order ID, customer ID, products in the order, 
   total amount, and order date. It includes methods for calculating the 
   total order amount, adding products to the order, and confirming the order */
class Order {
   private double totalAmount = 0.0; 
   private String orderID = "", orderDate = "";
   static int numberOfOrd = 0;
   private Product product = new Product();
   private Customer customer = new Customer();
   
   static ArrayList<String> prodID;
   static ArrayList<String> prodName;
   static ArrayList<Double> prodPrice;
   static ArrayList<Integer> stockQty;
    
   public Order() { // constructor
      prodID = new ArrayList<String>();
      prodName = new ArrayList<String>();
      prodPrice = new ArrayList<Double>();
      stockQty = new ArrayList<Integer>();
   } 
    
   public void calculateTotalAmount() { // calculateTotalAmount method
      for (int index = 0; index < numberOfOrd; index++) totalAmount+=(prodPrice.get(index)*stockQty.get(index));
   }
   
   public void addProductToOrder() { // addProductToOrder method
      Scanner scan = new Scanner(System.in);
      int ask = 1;
      
      while (ask == 1) {         
         System.out.print("\n---> ADD PRODUCT TO ORDER <---");
         System.out.println("\nEnter the product number: ");
         int index = scan.nextInt();
         
         System.out.println("Enter the quantity: ");
         int qty = scan.nextInt();
      
         prodID.add(product.productID.get(index-1));
         prodName.add(product.productName.get(index-1));
         prodPrice.add(product.productPrice.get(index-1));
         stockQty.add(qty);
         product.stockQuantity.set(index-1, product.stockQuantity.get(index-1)-qty);
         
         numberOfOrd++; // increases the number of list of ordered products
      
         System.out.println("\nDo you want to add more? \n[1] Yes \n[2] No");
         ask = scan.nextInt();
      }
   }
   
   public void confirmOrder() { // confirmOrder method
      System.out.println("\n---> CONFIRMED ORDER <---");
      
      LocalDate orderdate = LocalDate.now();
      orderDate = orderdate.toString();
      
      Random rand = new Random();
      for (int i = 0; i < 8; i++) orderID+=rand.nextInt(9)+1;
      
      System.out.println("\n---> ORDER RECEIPT <---");
      System.out.println("Order ID: " + orderID);
      System.out.println("Customer ID: " + customer.getUserID());
      System.out.println("Address: " + customer.getAddress());
      System.out.println("Order Date: " + orderDate);
      
      for (int index = 0; index < product.numberOfProd; index++) {
         System.out.print("Product ID: " + prodID.get(index));
         System.out.print("      Product Name: " + prodName.get(index));
         System.out.print("      Product Price: " + prodPrice.get(index));
         System.out.print("      Stock Quantity: " + stockQty.get(index) + "\n");
      }
      
      calculateTotalAmount();
      System.out.println("Total Amount: " + totalAmount + "\n");
   }

   // Getter methods
   public double getTotalAmount() { return totalAmount; }
   public String getOrderID() { return orderID; }
   public String getOrderDate() { return orderDate; }
}

// The OnlineRetailSystemFinal class
public class OnlineRetailSystemFinal {
   static public void main(String[] args) { // main method
      Scanner scan = new Scanner(System.in);
      Admin newAdmin = new Admin();
      Customer newCustomer = new Customer();
      Order newOrder = new Order();
         
      System.out.println("---> ONLINE SHOP <---");
      System.out.println("[1] Log In \n[2] Exit");
      int ask1 = scan.nextInt();
      
      while (ask1 == 1) {
         System.out.println("\n---> LOG IN as <---");
         System.out.println("[1] Admin \n[2] Customer \n[3] Cancel");
         int ask2 = scan.nextInt();
         
         switch (ask2) {
            case 1:
               System.out.println("\n---> ADMIN <---");
               newAdmin.logIn();
               newAdmin.setDepartment();
               
               int ask3a = 1;
            
               while (ask3a == 1) {
                  System.out.println("---> ADMIN <---");
                  newAdmin.setAdminID(newAdmin.getUserID());
                  System.out.println("Admin ID: " + newAdmin.getAdminID());
                  System.out.println("[1] Add Product \n[2] Remove Product \n[3] Manage Inventory \n[4] Cancel");
                  int ask4a = scan.nextInt();
                  
                  switch (ask4a) {
                     case 1: 
                        newAdmin.addProduct();                     
                        break;
                        
                     case 2:
                        newAdmin.removeProduct();
                        break;
                        
                     case 3:
                        newAdmin.manageInventory();                        
                        break;
                  }
                  
                  System.out.println("\n[1] Back to Menu \n[2] Log Out");
                  ask3a = scan.nextInt();
               } 
               
               if (ask3a == 2)
                  newAdmin.logOut();
                     
               break;
         
            case 2:
               System.out.println("\n---> CUSTOMER <---");
               newCustomer.logIn();
               newCustomer.setAddress();
               
               int ask3b = 1;
               
               while (ask3b == 1) {
                  System.out.println("---> CUSTOMER <---");
                  newCustomer.setCustomerID(newCustomer.getUserID());
                  System.out.println("Customer ID: " + newCustomer.getCustomerID());
                  System.out.println("[1] Place Order \n[2] View Order History \n[3] Cancel");
                  int ask4b = scan.nextInt(); 
                  
                  switch (ask4b) {
                     case 1:
                        newCustomer.placeOrder();
                        
                        System.out.println("\n[1] Add Product To Order \n[2] Cancel");
                        int ask5d = scan.nextInt();
                        
                        switch (ask5d) {
                           case 1: 
                              newOrder.addProductToOrder();

                              System.out.println("\n[1] Confirm Order [2] Cancel");
                              int ask7a = scan.nextInt();
                                 
                              switch (ask7a) {
                                 case 1: 
                                    newOrder.confirmOrder();
                                    break;
                              }

                              break;
                        }
                        
                        break;
                        
                     case 2:
                        newCustomer.viewOrderHistory();
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