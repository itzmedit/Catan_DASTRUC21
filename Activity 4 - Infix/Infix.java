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
         System.out.print("\nEnter a postfix equation: ");
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
      Scanner scan = new Scanner(equation); // Scanner class
      LinkedList<String> operand = new LinkedList<String>(); // variable for operands
      LinkedList<Character> operator = new LinkedList<Character>(); // variable for operators
      LinkedList<String> result = new LinkedList<String>(); // variable for result
      
      // Checks the scan if has next
      while (scan.hasNext()) {
         String value = scan.next(); // variable for value 
         
         // Checks if the string is a numerical data
         if (Character.isDigit(value.charAt(0)) || (value.length() > 1 && isOp(value.charAt(0)))) {
            // Checks if the operand is not empty
            if (operand.size() != 0) {
               if (Character.isDigit(operand.get(0).charAt(0)) || (operand.get(0).length() > 1  && isOp(operand.get(0).charAt(0)))) {
                  operand.addLast("#");
                  operand.addLast(value);
                  
                  // Transfers the operand's data into result
                  for (int x = 0; x < 3; x++) result.add(operand.get(x));
                  operand.clear(); // clears the operand
               }
            }
            
            else { 
               if (operand.size() == 0 && result.size() != 0) { 
                  operand.addLast("#"); 
                  operand.addLast(value);
                  
                  // Transfers the operand's data into result
                  for (int x = 0; x < 2; x++) result.add(operand.get(x));
                  operand.clear(); // clears the operand
               }
                  
               else { operand.addLast(value); } // adds the value in operand
            }            
         }

         // Checks if the string is a non-numerical data
         else { 
            boolean hasPara = false;

            if (result.size() != 0) {
               int x;
               
               for (x = result.size()-1; x >= 0; x--) {
                  if (result.get(x).equals("#")) { 
                     result.set(x, value); // changes the "#" to value
                     
                     // Adding open parenthesis
                     for (int y = x; y >= 0; y--) {
                        if (result.get(y).equals("#")) {
                           result.add(y+1, "(");
                           hasPara = true;
                           break;
                        }
                     }

                     // Adding close parenthesis
                     result.addLast(")");
                     break; 
                  }
               }
               
               operator.addLast(value.charAt(0)); // adds value to operator 
            }

            if (!hasPara) { result.addFirst("("); } // adds open parenthesis at first in result
         }
       
         // To check if the values are separated correctly 
         System.out.println("\nCurrent string: " + value); 
         System.out.println("Operand content: " + operand);
         System.out.println("Operator content: " + operator);
         System.out.println("Result content: " + result);
      }
      
      //for (int x = countOp - countOpen; x > 0; x++) { result.addFirst("("); } adds open parenthesis at first in result
      
      // Prints the result
      System.out.print("\nInfix: ");
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
      return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
   }
}