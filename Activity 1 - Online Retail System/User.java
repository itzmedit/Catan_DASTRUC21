// This is the "User" class
// This class contains common attributes and methods related to user authentication and management

import java.util.Scanner;
import java.util.Random;

public class User {
   Scanner scan = new Scanner(System.in);
   private String userID = "", userName, email;
   
   public void logIn() {
      Random rand = new Random();
      for (int i = 0; i < 8; i++) userID+=rand.nextInt(9)+1;

      System.out.print("Username: ");
      userName = scan.next();
      System.out.print("Email: ");
      email = scan.next();
      System.out.println("Logged In!\n");

      System.out.println("---ADCCOUNT---");
      System.out.println("UserID: " + userID);
      System.out.println("Username: " + userName);
      System.out.println("Email: " + email + "\n");
   }
   
   public void logOut() { System.out.println("Logged Out!\n"); }
   
   public String getUserID() { return userID; }
   public String getUserName() { return userName; }
   public String getEmail() { return email; }
}