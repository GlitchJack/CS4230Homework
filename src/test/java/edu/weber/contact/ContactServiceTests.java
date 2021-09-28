package edu.weber.contact;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import edu.weber.model.Contact;
import edu.weber.repository.ContactRepository;
import edu.weber.repository.DatabaseConnection;
import jakarta.servlet.ServletException;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTests {
	
	@Mock
	ContactRepository repo;
	
	@Mock
	DatabaseConnection conn;
	
	ContactService testObj;
	List<Contact> testList;
	Contact testContact;
	
	@Before
	public void setup() {
		testObj = new ContactService(repo);
		testList = Arrays.asList(new Contact[] {new Contact("Jack","Nancarrow")});
		testContact = new Contact("Jack", "Nancarrow");
	}
	
	@Test
	public void getContactsCallsGetAllContacts() throws ServletException, IOException {
		//when(ContactService.getInstance()).thenReturn(testObj);
		try {
			when(repo.getAllContacts()).thenReturn(testList);
		}catch(SQLException e) {
			//do something? I assume I will get a sqlexception
			Assert.fail();
		}
		Assert.assertTrue(testObj.getContacts().size() > 0);
	}
	
	@Test
	public void addContactCallsInsertContact() throws ServletException, IOException {
		ArgumentCaptor<Collection<Contact>> contactCapture = ArgumentCaptor.forClass(Collection.class);
		
		testObj.addContact(testContact);
		
		verify(repo).insertContact(testContact);
		
		
	}
}
