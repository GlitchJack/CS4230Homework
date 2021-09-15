package edu.weber.model;

import java.io.Serializable;

public class Contact implements Serializable {
	
	//contacts which capture first & last names, phone numbers, addresses, address types
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String homeAddress;
	private String businessAddress;
	
	public Contact() {
		this.setFirstName(null);
		this.setLastName(null);
		this.setPhoneNum(null);
		this.setHomeAddress(null);
		this.setBusinessAddress(null);
	}
	
	public Contact(String fname, String lname) {
		this.setFirstName(fname);
		this.setLastName(lname);
		this.setPhoneNum(null);
		this.setHomeAddress(null);
		this.setBusinessAddress(null);
	}
	
	public Contact(String fname, String lname, String num) {
		this.setFirstName(fname);
		this.setLastName(lname);
		this.setPhoneNum(num);
		this.setHomeAddress(null);
		this.setBusinessAddress(null);
	}
	
	public Contact(String fname, String lname, String num, String homeaddr, String busiaddr) {
		this.setFirstName(fname);
		this.setLastName(lname);
		this.setPhoneNum(num);
		this.setHomeAddress(homeaddr);
		this.setBusinessAddress(busiaddr);
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}
	
	
}
