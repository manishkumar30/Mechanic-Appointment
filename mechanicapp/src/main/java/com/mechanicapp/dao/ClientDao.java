package com.mechanicapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.mechanicapp.exception.AppointmentNotFoundException;
import com.mechanicapp.exception.ClientNotFoundException;
import com.mechanicapp.model.Appointment;
import com.mechanicapp.model.Client;

public interface ClientDao {
	
	List<Client> displayAllClient () throws SQLException;
	Client findById(int clientId) throws ClientNotFoundException, SQLException; 
	boolean insert(Client client) throws SQLException;
	boolean update(Client client) throws SQLException;
	boolean delete(Client client) throws SQLException;
	
	List<Appointment> displayAllAppointment() throws SQLException;
	Appointment appointmentfindById(int appointmentId) throws AppointmentNotFoundException, SQLException;
	boolean insertappointment(Appointment appointment) throws SQLException;
	boolean updateappointment(Appointment appointment) throws SQLException;
	boolean deleteappointment(Appointment appointment) throws SQLException;

	

}
