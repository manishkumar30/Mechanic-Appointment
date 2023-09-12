package com.mechanicapp.dao.impl;

 
import java.sql.Connection;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mechanicapp.dao.ClientDao;
import com.mechanicapp.exception.AppointmentNotFoundException;
import com.mechanicapp.exception.ClientNotFoundException;
import com.mechanicapp.model.Appointment;
import com.mechanicapp.model.Client;
import com.mechanicapp.util.DbUtil;

public class ClientDaoImpl implements ClientDao {
	
		private final static String SELECT_ALL = "SELECT * FROM CUSTOMER";
		private final static String SELECT_ALL_APPOINMENT = "SELECT * FROM Appointment";
		
		private final static String SELECT_BY_ID = "SELECT * FROM CUSTOMER WHERE customerid=?";
		private final static String SELECT_BY_ID_APPOINTMENT = "SELECT * FROM Appointment WHERE customerid=?";
		
		private final static String INSERT = "insert into customer(firstName,lastName,address, emailid, mobileNo) values(?,?,?,?,?)";
		private final static String INSERT_APPOINTMENT = "insert into Appointment(date,location,vehiclename, vehiclenumber, customername, servicetype,additionalinfo,customerid) values(?,?,?,?,?,?,?,?)";
		
		private final static String UPDATE = "UPDATE CUSTOMER SET firstName=?, lastName=?, address=?, emailid=?, mobileNo=? WHERE customerid=?";
		private final static String UPDATE_APPOINTMENT = "UPDATE Appointment SET date=?, location=?,vehiclename=?,vehiclenumber=?, customername=?, servicetype=?, additionalinfo=? WHERE customerid=?";
		
		private final static String DELETE = "DELETE FROM CUSTOMER WHERE customerid = ? ";
		private final static String DELETE_APPOINTMENT = "DELETE FROM Appointment WHERE customerid = ? ";

		
		private Connection connection = DbUtil.getConnection();
		
	    @Override
	    public List<Client> displayAllClient() throws SQLException {
	    		        List<Client> clients = new ArrayList<>();
	        Statement stmt = connection.createStatement();  
	        ResultSet rs = stmt.executeQuery(SELECT_ALL);
	        
	        while (rs.next()) {
	            Client client = new Client();
 	            client.setcustomerid(rs.getInt("customerid"));
	            client.setFirstName(rs.getString("firstName"));
	            client.setLastName(rs.getString("lastName"));
	            client.setAddress(rs.getString("address"));
	            client.setEmailid(rs.getString("emailid"));
	            client.setMobileNo(rs.getLong("mobileNo"));  
	            clients.add(client);
	        }
	        rs.close();
	        stmt.close();
	        return clients;
	    }
	    

	    @Override
	    public Client findById(int clientId) throws ClientNotFoundException, SQLException {
	        Client client = null;
	        PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID);
	        stmt.setInt(1, clientId);
	        ResultSet rs = stmt.executeQuery();
	        System.out.println("Rs  : "  + rs);
	        if (rs.next()) {
	            client = new Client();
	            client.setcustomerid(rs.getInt("customerid"));
	            client.setFirstName(rs.getString("firstName"));
	            client.setLastName(rs.getString("lastName"));
	            client.setAddress(rs.getString("address"));
	            client.setEmailid(rs.getString("emailid"));
	            client.setMobileNo(rs.getLong("mobileNo")); // Use consistent case
	        } else {
	            throw new ClientNotFoundException("Client Not Found With Id: " + clientId);
	        }
	        rs.close();
	        stmt.close();
	        return client;
	    }
	    
		@Override
		public boolean update(Client client) throws SQLException {
			PreparedStatement stmt = connection.prepareStatement(UPDATE);
			
			stmt.setString(1,client.getFirstName() );
			stmt.setString(2,client.getLastName() );
			stmt.setString(3,client.getAddress() );
			stmt.setString(4, client.getEmailid());
			stmt.setLong(5, client.getMobileNo());
			stmt.setInt(6,client.getcustomerid() );
			
			int updated = stmt.executeUpdate();
			stmt.close();
			
			return updated > 0;	
			
	}
		//@Override
		public boolean delete(Client client) throws SQLException {
			PreparedStatement stmt = connection.prepareStatement(DELETE);
	        stmt.setInt(1, client.getcustomerid());
			
			int deleted = stmt.executeUpdate();
			
			stmt.close();
			return deleted > 0;

	}

		@Override
		public boolean insert (Client client) throws SQLException {
			boolean result=false;
			PreparedStatement stmt = connection.prepareStatement(INSERT);
			stmt.setString(1,client.getFirstName() );
			stmt.setString(2,client.getLastName() );
			stmt.setString(3,client.getAddress() );
			stmt.setString(4, client.getEmailid());
			stmt.setLong(5, client.getMobileNo());
			if(stmt.executeUpdate()>0) {
				result = true;
			}
			stmt.close();
			return result;
		}

		@Override
		public List<Appointment> displayAllAppointment() throws SQLException {
			List<Appointment> appointments = new ArrayList<>();
	        Statement stmt = connection.createStatement();  
	        ResultSet rs = stmt.executeQuery(SELECT_ALL_APPOINMENT);
	        
	        while (rs.next()) {
	            Appointment appointment = new Appointment();
	            appointment.setAppointmentid(rs.getInt("Appointmentid"));
	            appointment.setDate(rs.getDate("date"));
	            appointment.setLocation(rs.getString("location"));
	            appointment.setVehiclename(rs.getString("vehiclename"));
	            appointment.setVehiclenumber(rs.getString("vehiclenumber"));
	            appointment.setCustomername(rs.getString("customername"));
	            appointment.setServicetype(rs.getString("servicetype"));
	            appointment.setAdditionalinfo(rs.getString("additionalinfo")); 
	            appointment.setCustomerid(rs.getInt("customerid"));
	            appointments.add(appointment);
	        }
	        rs.close();
	        stmt.close();
	        return appointments;
			 
		}

		
		@Override
		public Appointment appointmentfindById(int appointmentId) throws AppointmentNotFoundException, SQLException {
			Appointment appointment = null;
	        PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID_APPOINTMENT);
	        stmt.setInt(1, appointmentId);
	        ResultSet rs = stmt.executeQuery();
	        System.out.println("Rs  : "  + rs);
	        if (rs.next()) {
	        	appointment = new Appointment();
	        	appointment.setAppointmentid(rs.getInt("appointmentid"));
	        	appointment.setDate(rs.getDate("date"));
	            appointment.setLocation(rs.getString("location"));
	            appointment.setVehiclename(rs.getString("vehiclename"));
	            appointment.setVehiclenumber(rs.getString("vehiclenumber"));
	            appointment.setCustomername(rs.getString("customername"));
	            appointment.setServicetype(rs.getString("servicetype")); 
	            appointment.setAdditionalinfo(rs.getString("additionalinfo"));
	            appointment.setCustomerid(rs.getInt("customerid"));
	        } else {
	            throw new AppointmentNotFoundException("Appointment Not Found With Id: " + appointmentId);
	        }
	        rs.close();
	        stmt.close();
	        return appointment;
			 
		}

		
		@Override
		public boolean insertappointment(Appointment appointment) throws SQLException {
			boolean result=false;
			PreparedStatement stmt = connection.prepareStatement(INSERT_APPOINTMENT);
			stmt.setDate(1, new java.sql.Date(appointment.getDate().getTime()));
			stmt.setString(2,appointment.getLocation() );
			stmt.setString(3,appointment.getVehiclename() );
			stmt.setString(4,appointment.getVehiclenumber() );
			stmt.setString(5,appointment.getCustomername());
			stmt.setString(6, appointment.getServicetype());
			stmt.setString(7, appointment.getAdditionalinfo());
			stmt.setInt(8,appointment.getCustomerid() );
			if(stmt.executeUpdate()>0) {
				result = true;
			}
			stmt.close();
			return result;
			 
		}

		@Override
		public boolean updateappointment(Appointment appointment) throws SQLException {
			PreparedStatement stmt = connection.prepareStatement(UPDATE_APPOINTMENT);
			stmt.setDate(1, new java.sql.Date(appointment.getDate().getTime()));
			stmt.setString(2,appointment.getLocation() );
			stmt.setString(3,appointment.getVehiclename() );
			stmt.setString(4,appointment.getVehiclenumber() );
			stmt.setString(5,appointment.getCustomername() );
			stmt.setString(6, appointment.getServicetype());
			stmt.setString(7, appointment.getAdditionalinfo());
			stmt.setInt(8,appointment.getCustomerid());			
			int updated = stmt.executeUpdate();
			stmt.close();
			
			return updated > 0;	
			 
		}

		
		@Override
		public boolean deleteappointment(Appointment appointment) throws SQLException {
			PreparedStatement stmt = connection.prepareStatement(DELETE_APPOINTMENT);
	        stmt.setInt(1, appointment.getAppointmentid());
			
			int deleted = stmt.executeUpdate();
			
			stmt.close();
			return deleted > 0;
			 
		}


		 

}
