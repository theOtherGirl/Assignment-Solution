//Software Implementation
//Anne-Marie O'Donnell - L00129696
//10/11/2017
//Menu Class

package ie.lyit.files;

import java.util.Scanner;

public class Menu {
   private int option;
   //creating a menu
   public void display(){
     System.out.println("\t1. Add");
	 System.out.println("\t2. List");
	 System.out.println("\t3. View");
	 System.out.println("\t4. Edit");
	 System.out.println("\t5. Delete");
	 System.out.println("\t6. Quit");		
   }
	
   public void readOption(){
      Scanner kbIn = new Scanner(System.in);
  	  System.out.println("\n\tEnter Option [1|2|3|4|5|6]");
  	  option=kbIn.nextInt();
   	  
   }
					
	public int getOption(){
	   return option;
	}	
}