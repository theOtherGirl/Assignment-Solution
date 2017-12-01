//Software Implementation
//Anne-Marie O'Donnell - L00129696
//10/11/2017
//CustomerSerializerTester Class

package ie.lyit.tester;

import ie.lyit.files.Menu;
import ie.lyit.serialize.CustomerSerializer;

public class CustomerSerializerTester {

	public static void main(String[] args) {
		CustomerSerializer customerSerializer = new CustomerSerializer();
		
		// Add two records to the ArrayList
		//customerSerializer.addCustomer();
		//customerSerializer.addCustomer();
				
		// Write the ArrayList to File
		customerSerializer.readCustomersFromFile();
		
		Menu menuObj = new Menu();
		
		do	{
			menuObj.display();
			menuObj.readOption();
			
			if(menuObj.getOption() == 1)
			{
				customerSerializer.addCustomer();
			}
			else if(menuObj.getOption() == 2)
			{
				customerSerializer.listCustomer();
			}
			else if(menuObj.getOption() == 3)
			{
				customerSerializer.viewCustomer();
			}
			else if(menuObj.getOption() == 4)
			{
				customerSerializer.editCustomer();
			}
			else if(menuObj.getOption() == 5)
			{
				customerSerializer.deleteCustomer();
			}
			else if (menuObj.getOption()==6) {
				
				System.out.println("You are finished");
			}
				
		
		}while (menuObj.getOption() != 6);

		
		// Read the ArrayList from the File
		customerSerializer.writeCustomersToFile();
		
		// List all the books in the ArrayList
		customerSerializer.listCustomer();
	}
}//end class