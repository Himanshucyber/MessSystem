package test;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.core.Customer;
import com.core.Plan;

import custom.exception.InvalidInput;
import utils.CustomerDataUtil;
import validateInput.InputValidation;

public class TestCustomer {

	public static void main(String[] args) throws InvalidInput {
		Map<Integer, Customer> customerData = CustomerDataUtil.populateCustomer();

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
					+ "9: Display count of the Customers who have register for plan: Monthly \r\n"
					+ "10: Search the Customer who lived in Akurdi.\r\n"
					+ "11: Give the 20% discount to the customers who have selected plan for 1 year.\r\n"
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
				System.out.println("Sign Up Success!");
				break;

			case 2:
				String inputEmail;
				String passCode;
				System.out.print("Enter Your Email : ");
				inputEmail=sc.next();
				System.out.print("Enter Your Passworrd : ");
				passCode=sc.next();
				InputValidation.validateSignIn(inputEmail,passCode,customerData);
				System.out.println("Successful login");
				
				break;
			case 3:
				String Email;
				String oldPassWord;
				System.out.print("Enter Your Email : ");
				Email=sc.next();
				System.out.print("Enter Your old Passworrd : ");
				oldPassWord=sc.next();
				for( Customer c:customerData.values()) {
					if(c.getEmail().equals(Email)) {
						
						if(c.getPassword().equals(oldPassWord)) {
							System.out.print("Enter new Passworrd : ");
							c.setPassword(sc.next());
							
						}
						else {
							throw new InvalidInput("Wrong Password");
						}
					}				
				}
				System.out.print("Password Change Successfull ! ");
				break;
			case 4:
//				System.out.println(customerData.values()+"\n");
				
//				customerData.values().forEach(c->System.out.println(c));
//				Collections.sort(customerList,
//		                Comparator.comparing(Customer::getFirstName)
//		                          .thenComparing(Customer::getRegisterDate));

				List <Customer> customerList=new ArrayList<>( customerData.values());
                Collections.sort(customerList,Comparator.comparing(Customer::getFirstName).thenComparing(Customer::getRegisterDate)
                		.thenComparing(Customer::getPlan));
                customerList.forEach(c->System.out.println(c));
                
//				 Comparator<Map.Entry<Integer, Customer>> customComparator = Comparator
//	                .<Map.Entry<Integer, Customer>, String>comparing(entry -> entry.getValue().getFirstName()) // Sort by first name
//	                .thenComparing(entry -> entry.getValue().getPlan()) // Then sort by plan
//	                .thenComparing(entry -> entry.getValue().getRegisterDate()); // Finally, sort by registration date

	        // Sort the map by values using the custom comparator and reconstruct it as a LinkedHashMap
//	        Map<Integer, Customer> sortedCustomerData = customerData.entrySet()
//	                .stream()
//	                .sorted(customComparator)
//	                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	        
//	         sortedCustomerData.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
	        
				break;
			case 5:
				InputValidation.unsubsCustomerByPlan(sc.next(),customerData);
				
				
				break;
			case 6:
				customerData.forEach((customerId, customer) -> {
		            System.out.println("Customer Details: " + customer);
		        });
				break;
			case 7:
				customerData.forEach((customerId, customer) -> {
					String firstName=customer.getFirstName();
					customer.setFirstName(Character.toUpperCase(firstName.charAt(0))+firstName.substring(1));
		        });
				System.out.println("Successfully Change First Latter of first name Capital Latter");
//				for(Customer customer : customerData.values()) {
//					
//				}
				
				break;
				
			case 8:
				// Define a pattern for the desired date format (Month and Day)
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
				
				//Iterate through customerData(Map)  
				customerData.forEach((customerId, customer)->{
					if (customer.getRegisterDate().format(formatter).startsWith("01")) {
		                System.out.println(customer);
		            }
					
				});	
//				customerData.forEach((customerId, customer) -> {
//					String resistationDate = customer.getRegisterDate().toString();
//					System.out.println(resistationDate);
//					//2023-01-23
//					if(resistationDate.charAt(6)=='0' && resistationDate.charAt(7)=='1')
//						System.out.println(customer);
//		        });
				
				break;
			case 9:
				//boolean isSuchCustomerPresent;
				customerData.forEach((customerId, customer)->{
					
					if(customer.getPlan().equals(Plan.MONTHLY))
					{
						//isSuchCustomerPresent=true;
						System.out.println(customer);
					}
				});
				break;
				
			case 10:
				customerData.forEach((customerId,customer)->{
					if(customer.getAddress().contains("Akurdi") || customer.getAddress().contains("akurdi")) {
						System.out.println(customer);
					}
				});
				break;
			case 11:
                    customerData.forEach((customerId, customer)->{
					
					  if(customer.getPlan().equals(Plan.YEAR))
					  {
						//isSuchCustomerPresent=true;
						double discount=customer.getFinal_amount()*0.20;
						double new_amount=customer.getFinal_amount()-discount;
						  
						  customer.setFinal_amount(new_amount);
						  
						System.out.println(customer);
					  }
				    });
				break;
			
			case 0:
				System.out.println("Exiting ");
				break;
			default:
				System.out.println("Invalid Choice");
				System.out.println("");
				break;
				
			
			}
			
		}
		while(choice != 0 );
		
		
		}
	}
	
}
