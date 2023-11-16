package utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.core.Customer;
import com.core.Plan;

import custom.exception.InvalidInput;
import validateInput.InputValidation;

public class CustomerDataUtil {

	public static  Map<Integer, Customer> populateCustomer () throws InvalidInput {
		Map<Integer, Customer> customerMap = new HashMap<>();
		 //validateAllInput(int customerId,String firstName,String lastName,String userEmail,String pass,String custaddress,String openingDate,String phone,String messPlan)
		customerMap.put(1, InputValidation.validateAllInput(1,"Himanshu","Kumar","himanshu925@gmail.com","password1","Dhanori,Pune","2023-12-02","0998765431","YEAR"));
		customerMap.put(2, InputValidation.validateAllInput(2,"Himanshu","Pandey","himans25@gmail.com","password2","Akurdi,Pune","2023-12-02","0998765431","Monthly"));
		customerMap.put(3, InputValidation.validateAllInput(3,"bhushan","Chad","Bhushan925@gmail.com","password3","Dhanori,Pune","2024-02-02","0998765431","QUARTERLY"));
		customerMap.put(4, InputValidation.validateAllInput(4,"Ashawin","Kumar","Ashawin@gmail.com","password4","Akurdi,Pune","2023-12-12","0998765431","YEAR"));
		customerMap.put(5, InputValidation.validateAllInput(5,"shiv","Sana","Shiv@gmail.com","password5","Viman Nagar,Pune","2023-12-21","0998765431","HALFYEAR"));
		customerMap.put(6, InputValidation.validateAllInput(6,"Rama","Dewedi","Apurva925@gmail.com","password6","Dhanori,Pune","2023-12-12","0998765431","YEAR"));
		customerMap.put(7, InputValidation.validateAllInput(7,"Rama","Dewedi","DewediRama925@gmail.com","password7","Pimpari,Pune","2023-12-12","0998765431","HALFYEAR"));
		customerMap.put(8, InputValidation.validateAllInput(8,"Mihir","Singh","Mihir925@gmail.com","password8","Akurdi,Pune","2023-12-03","0998765431","MONTHLY"));
		return customerMap;
		
	}
}
