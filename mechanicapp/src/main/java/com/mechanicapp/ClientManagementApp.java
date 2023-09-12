package com.mechanicapp;

import java.util.Date;

import java.sql.SQLException;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
 
import java.util.List;
import java.util.Scanner;

import com.mechanicapp.dao.ClientDao;
import com.mechanicapp.dao.impl.ClientDaoImpl;
import com.mechanicapp.exception.AppointmentNotFoundException;
import com.mechanicapp.exception.ClientNotFoundException;
import com.mechanicapp.model.Appointment;
import com.mechanicapp.model.Client;

public class ClientManagementApp {
    
	private static ClientDao dao = new ClientDaoImpl();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws ParseException {
        
    	while (true) {
    		
            System.out.println("Enter Your choice : ");
            System.out.println("1 - Customers");
            System.out.println("2 - Mechanic");
            System.out.println("3 - Appointment");
            System.out.println("4 - Service");
            System.out.println("0 - Exit");
            System.out.println("-----------------------------------------");
            
            int ch = Integer.parseInt(scanner.nextLine());
            
            switch (ch) {
            
                case 1:
                    System.out.println("Enter CUSTOMER Choice :- ");
                    System.out.println("1 - Registration");
                    System.out.println("2 - Display Single Record");
                    System.out.println("3 - Delete Record");
                    System.out.println("4 - Modify");
                    System.out.println("5 - Display All");
                    System.out.println("0 - Exit");
                    System.out.println("-----------------------------------------");
                    
                    int CUI = Integer.parseInt(scanner.nextLine());
                    
                    switch (CUI) {
                    
                     
                    case 1:
                            System.out.println("-----Cutomer Registration Started------");
                            regClient();
                            System.out.println("------ Cutomer Registration Ended------");
                            break;
                      
                    case 2:
                            System.out.println("------ Display Single Record of Customer ------");
                            findById();
                            System.out.println("------ Display Single Record of cutomer ------");
                            break;
                    
                    case 3:
                            System.out.println("------ Delete Record of Customer ------");
                            delete();
                            System.out.println("----- Delete Record- of Customer -------");
                            break;
                        
                    case 4:
                        	System.out.println("------ Customer Details UPDATE Choice ------");
                            System.out.println("1 First Name");
                            System.out.println("2 Last Name");
                            System.out.println("3 Address");
                            System.out.println("4 Mobile No");
                            System.out.println("5 Email ID");
                            System.out.println("0 Exit");
                            System.out.println("-----------------------------------------");
                            int UC = Integer.parseInt(scanner.nextLine());
                            
                            switch (UC) {
                            
                            case 1:
                                    System.out.println("------ Update Customer First Name ------");
                                    updateFirstName();
                                    break;
                                
                            case 2:
                                    System.out.println("------ Update Customer Last Name ------");
                                    updateLastName();
                                    break;
                                
                            case 3:
                                    System.out.println("------ Update Customer Address ------");
                                    updateAddress();
                                    break;
                                
                            case 4:
                                    System.out.println("------ Update Cutomer Mobile Number ------");
                                    updateMobileNo();
                                    break;
                                
                            case 5:
                            	System.out.println("------ Update Customer Email ID -------");
                            	updateEmailId();
                            	break;
                                
                            case 0:
                            	break;
                            default:
                            	System.exit(0);
                        		}
                            	break;
                        
                    case 5:
                            System.out.println("------  Display All Details of Customer -------");
                            displayAllClient();
                            System.out.println("------  Display All Details of Customer -------");
                            break;
                        
                        
                    case 0:
                            System.exit(0);
                        default:
                            System.exit(0);
                    }
                    break;
                
              
                
                case 2:                 
                    System.out.println("------ APPOINTMENT Choice -------");
                    System.out.println("1 - Book An Appointment");
                    System.out.println("2 - Modify Appointment Details");
                    System.out.println("3 - Delete An Appointment");
                    System.out.println("4 - View Single Record");
                    System.out.println("5 - View All Record");
                    System.out.println("0 - Exit");
                    System.out.println("-----------------------------------------");
                    
                    int AUI = Integer.parseInt(scanner.nextLine());
                    
                    switch (AUI) {
                        
                        case 1:
                            System.out.println("------ Book An Appointment -------");
                            bookAppointment();
                            System.out.println("------ Book An Appointment ------");
                             break;
                        
                        case 2:
                            System.out.println("------- Modify Appointment Details -------");
                            System.out.println("------ UPDATE Choice ------");
                            System.out.println("1 - Modify Appointment Date");
                            System.out.println("2 - Modify Location");
                            System.out.println("3 - Modify Vehicle Name");
                            System.out.println("4 - Modify Vehicle Number");
                            System.out.println("5 - Modify Customer Name");
                            System.out.println("6 - Modify Service Type");
                            System.out.println("7 - Modify Additional Info");
                            System.out.println("0 - Exit");
                            System.out.println("-----------------------------------------");
                            
                            int UAC = Integer.parseInt(scanner.nextLine());
                            
                            switch(UAC) {
                            
                            case 1: 
                            	System.out.println("--------Modify Date--------");
                            	updateAppointmentDate();
                            	System.out.println("--------Modify Date---------");
                            	break;
                            
                            case 2: 
                            	System.out.println("--------Modify Location---------");
                            	updateLocation();
                            	System.out.println("--------Modify Location---------");
                            	break;
                            
                            case 3:
                            	System.out.println("--------Modify Vehicle Name---------");
                            	updateVehiclename();
                            	System.out.println("--------Modify Vehicle Name---------");
                            	break;
                            	
                            case 4:
                            	System.out.println("--------Modify Vehicle Number---------");
                            	updateVehiclenumber();
                            	System.out.println("--------Modify Vehicle Number---------");
                            	break;
                            
                            case 5:
                            	System.out.println("--------Modify Customer Name---------");
                            	updateCustomerName();
                            	System.out.println("--------Modify Customer Name---------");
                            	break;
                            	
                            case 6:
                            	System.out.println("--------Modify Service Type---------");
                            	updateServiceType();
                            	System.out.println("--------Modify Service Type---------");
                            	break;
                            	
                            case 7:
                            	System.out.println("--------Modify Additional Info---------");
                            	updateAdditionalInfo();
                            	System.out.println("--------Modify Additional Info---------");
                            	
                            	break;
                            case 0:
                                System.exit(0);
                                System.out.println("-----------------------------------------");
                            default:
                                System.exit(0);
                        }
                          
                             break;
                        
                        case 3:
                            System.out.println("------ Delete An Appointment -------");
                            deleteappointment();
                            System.out.println("------ Delete An Appointment ------");
                            break;
                        
                        case 4:
                            System.out.println("------ View Single Record -------");
                            appointmentfindById();
                            System.out.println("----- View Single Record ------");
                             break;
                        
                        case 5:
                            System.out.println("------ View All Record of Appointment ------");
                            displayAllAppointment();
                            System.out.println("------ View All Record of appointment ------");
                             break;
                        
                        
                        case 0:
                            System.exit(0);
                            System.out.println("-----------------------------------------");
                        default:
                            System.exit(0);
                    }
                    break;
                    
                case 3:
                	System.out.println("Still Pending");
                	break;
                    
                case 4:
                	System.out.println("Still Pending");
                	break;
                    
                 case 0:
                    System.exit(0);
                    System.out.println("-----------------------------------------");
                default:
                    System.exit(0);
            }
        }
    }

    private static void regClient() {
    	System.out.println("\n Enter Customer First Name :- ");
        String firstName = scanner.nextLine();
        System.out.println("\nEnter Customer Last Name :- ");
        String lastName = scanner.nextLine();
        System.out.println("\nEnter Customer Address :- ");
        String address = scanner.nextLine();
        System.out.println("\nEnter Customer Email Id :- ");
        String emailid = scanner.nextLine(); 
        System.out.println("\nEnter Customer Mobile Number :- ");
        long mobileno = Long.parseLong(scanner.nextLine());
        
        Client client = new Client(firstName, lastName, address, emailid, mobileno);
        
        try {
            if (dao.insert(client)) {
                System.out.println("------ Customer Registration Successfully --------");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static void findById() { 
    	System.out.println("\nEnter Customer Id :- ");
    	int clientId = Integer.parseInt(scanner.nextLine());
        
    	try {
            Client findById = dao.findById(clientId);
            System.out.println(findById);
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    private static void displayAllClient() {
    	try {
            List<Client> displayAllClient = dao.displayAllClient();
            for (Client client : displayAllClient) {
                System.out.println(client);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateFirstName() {
        System.out.println("\nEnter Customer Id :- ");
        int clientId = Integer.parseInt(scanner.nextLine());
        
        System.out.println("\nEnter New First Name :- ");
        String firstName = scanner.nextLine();

        try {
            Client client = dao.findById(clientId);
            client.setFirstName(firstName);
            
            if (dao.update(client)) {
                System.out.println("----- Customer First Name Update Successfully -------");
            }
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateLastName() {
        System.out.println("\nEnter Customer Id :- ");
        int clientId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Last Name :- ");
        String lastName = scanner.nextLine();

        try {
            Client client = dao.findById(clientId);
            client.setLastName(lastName);

            if (dao.update(client)) {
                System.out.println("------- Customer Last name Update Successfully -------");
            }
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateAddress() {
        System.out.println("\nEnter Customer Id :- ");
        int clientId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Address :- ");
        String address = scanner.nextLine();

        try {
            Client client = dao.findById(clientId);
            client.setAddress(address);

            if (dao.update(client)) {
                System.out.println("------- Customer Address Update Successfully -------");
            }
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateMobileNo() {
        System.out.println("\nEnter Customer Id :- ");
        int clientId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Mobile Number :- ");
        Long mobileNo = Long.parseLong(scanner.nextLine());

        try {
            Client client = dao.findById(clientId);
            client.setMobileNo(mobileNo);

            if (dao.update(client)) {
                System.out.println("------ Customer Mobilr number Update Successfully -------");
            }
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateEmailId() {
        System.out.println("\nEnter Customer Id :- ");
        int clientId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Email Id :- ");
        String emailid = scanner.nextLine();

        try {
            Client client = dao.findById(clientId);
            client.setEmailid(emailid);

            if (dao.update(client)) {
                System.out.println("------ Customer Email ID Update Successfully -------");
            }
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void delete() {
    	System.out.println("\nEnter Customer ID :- ");
        int id = Integer.parseInt(scanner.nextLine());
        Client client = new Client(id);
        
        try {
            if (dao.delete(client)) {
                System.out.println("------ Customer Deleted -------");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

    }
    
    
    public static void bookAppointment() throws ParseException {
    	
    	System.out.println("\nEnter Appointment Date :- ");
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
    	String strDate = scanner.nextLine();
    	Date date = sdf.parse(strDate);
        
    	System.out.println("\n Enter Location :- ");
        String location = scanner.nextLine();
        
        System.out.println("\nEnter Vehicle Name :- ");
        String vehiclename = scanner.nextLine();
        
        System.out.println("\nEnter Vehicle Number :- ");
        String vehiclenumber = scanner.nextLine();
        
        System.out.println("\nEnter Customer Name :- ");
        String customername = scanner.nextLine(); 
        
        System.out.println("\nEnter Service Type :- ");
        String servicetype = scanner.nextLine();
        
        System.out.println("\nEnter Additional Info :- ");
        String additionalinfo = scanner.nextLine();
        
        System.out.println("\nEnter Customer ID :- ");
        int customerid = Integer.parseInt(scanner.nextLine());
        
        Appointment appointment = new Appointment(date, location, vehiclename, vehiclenumber, customername, servicetype, additionalinfo, customerid);
        
        try {
            if (dao.insertappointment(appointment)) {
                System.out.println("------ Appointment Book Successfully ------");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void displayAllAppointment() {
    	try {
            List<Appointment> displayAllAppointment = dao.displayAllAppointment();
            for (Appointment appointment : displayAllAppointment) {
                System.out.println(appointment);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void appointmentfindById() { 
    	System.out.println("\nEnter Customer Id :- ");
    	int appointmentId = Integer.parseInt(scanner.nextLine());
        
    	try {
            Appointment appointmentfindById = dao.appointmentfindById(appointmentId);
            System.out.println(appointmentfindById);
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void deleteappointment() {
    	System.out.println("\nEnter Customer ID :- ");
        int id = Integer.parseInt(scanner.nextLine());
        Appointment appointment = new Appointment(id);
        
        try {
            if (dao.deleteappointment(appointment)) {
                System.out.println("------ Appoinment Deleted -------");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
   private static void updateAppointmentDate() throws ParseException {
        System.out.println("\nEnter Customer Id :- ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        
        System.out.println("\nEnter New Date :- ");
        
       SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd") ;
    	String strDate1 = scanner.nextLine();
    	Date date1 = sdf1.parse(strDate1);

        try {
         Appointment appointment = dao.appointmentfindById(appointmentId);
         appointment.setDate(date1);    
         
          if (dao.updateappointment(appointment)) {
          System.out.println("------ Appointment Date Update Successfully -------");
           }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
       }
   }
    
    private static void updateLocation() {
        System.out.println("\nEnter Customer Id :- ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Location :- ");
        String location = scanner.nextLine();

        try {
            Appointment appointment = dao.appointmentfindById(appointmentId);
            appointment.setLocation(location);

            if (dao.updateappointment(appointment)) {
                System.out.println("------ Appointment Location Update Successfully -------");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateVehiclename() {
        System.out.println("\nEnter Customer Id :- ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Vehicle Name :- ");
        String vehiclename = scanner.nextLine();

        try {
            Appointment appointment = dao.appointmentfindById(appointmentId);
            appointment.setLocation(vehiclename);

            if (dao.updateappointment(appointment)) {
                System.out.println("------ Vehical Name Update Successfully -------");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateVehiclenumber() {
        System.out.println("\nEnter Customer Id :- ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Vehicle Number:- ");
        String vehiclenumber = scanner.nextLine();

        try {
            Appointment appointment = dao.appointmentfindById(appointmentId);
            appointment.setLocation(vehiclenumber);

            if (dao.updateappointment(appointment)) {
                System.out.println("------ Vehical Number Update Successfully -------");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateCustomerName() {
        System.out.println("\nEnter Customer Id :- ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Cutomer Name :- ");
        String customername = scanner.nextLine();

        try {
        	Appointment appointment = dao.appointmentfindById(appointmentId);
        	appointment.setCustomername(customername);

            if (dao.updateappointment(appointment)) {
                System.out.println("------- Customer name Update Successfully -------");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateServiceType() {
        System.out.println("\nEnter Customer Id :- ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Service Type :- ");
        String servicetype = scanner.nextLine();

        try {
        	Appointment appointment = dao.appointmentfindById(appointmentId);
            appointment.setServicetype(servicetype);

            if (dao.updateappointment(appointment)) {
                System.out.println("------- Service Type Update Successfully -------");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateAdditionalInfo() {
        System.out.println("\nEnter Customer Id :- ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Additional Info :- ");
        String additionalinfo = scanner.nextLine();

        try {
        	Appointment appointment = dao.appointmentfindById(appointmentId);
        	appointment.setAdditionalinfo(additionalinfo);

            if (dao.updateappointment(appointment)) {
                System.out.println("------ Additinal information Update Successfully -----------");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

}



