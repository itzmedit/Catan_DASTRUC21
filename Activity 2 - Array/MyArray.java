// java.util package
import java.util.Scanner;

// MyArray class
public class MyArray {
   int[] array;
   int size, index, count;   

   // Constructor
   public MyArray(int _size) {
      size = _size;
      array = new int[size];
      index = -1;
      count = 0;
   }
   
   // isFull method 
   public boolean isFull() { return count >= size; }
   
   // isEmpty method
   public boolean isEmpty() { return count == 0; }
   
   // add method with a element parameter 
   public void add(int element) {
      if (!isFull()) { array[++index] = element; count++; } 
      else { System.out.println("The array is full!"); }
   }
   
   // view method
   public void view() {
      System.out.print("Array: "); // prints array
      for (index = 0; index < size; index++) System.out.print("[ " + array[index] +" ]"); 
      System.out.println();
   }

   // remove method with an index as a parameter
   public void remove(int _index) {
      if (!isEmpty()) { 
         if (_index < size) {
            System.out.println("Removed value: " + array[_index]);
            if (array[_index] != 0) { count--; } // decreases count
            array[_index] = 0;
         }
         
         else { System.out.println("Index out of bound!"); } // prints index out of bound 
      }
      
      else { System.out.println("The array is empty!"); } // prints array is empty
   }

   // search method with an element as a parameter
   public void search(int element) {
      if (!isEmpty()) { 
         boolean found = false; // boolean value for found
         String indxs = ""; // variable for index

         for (index = 0; index < size; index++) if (array[index] == element) { found = true; indxs+=Integer.toString(index); } 

         if (found) { // asks if it is found
            System.out.print("Element found in index: ");

            for (index = 0; index < indxs.length(); index++) {
               char ch = indxs.charAt(index);
               if (index+1 < indxs.length()) { System.out.print(ch + ", "); }
               else { System.out.println(ch); }
            }
         }

         else { System.out.println("Element not found! "); } // asks if it is not found
      }

      else { System.out.println("The array is empty!"); }
   }

   // sortAscending method
   public void sortAscending() {
      if (!isEmpty()) {
         for (index = 0; index < size; index++) {
            for (int x = 1; x < size; x++) { 
               if (array[x-1] > array[x]) {
                  int min = array[x-1];
                  array[x-1] = array[x];
                  array[x] = min;
               }
            }
         }

         System.out.println("\nSuccessfully sorted ascendingly!");
      }

      else { System.out.println("The array is empty!"); }
   }

   // sortDescending way
   public void sortDescending() {
      if (!isEmpty()) {
         for (index = 0; index < size; index++) {
            for (int x = 1; x < size; x++) { 
               if (array[x-1] < array[x]) {
                  int max = array[x-1];
                  array[x-1] = array[x];
                  array[x] = max;
               }
            }
         }

         System.out.println("\nSuccessfully sorted descendingly!");
      }

      else { System.out.println("The array is empty!"); }
   }

   // edit method with an index and an element as parameters
   public void edit(int _index, int element) {
      if (!isEmpty()) { 
         if (_index < size) {
            if (array[_index] == 0) { count++; }
            array[_index] = element; 
         }
         
         else { System.out.println("Index out of bound!"); }  
      }
      
      else { System.out.println("The array is empty!"); } 
   }

   // count method
   public int count() { return count; }
   
   // main method
   static public void main(String[] args) {
      Scanner scan = new Scanner(System.in); // Scanner class 
      String input;
 
      do { // to check the input if valid or invalid
         System.out.print("Enter the Array size: ");
         input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
         
         if (invalidInput(input)) { System.out.println("Invalid input! Please enter again...\n"); }
         
      } while (invalidInput(input)); // let the user enter again if invalid

      MyArray arr = new MyArray(Integer.parseInt(input)); // instantiation
      
      input = "1";

      while (Integer.parseInt(input) == 1) {
         do { // to check the input if valid or invalid
            System.out.println("\n---> MENU <---");
            System.out.println("Array size: " + arr.size);
            System.out.println("\n[1] ADD \n[2] VIEW \n[3] REMOVE \n[4] SEARCH \n[5] SORT \n[6] EDIT \n[7] COUNT \n[8] EXIT");
            input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
         
            if (invalidInputSelect(input)) { System.out.println("Invalid input! Please select again..."); }
         
            } while (invalidInputSelect(input)); // let the user enter again if invalid
         
         int select = Integer.parseInt(input);
         
         switch(select) {
            case 1: // ADD
               input = "1";

               while (Integer.parseInt(input) == 1) {
                  do { // to check the input if valid or invalid
                     System.out.println("\n---> ADD ELEMENT <---");
                     System.out.print("Enter an element to add: ");
                     input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
                  
                     if (invalidInput(input)) { System.out.println("Invalid input! Please enter again..."); }
         
                  } while (invalidInput(input)); // let the user enter again if invalid
                  
                  arr.add(Integer.parseInt(input));
                  
                  do { // to check the input if valid or invalid
                     System.out.println("\nDo you want to add more? \n[1] Yes \n[2] No");
                     input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
                     
                     if (invalidInputYN(input)) { System.out.println("Invalid input! Please select again..."); }
         
                  } while (invalidInputYN(input)); // let the user enter again if invalid
               }

               break;

            case 2: // VIEW
               System.out.println("\n---> VIEW ELEMENTS <---");   
               arr.view();
               break;

            case 3: // REMOVE
               input = "1";

               while (Integer.parseInt(input) == 1) {
                  do { // to check the input if valid or invalid
                     System.out.println("\n---> REMOVE ELEMENT <---");
                     System.out.print("Enter an index to remove: ");
                     input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
                     
                     if (invalidInput(input)) { System.out.println("Invalid input! Please enter again..."); }
         
                  } while (invalidInput(input)); // let the user enter again if invalid
                     
                  arr.remove(Integer.parseInt(input));

                  do { // to check the input if valid or invalid
                     System.out.println("\nDo you want to remove more? \n[1] Yes \n[2] No");
                     input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
                     
                     if (invalidInputYN(input)) { System.out.println("Invalid input! Please select again..."); }
         
                  } while (invalidInputYN(input)); // let the user enter again if invalid
               }
            
               break;

            case 4: // SEARCH
               input = "1";

               while (Integer.parseInt(input) == 1) {
                  do { // to check the input if valid or invalid
                     System.out.println("\n---> SEARCH ELEMENT <---");
                     System.out.print("Enter an element to search: ");
                     input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
                     
                     if (invalidInput(input)) { System.out.println("Invalid input! Please enter again..."); }
         
                  } while (invalidInput(input)); // let the user enter again if invalid
                     
                  arr.search(Integer.parseInt(input));

                  do { // to check the input if valid or invalid
                     System.out.println("\nDo you want to search more? \n[1] Yes \n[2] No");
                     input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
                     
                     if (invalidInputYN(input)) { System.out.println("Invalid input! Please select again..."); }
         
                  } while (invalidInputYN(input)); // let the user enter again if invalid
               }
            
               break;

            case 5: // SORT
               input = "1";

               while (Integer.parseInt(input) == 1) {
                  do { // to check the input if valid or invalid
                     System.out.println("\n---> SORT ELEMENTS <---");
                     System.out.println("[1] ASCENDING \n[2] DESCENDING");
                     input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
                     
                     if (invalidInputYN(input)) { System.out.println("Invalid input! Please select again..."); }
         
                  } while (invalidInputYN(input)); // let the user enter again if invalid
                     
                  select = Integer.parseInt(input);
                     
                  switch(select) {
                     case 1:
                        arr.sortAscending();   
                        break;

                     case 2:
                        arr.sortDescending();
                        break;
                  }

                  do { // to check the input if valid or invalid
                     System.out.println("\nDo you want try more? \n[1] Yes \n[2] No");
                     input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
                     
                     if (invalidInputYN(input)) { System.out.println("Invalid input! Please select again..."); }
         
                  } while (invalidInputYN(input)); // let the user enter again if invalid
               }

               break;

            case 6: // EDIT
               input = "1";

               while (Integer.parseInt(input) == 1) {
                  do { // to check the input if valid or invalid
                     System.out.println("\n---> EDIT ELEMENT <---");
                     System.out.print("Enter an index: ");
                     input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
                     
                     if (invalidInput(input)) { System.out.println("Invalid input! Please enter again..."); }
         
                  } while (invalidInput(input)); // let the user enter again if invalid
                     
                  int _index = Integer.parseInt(input);
                  
                  do { // to check the input if valid or invalid
                     System.out.println("\n---> EDIT ELEMENT <---");
                     System.out.println("Enter an index: " + _index);
                     System.out.print("Enter an element to set: ");
                     input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
                     
                     if (invalidInput(input)) { System.out.println("Invalid input! Please enter again..."); }
         
                  } while (invalidInput(input)); // let the user enter again if invalid
                  
                  int _element = Integer.parseInt(input);
                  arr.edit(_index, _element);

                  do { // to check the input if valid or invalid
                     System.out.println("\nDo you want to edit more? \n[1] Yes \n[2] No");
                     input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
                     
                     if (invalidInputYN(input)) { System.out.println("Invalid input! Please select again..."); }
                  
                  } while (invalidInputYN(input)); // let the user enter again if invalid
               }
               
               break;
         
            case 7: // COUNT
               System.out.println("\n---> COUNT ELEMENTS <---");   
               System.out.println("Count: " + arr.count());
               break;

            case 8: // EXIT
               System.out.println("\n---> EXIT MENU <---");
               break;
         }

         do { // to check the input if valid or invalid         
            System.out.println("\n[1] BACK TO MENU \n[2] EXIT");
            input = scan.nextLine().replaceAll(" ",""); // replaces white spaces
                     
            if (invalidInputYN(input)) { System.out.println("Invalid input! Please select again..."); }
                  
         } while (invalidInputYN(input)); // let the user enter again if invalid
      }

      // Exit
      System.out.println("\nExit!");
      scan.close();
   }
   
   // invalidInput method with an input as a parameter
   static boolean invalidInput(String _input) { 
      boolean invalidInput = false;
      
      if (_input.length() == 0) { invalidInput = true; }
      else {
         for (int x = 0; x < _input.length(); x++) {
            char ch = _input.charAt(x);
         
            if (!Character.isDigit(ch)) { invalidInput = true; } 
         }
      }
      
      return invalidInput;
   }
   
   // invalidInputSelect method with an input as a parameter
   static boolean invalidInputSelect(String _input) {
      return ((_input.length() != 1 || !Character.isDigit(_input.charAt(0))) || (Integer.parseInt(_input) == 9 || Integer.parseInt(_input) == 0));
   }
   
   // invalidInputYN method with an input as a parameter
   static boolean invalidInputYN(String _input) {
      return ((_input.length() != 1 || !Character.isDigit(_input.charAt(0))) || (Integer.parseInt(_input) != 1 && Integer.parseInt(_input) != 2));
   }
}