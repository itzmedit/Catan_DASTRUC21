// These are the packages needed
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;

// The PMDASCalculator class
public class Postfix {
    static public void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String ask = "1", equation;
        
        // Using a while loop
        while (Integer.parseInt(ask) == 1) { 
            System.out.print("\nEnter an infix equation: ");
            equation = scan.nextLine().replaceAll(" ", ""); // replaces white spaces
            convertPostfix(equation);

            do { // to check the input if valid or invalid
               // Asks the user if wants to try more 
               System.out.println("\nDo you want to try more? \n[1] Yes \n[2] No");
               ask = scan.nextLine().replaceAll(" ", ""); // replaces white spaces
               
               if (invalidInputYN(ask)) { System.out.println("Invalid input! Please select again..."); }
            } while (invalidInputYN(ask)); // let the user enter again if invalid
        }
        
        // Prints exit when done
        System.out.println("\nExit!");
        scan.close();
    }

    // The convertPostfix method
    public static void convertPostfix(String equation) { // an equation is the parameter
        LinkedList<String> result = new LinkedList<String>(); 
        Stack<Character> operator = new Stack<>();
        String value = ""; // the variable for multiple-digit values

        // Reads each character of an equation
        for (int x = 0; x < equation.length(); x++) {
            char ch = equation.charAt(x); // the variable for a character

            // Checks if the character is a digit
            if (Character.isDigit(ch) || dotOp(ch)) { 
                value = value.concat(Character.toString(ch));
                System.out.println("Value: " + value);

                if ((x < equation.length()-1 && !Character.isDigit(equation.charAt(x+1)) && !dotOp(equation.charAt(x+1))) || x == equation.length()-1) {
                    result.addLast(value);
                    value = "";
                    
                    if (x >= 2) {
                        if (equation.charAt(x-2) == ')') {
                              if (checkPrecedence(operator.peek()) == 2) 
                                 result.addLast(String.valueOf(operator.pop()));
                        }
                    }
                }
            } 

            // Checks if the character is an open parenthesis
            else if (ch == '(')
                operator.push(ch);

            // Checks if the character is a close parenthesis
            else if (ch == ')') {
                while (operator.peek() != '(') {
                    result.addLast(String.valueOf(operator.pop())); // adds operator to result
                }
                
                operator.pop();
            } 
            
            // Checks if the character is an operator
            else if (isOperator(ch)) { 
                if (x != 0 && operator.isEmpty()) { operator.push(ch); } 
                
                // Checks if the operator is a negative sign
                else if ((x == 0) || (x >= 1 && equation.charAt(x-1) == '(') || (isOperator(equation.charAt(x-1)))) {
                    value = value.concat(Character.toString(ch));
                }
                
                else {
                    while (!operator.isEmpty() && checkPrecedence(ch) <= checkPrecedence(operator.peek())) {
                        result.addLast(String.valueOf(operator.pop())); // adds operator to result
                    }
                    
                    operator.push(ch);
                }
            }

            // To check if all the characters are separated correctly
            System.out.println("\nCurrent Character: " + ch);
            System.out.println("Result: " + result);
            System.out.println("Operator: " + operator);
        }
        
        System.out.println();

        // Adds the left character in operators to operands
        while (!operator.isEmpty()) result.addLast(String.valueOf(operator.pop()));
        
        System.out.print("Postfix: ");
        
        for (String x : result)
           System.out.print(x + " ");
        
        System.out.println();
    }

    // The isOperator method checks if the character is an operator
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    
    // The dotOp method checks if the character is a dot
    public static boolean dotOp(char ch) {
        return ch == '.';
    }
    
    // The checkPrecedence method checks if the operator has high/low precedence
    public static int checkPrecedence(char operator) {
        switch (operator) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
    
    // invalidInputYN method with an input as a parameter
    public static boolean invalidInputYN(String _input) {
       return ((_input.length() != 1 || !Character.isDigit(_input.charAt(0))) || (Integer.parseInt(_input) != 1 && Integer.parseInt(_input) != 2));
    }
}