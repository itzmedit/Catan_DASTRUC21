// These are the packages needed for this program
import java.util.Scanner;
import java.util.LinkedList;

// The Infix class
public class Infix { 
   static public void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      String ask = "1", equation;
        
      // Using a while loop
      while (Integer.parseInt(ask) == 1) { 
          System.out.print("\nEnter an equation: ");
          equation = scan.nextLine();
          convertInfix(equation);

          do { // to check the input if valid or invalid
             // Asks the user if wants to try more 
             System.out.println("\nDo you want to try more? \n[1] Yes \n[2] No");
             ask = scan.nextLine().replaceAll(" ", ""); // replaces white space
               
             if (invalid(ask)) { System.out.println("Invalid input! Please select again..."); }
          } while (invalid(ask)); // let the user enter again if invalid
      }
        
      // Prints exit when done
      System.out.println("\nExit!");
      scan.close();
   }
   
   // The convertInfix method with an equation as the parameter
   public static void convertInfix(String equation) {
      Scanner scan = new Scanner(equation);
      LinkedList<String> value = new LinkedList<String>();
      LinkedList<String> result = new LinkedList<String>();
      
      while (scan.hasNext()) {
         String val = scan.next(); 
         
         if (Character.isDigit(val.charAt(0)) || (val.length() > 1 && isOp(val.charAt(0)))) {
            if (result.size() != 0 || value.size() == 1) { 
               value.addLast("*");
               value.addLast(val);
            }
            
            else { value.addLast(val); }
               
         }  
         
         else if (isOp(val.charAt(0))) { // can read dig dig opr when result is not empty
            if (result.size() == 0) {
               result.addLast(value.get(0));
               result.addLast(value.get(1));
               result.addLast(val);
               value.removeLast();
               value.removeLast();
            }
            
            else if (value.size() == 1) {
               result.addLast(value.get(0));
               result.addLast(val);
               value.removeLast();
            }
            
            else if (value.size() == 3) 
            
            else {
               for (int x = 0; x < value.size(); x++) {
                  if (result.get(x).equals("*")) { result.set(x, val); }
               }
            }
         }
      }       
     
      System.out.print("Infix: ");
  
      for (String x : result)
         System.out.print(x + " ");

      System.out.println();
   }
   
   // invalidInputYN method with an input as a parameter
   public static boolean invalid(String _input) {
      return ((_input.length() != 1 || !Character.isDigit(_input.charAt(0))) || (Integer.parseInt(_input) != 1 && Integer.parseInt(_input) != 2));
   }

   //The isOperator method checks if the character is an operator
   public static boolean isOp(char ch) {
      return ch == '+' || ch == '-' || ch == '*' || ch == '/';
   }
}