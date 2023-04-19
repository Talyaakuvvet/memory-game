package midterm;
import java.util.Scanner;

import java.io.InputStream;
import java.lang.*;
import java.util.*;

interface MidProject{
 char whoAmI();
}
class Cup implements MidProject{
 public char whoAmI() {
 return 'C';
 }
}
class Ball implements MidProject{
 public char whoAmI() {
 return 'B';
 }
}
class Hat implements MidProject{
 public char whoAmI() {
 return 'H';
 }
}
class Pen implements MidProject{
 public char whoAmI() {
 return 'P';
 }
}
class uni implements MidProject{
 public char whoAmI() {
 return 'U';
 }
}
public class project{
      public static void main(String[] args) {
          // Create a String to determine the order of objects in the grid
          String order = "CPCHPBUBH";
 
          MidProject[][] grid = new MidProject[3][3];
          // the grid matrix
 
          // Function call to create objects and place their references in the grid       
          createObjects(grid, order);
 
          closeGrid(grid,order);
          // the function for closed grid ,opening it one by one
          // guessing the order and writing back your game result

}
 
      public static void createObjects(MidProject[][] grid, String order) {
    	      
          int index = 0;
          for(int i=0; i<3; i++) {
              for(int j=0; j<3; j++) {
                  // Get the object type from the order string

                  char objType = order.charAt(index++);
 
                  // Create the object and place its reference in the grid

                  if(objType == 'C') {
                      grid[i][j] = new Cup();
                      }
                  else if(objType == 'B') {
                      grid[i][j] = new Ball();
                      }
                  else if(objType == 'H') {
                      grid[i][j] = new Hat();
                      }
                  else if(objType == 'P') {
                      grid[i][j] = new Pen();
                      }
                  else {
                      // Placeholder for unidentified object
                      objType = 'U';
                      grid[i][j] = new uni();
                      }
                  }
              }
 
}
      public static void closeGrid(MidProject[][] grid,String order) {

          char[][] matrix = new char[3][3]; 
          //Creates a 3x3 matrix
          //give value to each element value:'X'
          for (int i = 0; i < 3; i++) {
              for (int j = 0; j < 3; j++) {
                  matrix[i][j] = 'X';
                  System.out.print(matrix[i][j] + " ");
 
                  }
              System.out.print("\n");
              }
          //scan and enter row-col for the grid to 
          //be open by that row-col section
          
          Scanner scanner = new Scanner(System.in);
        
           for(int i = 0; i<9; i++) {
        	      System.out.println("Please enter row-col location:");

        	      int row = scanner.nextInt();
        	      int col = scanner.nextInt();
 
        	      if(matrix[row][col] != grid[row][col].whoAmI()) {
        	           matrix[row][col] = 
        	   	       grid[row][col].whoAmI();
        	           for (int b = 0; b < 3; b++) {
        	        	      for (int j = 0; j < 3; j++) {
        	        	     System.out.print(matrix[b][j] + " ");
        	        	      //going to print all x's except the 
        	        	      //one that you open.
        	          }
        	        	      System.out.print("\n");
        	        	      }
}
        	      
        	      else {
        	          //if its already open its going to print this
        	          //and decrease the i to continue until all 
        	          //the x's are open
        	          System.out.print("its already uncovered.\n");
        	          i--;
            }
}
           System.out.print("\n");
           scanner.nextLine();
           
         //asking the user if they want to play the game
         System.out.print("Do you want to cover them again to play the game yes/no:\n");
         String answer = scanner.nextLine();
         String devam = "yes";
         if(answer.equals(devam)) {
             //if it equals to yes its 
             //going to print the grid with x.
             for (int i = 0; i < 3; i++) {
                 for (int j = 0; j < 3; j++) {           	      
                     matrix[i][j] = 'X';
                     System.out.print(matrix[i][j] + " "); 
            }
 
                 System.out.print("\n");
            }
       }
         else {
           System.out.print("END");
           //writing end because the user did'nt want to play.
           }
         // taking the guess in upper case from the user to control the answer
         System.out.print("Write your guess in upper case:\n");
         String scan = scanner.nextLine();
 
         System.out.print("your answer is:\n" + scan );
         System.out.print("\nthe answer is:\n" + order);
 
         // turning the string to char array so that 
         // we can compare the real answer with the users answer.

 
         char[] Answer = order.toCharArray(); 
         char[] yourAns = scan.toCharArray();
 
         int count = 0;// for the correct answer
         int count2 = 0;// for the wrong answer
 
         for(int i = 0; i < 9; i++) {
             if(yourAns[i] == Answer[i]) {
                 count++;
                 }
             else {
                 count2++;
              }
 }
 // this code is printing how much correct and wrong answer you have.

         System.out.print("\n" + count + "corrects\n");
         System.out.print(count2 + "wrongs\n");
 
         // if its equal or greater than 4 its going to print you won
         // if its not it going to print you lose.
         if(count >= 4) {
             System.out.print("You won the game");
             }
         else {
             System.out.print("You lose the game");
         }
         
         scanner.close();
    }
}
