package com.core;

import java.time.LocalDate;

public class Customer {

	private int custId ;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private LocalDate registerDate;
	private LocalDate planEndDate;
	private String phoneno;
	private Plan plan;
	private  double final_amount;
	
	public Customer(int custId, String firstName, String lastName, String email, String password, String address,
			LocalDate registerDate,LocalDate planEndDate, String phoneno, Plan plan,double final_amount) {
		
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.registerDate = registerDate;
		this.planEndDate = planEndDate;
		this.phoneno = phoneno;
		this.plan = plan;
		this.final_amount=plan.getPrice();
		
		
	}

	
	public int getCustId() {
		return custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public LocalDate getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(LocalDate planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public double getFinal_amount() {
		return final_amount;
	}
	public void setFinal_amount(double amount) {
		this.final_amount=amount;
	}

	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", registerDate=" + registerDate
				+ ", planEndDate=" + planEndDate + ", phoneno=" + phoneno + ", plan=" + plan + ", final_amount="
				+ final_amount + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return custId == other.custId;
	}
		
}
