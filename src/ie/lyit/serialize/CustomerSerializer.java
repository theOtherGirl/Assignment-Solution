//Software Implementation
//Anne-Marie O'Donnell - L00129696
//10/11/2017
//CustomerSerializer Class

package ie.lyit.serialize;

import java.util.ArrayList;
import java.util.Scanner;

import ie.lyit.hotel.Customer;
import java.io.*;



public class CustomerSerializer implements CustomerDAO{
	private ArrayList<Customer> customers;
	
	private final String FILENAME = "customers.bin";

	private Scanner keyboard;
	
	// Default Constructor
	public CustomerSerializer(){
		// Construct customerList ArrayList
		customers = new ArrayList<Customer>();
	}	

	//reads a customer to the ArrayList
	public void addCustomer(){
		// Create a Customer object
		Customer customer = new Customer();
		// Read its details
		customer.read();	
		// And add it to the customer ArrayList
		customers.add(customer);
	}

	
		// Lists all customer records in the ArrayList 
			
		public void listCustomer(){
			// for every Customer object in customers
	      for(Customer tmpCustomer:customers)
				// display it
				System.out.println(tmpCustomer);
		}
		
		
		// Displays the required Customer record on screen and returns it, or null if not found           
			
		public Customer viewCustomer(){
			keyboard = new Scanner(System.in);		

			// Read the number of the customer to be viewed from the user
			System.out.println("ENTER NUMBER OF CUSTOMER : ");
			int customerToView=keyboard.nextInt();
			
			// for every Customer object in customers
		    for(Customer tmpCustomer:customers){
			   // if it's number equals the number of the customerToView
			   if(tmpCustomer.getNumber() == customerToView){
			      // display it
				  System.out.println(tmpCustomer);
				  return tmpCustomer;
			   }
			}
		    // if we reach this code the customer was not found so return null
		    return null;		
		}

		// Deletes the required Customer record from customers
		
		public void deleteCustomer(){	
			// Call view() to find, display, & return the customer to delete
			Customer tempCustomer = viewCustomer();
			// If the customer != null, if it was found then...
		    if(tempCustomer != null)
			   // remove it from customers
		       customers.remove(tempCustomer);
		}
		
		// Edits the required Customer record in customer  
		
		public void editCustomer(){	
			// Call view() to find, display, & return the customer to edit
			Customer tempCustomer = viewCustomer();
			// If the customer != null, if it was found then...
		    if(tempCustomer != null){
			   // get it's index
			   int index=customers.indexOf(tempCustomer);
			   // read in a new customer and...
			   tempCustomer.read();
			   // reset the object in customer
			   customers.set(index, tempCustomer);
		    }
		}
	
	// This method will serialize the customers ArrayList when called ad it will write it to a file called customers.bin
	public void writeCustomersToFile(){
		ObjectOutputStream os=null;
		try {
			// Serialize the ArrayList...
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
		
			os = new ObjectOutputStream(fileStream);
				
			os.writeObject(customers);
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store customers.");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		finally {
			try {
				os.close();
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
		}
	}

	// This method will deserialize the customers ArrayList when called, it will restore the ArrayList from the file customers.bin
	public void readCustomersFromFile(){
		ObjectInputStream is=null;
		
		try {
			// Deserialize the ArrayList...
			FileInputStream fileStream = new FileInputStream(FILENAME);
		
			is = new ObjectInputStream(fileStream);
				
			customers = (ArrayList<Customer>)is.readObject();	
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store customers.");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			try {
				is.close();
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
		}
			//checks for the next highest customer number and allocates this number to the next customer
			int highest_No = 0;
			
		 for(Customer tmpCustomer:customers) {
			 if(highest_No < tmpCustomer.getNumber()) {
				 
				 highest_No = tmpCustomer.getNumber();
			 }
			highest_No++;
			Customer.setnextNumber(highest_No);	
		 }
				
				
	}
}