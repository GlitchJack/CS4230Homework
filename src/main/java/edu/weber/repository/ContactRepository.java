package edu.weber.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


import edu.weber.model.Contact;

public class ContactRepository {
	
	private static ContactRepository contactRepo;
	
	private DataSource dataSource;
	private Connection db;
	
	private ContactRepository() {
		this.dataSource = DatabaseConnection.getDataSource();
		try {
			this.db = this.dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ContactRepository getInstance() {
		if(contactRepo == null) {
			contactRepo = new ContactRepository();
		}
		return contactRepo;
	}
	
	public List<Contact> getAllContacts() throws SQLException{
		PreparedStatement contactStatement = db.prepareStatement(CONTACT_GET.toString());
		ResultSet rs = contactStatement.executeQuery();
		List<Contact> response = new ArrayList<Contact>();
		while(rs.next()) {
			Contact currentContact = new Contact();
			currentContact.setFirstName(rs.getString("FIRST_NAME"));
			currentContact.setLastName(rs.getString("LAST_NAME"));
			currentContact.setPhoneNum(rs.getString("PHONE_NUMBER"));
			currentContact.setHomeAddress(rs.getString("HOME_ADDR"));
			currentContact.setBusinessAddress(rs.getString("BUSI_ADDR"));
			response.add(currentContact);
		}
		return response;
	}
	
	private static final String CONTACT_GET = "SELECT * FROM contact";
	
	public void insertContact(Contact c) {
		
		try {
			PreparedStatement insertStatement = null;
			try {
				insertStatement = db.prepareStatement(CONTACT_INSERT.toString(), Statement.RETURN_GENERATED_KEYS);
			}catch(NullPointerException e) {
				
			}
			
			insertStatement.setString(1, c.getFirstName());
			insertStatement.setString(2, c.getLastName());
			insertStatement.setString(3, c.getPhoneNum());
			insertStatement.setString(4, c.getHomeAddress());
			insertStatement.setString(5, c.getBusinessAddress());
			int rowAffected = insertStatement.executeUpdate();
			if(rowAffected == 1)
			{
				return;
			}else {
				System.out.println("Row not inserted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static final String CONTACT_INSERT = "INSERT INTO " 
			+ "contact(FIRST_NAME,LAST_NAME,PHONE_NUMBER,HOME_ADDR,BUSI_ADDR) "
			+ "VALUES (?,?,?,?,?)";
}
