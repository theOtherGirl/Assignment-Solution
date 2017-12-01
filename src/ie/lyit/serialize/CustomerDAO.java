package ie.lyit.serialize;

import ie.lyit.hotel.Customer;

	public interface CustomerDAO {
		
		
		public void addCustomer();

		public void listCustomer();

		public Customer viewCustomer();

		public void deleteCustomer();

		public void editCustomer();

		public void writeCustomersToFile();

		public void readCustomersFromFile();
		

	}

	

