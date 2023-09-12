package com.mechanicapp.model;

public class Client {
	
	private int customerid;
	private String firstName;
	private String lastName;
	private String address;
	private String emailid;
	private long mobileNo;
	
	
	 	public int getcustomerid() {
		return customerid;
	}
	public void setcustomerid(int customerid) {
		this.customerid = customerid;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Client(int customerid, String firstName, String lastName, String address, String emailid, long mobileNo) {
		//super();
		this.customerid = customerid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailid = emailid;
		this.mobileNo = mobileNo;
	}
	public Client(String firstName, String lastName, String address, String emailid, long mobileNo) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailid = emailid;
		this.mobileNo = mobileNo;
	}
	public Client() {
		//super();
	}
	
	
	public Client(int customerid) {
		//super();
		this.customerid = customerid;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", emailid=" + emailid + ", mobileNo=" + mobileNo + "]";
	}
	
	 
	 
	
	
	
}
