package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.core.Customer;

import custom.exception.InvalidInput;
import validateInput.InputValidation;

public class TestCustomer {

	public static void main(String[] args) throws InvalidInput {
		Map<Integer, Customer> customerData = new HashMap<>();

		try(Scanner sc = new Scanner(System.in)){
		int choice;
		do {
			System.out.println("Enter Your Choice \r\n "
					+ "1: Sign up Customer \r\n"
					+ "2: Sign In \r\n"
					+ "3: Change Password \r\n"
					+ "4: Sort Customer as per \r\n"
					+ "A) First name \r\n"
					+ "B) According to plan\r\n"
					+ "C) According to date of registration\r\n"
					+ "5: Unsubscribe customer according plan duration (month wise (1, 3, 6, 12))\r\n"
					+ "6: Display all Customers \r\n"
					+ "7: Modify all customers first name (make first Letter capital of customers first name)\r\n"
					+ "8: Display email addresses of the customers who did registration in month of January \r\n"
					+ "10: Display count of the Customers who have register for plan: Monthly \r\n"
					+ "11: Search the Customer who lived in Akurdi.\r\n"
					+ "12: Give the 20% discount to the customers who have selected plan for 1 year.\r\n"
					+ "0: Exit \r\n"
					);
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter custId,firstName,lastName, email,password, address,\r\n"
						+ "			//registerDate, phoneno,plan");
				//validateAllInput(int customerId,String firstName,String lastName,String userEmail,String pass,String custaddress,String openingDate,String endDate,String phone,String messPlan)
				Customer customer1=InputValidation.validateAllInput(sc.nextInt(),sc.next(),sc.next(),sc.next(), sc.next(), sc.next(),sc.next(),sc.next(),sc.next());
				customerData.put(customer1.getCustId(), customer1);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				customerData.forEach((customerId, customer) -> {
		            System.out.println("Customer Details: " + customer);
		        });
				break;
			case 7:
				break;
				
			case 8:
				break;
			case 9:
				break;
				
			case 10:
				break;
			case 11:
				break;
			case 12:
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid Choice");
				break;
				
			
			}
			
		}
		while(choice != 0 );
		
		
		}
	}
	
}
