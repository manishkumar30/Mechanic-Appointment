package com.mechanicapp.model;

import java.util.Date;

public class Appointment {
	
	private int appointmentid;
	private Date date;
	private String location;
	private String vehiclename;
	private String vehiclenumber;
	private String customername;
	private String servicetype;
	private String additionalinfo;
	private int customerid;
	
	
	public String getVehiclename() {
		return vehiclename;
	}
	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}
	public String getVehiclenumber() {
		return vehiclenumber;
	}
	public void setVehiclenumber(String vehiclenumber) {
		this.vehiclenumber = vehiclenumber;
	}
	public int getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	 
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getServicetype() {
		return servicetype;
	}
	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}
	public String getAdditionalinfo() {
		return additionalinfo;
	}
	public void setAdditionalinfo(String additionalinfo) {
		this.additionalinfo = additionalinfo;
	}
	public Appointment(int appointmentid, Date date, String location, String customername, String servicetype,
			String additionalinfo) {
		//super();
		this.appointmentid = appointmentid;
		this.date = date;
		this.location = location;
		this.customername = customername;
		this.servicetype = servicetype;
		this.additionalinfo = additionalinfo;
	}
	public Appointment(Date date, String location,  String customername, String servicetype,
			String additionalinfo) {
		//super();
		this.date = date;
		this.location = location;
		 
		this.customername = customername;
		this.servicetype = servicetype;
		this.additionalinfo = additionalinfo;
	}
	public Appointment() {
		//super();
	}
	
	
	public Appointment(int appointmentid) {
		//super();
		this.appointmentid = appointmentid;
	}
	public Appointment(int appointmentid, Date date, String location, String vehiclename, String vehiclenumber,
			String customername, String servicetype, String additionalinfo) {
		//super();
		this.appointmentid = appointmentid;
		this.date = date;
		this.location = location;
		this.vehiclename = vehiclename;
		this.vehiclenumber = vehiclenumber;
		this.customername = customername;
		this.servicetype = servicetype;
		this.additionalinfo = additionalinfo;
	}
	public Appointment(Date date, String location, String vehiclename, String vehiclenumber, String customername,
			String servicetype, String additionalinfo) {
		//super();
		this.date = date;
		this.location = location;
		this.vehiclename = vehiclename;
		this.vehiclenumber = vehiclenumber;
		this.customername = customername;
		this.servicetype = servicetype;
		this.additionalinfo = additionalinfo;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public Appointment(Date date, String location, String vehiclename, String vehiclenumber, String customername,
			String servicetype, String additionalinfo, int customerid) {
		super();
		this.date = date;
		this.location = location;
		this.vehiclename = vehiclename;
		this.vehiclenumber = vehiclenumber;
		this.customername = customername;
		this.servicetype = servicetype;
		this.additionalinfo = additionalinfo;
		this.customerid = customerid;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentid=" + appointmentid + ", date=" + date + ", location=" + location
				+ ", vehiclename=" + vehiclename + ", vehiclenumber=" + vehiclenumber + ", customername=" + customername
				+ ", servicetype=" + servicetype + ", additionalinfo=" + additionalinfo + ", customerid=" + customerid
				+ "]";
	}
	 
	
	 
	 

}
