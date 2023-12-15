// java.util package
import java.util.Scanner;

// class Node
class Node {
   double key;
   Node left, right;

   // Constructor
   public Node(double item) {
        key = item;
        left = right = null;
   }
}

// class BinaryTree
public class BinaryTree {
    Node root;

    // Constructor
    BinaryTree() { root = null; }

    // insert method
    Node insert(Node root, double key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        
        if (key < root.key) { root.left = insert(root.left, key); } 
        
        else if (key > root.key) { root.right = insert(root.right, key); }
        
        return root;
    }
   
    // printInorder method
	 void printInorder(Node node) {
        if (node == null) { return; }
        
        // Prints the left
		  printInorder(node.left);
      
        String num = node.key + "";

        int index = num.indexOf('.'); // index of a dot operator
            
        // Checks if the result has decimal values
        if (num.charAt(index+1) == '0' && num.length() == index+2) {
            StringBuilder result = new StringBuilder(num);
   
            // Sets characters into null
            String str = " ";
            for (int x = index; x < num.length(); x++) { result.setCharAt(x, str.charAt(0)); }
       
            String r = result.toString().replaceAll(" ", "");
            System.out.print(r + " "); // prints the result 
        }

        // Prints the result with decimal values
        else { System.out.print(node.key + " "); }
      
        // Prints the right
	     printInorder(node.right);
	 }   

    // printPreorder method
  	 void printPreorder(Node node) {
        if (node == null) { return; }

        String num = node.key + "";

        int index = num.indexOf('.'); // index of a dot operator
            
        // Checks if the result has decimal values
        if (num.charAt(index+1) == '0' && num.length() == index+2) {
            StringBuilder result = new StringBuilder(num);
   
            // Sets characters into null
            String str = " ";
            for (int x = index; x < num.length(); x++) { result.setCharAt(x, str.charAt(0)); }
       
            String r = result.toString().replaceAll(" ", "");
            System.out.print(r + " "); // prints the result 
        }

        // Prints the result with decimal values
        else { System.out.print(node.key + " "); }

        // Prints the left
        printPreorder(node.left);
        // Prints the right
        printPreorder(node.right);
    }

    // printPostorder method
  	 void printPostorder(Node node) {
        if (node == null) { return; }

        // Prints the left
        printPostorder(node.left);
        // Prints the right
        printPostorder(node.right);
        
        String num = node.key + "";

        int index = num.indexOf('.'); // index of a dot operator
            
        // Checks if the result has decimal values
        if (num.charAt(index+1) == '0' && num.length() == index+2) {
            StringBuilder result = new StringBuilder(num);
   
            // Sets characters into null
            String str = " ";
            for (int x = index; x < num.length(); x++) { result.setCharAt(x, str.charAt(0)); }
       
            String r = result.toString().replaceAll(" ", "");
            System.out.print(r + " "); // prints the result 
        }

        // Prints the result with decimal values
        else { System.out.print(node.key + " "); }
    }
    
    // search method
    Node search(Node root, double key) {
        if (root == null || root.key == key) { return root; }
        
        if (key < root.key) { return search(root.left, key); }
        
        return search(root.right, key);
    }

    // minValue method
    Node minValue(Node node) {
        Node current = node;
        
        while (current.left != null) { current = current.left; }
        
        return current;
    }

    // delete method
    Node delete(Node root, double key) {
        if (root == null) { return root; }
        
        if (key < root.key) { root.left = delete(root.left, key); } 
        
        else if (key > root.key) { root.right = delete(root.right, key); } 
        
        else {
            if (root.left == null) { return root.right; } 
            
            else if (root.right == null) { return root.left; }
            
            root.key = minValue(root.right).key;
            root.right = delete(root.right, root.key);
        }
        
        return root;
    }

    // main method
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        boolean tryProg = true;
        String[] value = new String[1000];
        String input;
   
        while (tryProg) { 
            boolean invalid;
            String askMain;
            
            // Series of numbers
            do { // to check the input if valid or invalid
                invalid = false;

                System.out.println("\nEnter the numbers for the binary tree:");
                input = scan.nextLine();

                value = input.split(" ");
                
                for (String val : value) { if (invalidInput(val)) { invalid = true; } }

                if (invalid) { System.out.print("\nInvalid input! Please enter again..."); }
            
            } while (invalid); // let the user enter again if invalid

            for (String val : value) { tree.root = tree.insert(tree.root, Double.parseDouble(val)); }
            
            String ask = "1";

            while (Integer.parseInt(ask) != 0) {
                String ask1;

                do { // to check the input if valid or invalid
                   System.out.println("\n---> BINARY TREE <---");
                   System.out.println("[1] TRAVERSALS \n[2] INSERT \n[3] DELETE \n[4] SEARCH \n[5] CLEAR \n[0] EXIT");
                   ask1 = scan.nextLine().replaceAll(" ", "");

                  if (invalidInputSelectA(ask1)) { System.out.print("\nInvalid input! Please select again..."); }
         
                } while (invalidInputSelectA(ask1)); // let the user select again if invalid
            
                switch (Integer.parseInt(ask1)) {
                    // Traversals
                    case 1: 
                        String ask2a = "1";
                        String ask2b;

                        while (Integer.parseInt(ask2a) == 1) {
                            do { // to check the input if valid or invalid
                                System.out.println("\n---> TRAVERSALS <---");
                                System.out.println("[1] INORDER \n[2] PREORDER \n[3] POSTORDER \n[0] CANCEL");
                                ask2b = scan.nextLine().replaceAll(" ", "");
                        
                                if (invalidInputSelectB(ask2b)) { System.out.print("\nInvalid input! Please select again..."); }
                        
                            } while (invalidInputSelectB(ask2b)); // let the user select again if invalid

                            switch (Integer.parseInt(ask2b)) {
                                // Inorder Traversal
                                case 1:
                                    System.out.println("\nInorder traversal of the binary tree:");

                                    if (tree.root != null) {
                                        tree.printInorder(tree.root);
                                        System.out.println();
                                    }

                                    else { System.out.println("A binary tree is empty."); }

                                    break;
                            
                                // Preorder Traversal
                                case 2: 
                                    System.out.println("\nPreorder traversal of the binary tree: ");

                                    if (tree.root != null) {
                                        tree.printPreorder(tree.root);
                                        System.out.println();
                                    }

                                    else { System.out.println("A binary tree is empty."); }

                                    break;

                                // Postorder Traversal
                                case 3:
                                    System.out.println("\nPostorder traversal of the binary tree:");
                                    
                                    if (tree.root != null) {
                                        tree.printPostorder(tree.root);
                                        System.out.println();
                                    }

                                    else { System.out.println("A binary tree is empty."); }

                                    break;
                
                            }

                            if (Integer.parseInt(ask2b) != 0) {
                                do { // to check the input if valid or invalid
                                    System.out.println("\nDo you want to traverse again? \n[1] Yes \n[2] No");
                                    ask2a = scan.nextLine().replaceAll(" ", "");
                            
                                    if (invalidInputYN(ask2a)) { System.out.print("\nInvalid input! Please select again..."); }
                         
                                } while (invalidInputYN(ask2a)); // let the user select again if invalid
                            }

                            else { ask2a = "2"; }
                        }

                        break;
                    
                    // Insert
                    case 2:
                        String ask3a = "1";
                        String ask3b;

                        while (Integer.parseInt(ask3a) == 1) {
                            do { // to check the input if valid or invalid
                                System.out.println("\n---> INSERT <---");
                                System.out.println("Enter a number to insert in the binary tree: ");
                                ask3b = scan.nextLine().replaceAll(" ", "");

                                if (invalidInput(ask3b)) { System.out.print("\nInvalid input! Please enter again..."); }
                           
                            } while (invalidInput(ask3b)); // let the user enter again if invalid

                            Node find = tree.search(tree.root, Double.parseDouble(ask3b));

                            if (find == null) { 
                                tree.root = tree.insert(tree.root, Double.parseDouble(ask3b));
                                System.out.println("\nA number has been successfully added in the binary tree.");
                            }

                            else { System.out.println("\nA number is already exist in the binary tree."); }

                            do { // to check the input if valid or invalid
                                System.out.println("\nDo you want to insert more? \n[1] Yes \n[2] No");
                                ask3a = scan.nextLine().replaceAll(" ", "");
                            
                                if (invalidInputYN(ask3a)) { System.out.print("\nInvalid input! Please select again..."); }
                         
                            } while (invalidInputYN(ask3a)); // let the user select again if invalid
                        }

                        break;

                    // Delete
                    case 3:
                        String ask4a = "1";
                        String ask4b;

                        while (Integer.parseInt(ask4a) == 1) {
                            do { // to check the input if valid or invalid
                                System.out.println("\n---> DELETE <---");
                                System.out.println("Enter a number to delete in the binary tree: ");
                                ask4b = scan.nextLine().replaceAll(" ", "");

                                if (invalidInput(ask4b)) { System.out.print("\nInvalid input! Please enter again..."); }
                            
                            } while (invalidInput(ask4b)); // let the user enter again if invalid

                            if (tree.root != null) {
                                Node look = tree.search(tree.root, Double.parseDouble(ask4b));

                                if (look != null) {
                                    tree.root = tree.delete(tree.root, Double.parseDouble(ask4b));
                                    System.out.println("\nA number has been successfully deleted in the binary tree.");
                                }
                            
                                else { System.out.println("\nA number does not exist in the binary tree."); }
                            }

                            else { System.out.println("\nA binary tree is empty."); }

                            do { // to check the input if valid or invalid
                                System.out.println("\nDo you want to delete more? \n[1] Yes \n[2] No");
                                ask4a = scan.nextLine().replaceAll(" ", "");
                            
                                if (invalidInputYN(ask4a)) { System.out.print("\nInvalid input! Please select again..."); }
                         
                            } while (invalidInputYN(ask4a)); // let the user select again if invalid
                        }

                        break;

                    // Search
                    case 4:
                        String ask5a = "1";
                        String ask5b;

                        while (Integer.parseInt(ask5a) == 1) {
                            do { // to check the input if valid or invalid
                                System.out.println("\n---> SEARCH <---");
                                System.out.println("Enter a number to search in the binary tree: ");
                                ask5b = scan.nextLine().replaceAll(" ", "");

                                if (invalidInput(ask5b)) { System.out.print("\nInvalid input! Please enter again..."); }
                            
                            } while (invalidInput(ask5b)); // let the user enter again if invalid

                            if (tree.root != null) {
                                Node result = tree.search(tree.root, Double.parseDouble(ask5b));

                                if (result != null) { System.out.println("\nA number has been found in the binary tree."); } 
                            
                                else { System.out.println("\nA number has not been found in the binary tree."); }
                            }   
                            
                            else { System.out.println("\nA binary tree is empty."); }

                            do { // to check the input if valid or invalid
                                System.out.println("\nDo you want to search again? \n[1] Yes \n[2] No");
                                ask5a = scan.nextLine().replaceAll(" ", "");
                            
                                if (invalidInputYN(ask5a)) { System.out.print("\nInvalid input! Please select again..."); }
                         
                            } while (invalidInputYN(ask5a)); // let the user select again if invalid
                        }
                        
                        break; 
                        
                    // Clear
                    case 5:
                        System.out.println("\n---> CLEAR <---");
                        if (tree.root == null) { System.out.println("A binary tree is already empty."); }

                        else {
                            tree.root = null;
                            System.out.println("A binary tree is emptied.");
                        }

                        break;
                    
                    // Exit
                    case 0:
                        ask = "0";
                        System.out.println("\nExit...");
                        break;
                }
            }
        
            do { // to check the input if valid or invalid
                System.out.println("\nDo you want to try again? \n[1] Yes \n[2] No");
                askMain = scan.nextLine().replaceAll(" ", "");
                            
                if (invalidInputYN(askMain)) { System.out.print("\nInvalid input! Please select again..."); }
                         
            } while (invalidInputYN(askMain)); // let the user select again if invalid

            if (Integer.parseInt(askMain) != 1) { tryProg = false; }

            else { tree.root = null; }
        }

        System.out.println("\n---> EXIT <---");
        scan.close();
    }
    
    // invalidInput method 
    static boolean invalidInput(String _input) { 
        boolean invalidInput = false;
      
        if (_input.length() == 0) { invalidInput = true; }
        
        else {
            for (int x = 0; x < _input.length(); x++) {
                char ch = _input.charAt(x);
                
                if (!Character.isDigit(ch)) { 
                    if (ch == '-') { // can read a negative sign
                        if (_input.length() > 1 && x == 0 && Character.isDigit(_input.charAt(x+1))) { invalidInput = false; }
                        else { return true; }
                    }
                    
                    else if (ch == '.') { // can read a dot operator
                        if (_input.length() >= x+2 && x != 0 && Character.isDigit(_input.charAt(x+1))) { invalidInput = false; }
                        else { return true; }
                    }
                    
                    else { return true; }
                } 
            }
        }
      
        return invalidInput;
    }
   
    // invalidInputSelectA method
    static boolean invalidInputSelectA(String _input) {
        return ((_input.length() != 1 || !Character.isDigit(_input.charAt(0))) || 
            (Integer.parseInt(_input) != 0 && Integer.parseInt(_input) != 1 && Integer.parseInt(_input) != 2 && 
            Integer.parseInt(_input) != 3 && Integer.parseInt(_input) != 4 && Integer.parseInt(_input) != 5));
    }
   
    // invalidInputSelectB method
    static boolean invalidInputSelectB(String _input) {
        return ((_input.length() != 1 || !Character.isDigit(_input.charAt(0))) ||
            (Integer.parseInt(_input) != 0 && Integer.parseInt(_input) != 1 && Integer.parseInt(_input) != 2 &&
            Integer.parseInt(_input) != 3));
    }

    // invalidInputYN method
    static boolean invalidInputYN(String _input) {
        return ((_input.length() != 1 || !Character.isDigit(_input.charAt(0))) || (Integer.parseInt(_input) != 1 && Integer.parseInt(_input) != 2));
    }
}