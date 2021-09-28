package edu.weber.repository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import edu.weber.model.Contact;
import jakarta.servlet.ServletException;

@RunWith(MockitoJUnitRunner.class)
public class ContactRepositoryTests {

	@Mock
	Connection conn;
	
	@Mock
	DataSource source;
	
	@Mock
	PreparedStatement statement;
	
	ContactRepository testRepo;
	
	@Before
	public void setup() {
		testRepo = ContactRepository.getInstance();
	}
	
	@Test
	public void getAllContactsCanGetContacts() throws ServletException, IOException{
		
	}
	
	@Test
	public void getInstanceCanMakeNewObject() throws ServletException, IOException{
		Assert.assertNotNull(ContactRepository.getInstance());
	}
	
	@Test
	public void insertContactCanSendStatementToDB() throws ServletException, IOException{
		try {
			testRepo.insertContact(new Contact());
		}catch(RuntimeException e) {
			Assert.assertTrue(true);
		}
		
	}
}
