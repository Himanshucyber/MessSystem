package validateInput;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.core.Customer;
import com.core.Plan;

import custom.exception.InvalidInput;
import java.util.Scanner;


public class InputValidation {

	Scanner sc =new Scanner(System.in);
	public static LocalDate parseDate(String date) throws InvalidInput {
		LocalDate openingDate = LocalDate.parse(date);
		// parsing success --> validations
		LocalDate checkDate = LocalDate.now();
		if (openingDate.isBefore(checkDate))
			throw new InvalidInput("Invalid Registation Date : ");
		return openingDate;
		
	}
	
//	public static String validateEmail(String email){
//		return "";	
//		}
	public static Plan parseandvalidateplan(String plan)throws IllegalArgumentException {
      
	  return Plan.valueOf(plan);
		
	}
	public static String validatePhone(String phone)throws InvalidInput{
		
		
		if(phone.length()==10) {
			return phone;
		}
		else {
			throw new InvalidInput("Invalid Phone");
		}
		
		
	}
	public static String validateEmail(String email)throws InvalidInput{
		
		
		 String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

	        // Compile the regular expression into a Pattern
	        Pattern pattern = Pattern.compile(emailRegex);

	        // Match the given email against the pattern
	        Matcher matcher = pattern.matcher(email);
	        
	        if(matcher.matches()) {
	        	return email;
	        }
	        else {
	        	throw new InvalidInput("Invalid Email");
	        }
	}
	
	public static LocalDate calEndPlanDate(String plan,LocalDate date)throws InvalidInput {
		//currentDate.plusMonths(numberOfMonths)
		
		if((plan.toUpperCase()).equals("MONTHLY")) {
			return date.plusMonths(1);
		}
		else if((plan.toUpperCase()).equals("QUARTERLY")) {
			return date.plusMonths(3);
		}
		else if((plan.toUpperCase()).equals("HALFYEAR")) {
			return date.plusMonths(6);
		}
		//YEAR
		else if((plan.toUpperCase()).equals("YEAR")) {
			return date.plusMonths(12);
		}
		else {
			throw new InvalidInput("Invalid Plan Selection");
		}
		
		
	}
	
	
	       // int custId, String firstName, String lastName, String email, String password, String address,
			//LocalDate registerDate,LocalDate planEndDate, String phoneno, Plan plan,double final_amount
	   	public static Customer validateAllInput(int customerId,String firstName,String lastName,String userEmail,String pass,String custaddress,String openingDate,String phone,String messPlan) throws InvalidInput{
	   		
	   		LocalDate date=parseDate(openingDate);
	   		String validemail=validateEmail(userEmail);
	   		String mobile=validatePhone(phone);
	   		Plan plan=parseandvalidateplan(messPlan);
	   		LocalDate endPlanDate=calEndPlanDate(messPlan,date);
	   		
	   		double amount=plan.getPrice();
	   		
	   		return new Customer(customerId,firstName,lastName,validemail,pass,custaddress,date,endPlanDate,mobile, plan,amount);
	   	}
	   		
	   	
	        
	}
	
	

