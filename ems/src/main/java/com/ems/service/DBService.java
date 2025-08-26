package com.ems.service;

import java.sql.ResultSet;

public interface DBService {
	
	public void connectDB();//->Connecting to database
	public boolean verifyLogin(String email, String password);

	
	public ResultSet getUserByEmail(String email);
	public void createRegistration(String name, String course, String emailId, String mobile, int userId);

	public ResultSet getRegistrationsByUser(int userId);

	public void deleteRegistration(String email);
	
	public ResultSet getRegistrationById(int id);

	
	public void updateRegistration(int id, String name, String course, String email, String mobile);


}


