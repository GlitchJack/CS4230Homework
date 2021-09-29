package edu.weber.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import edu.weber.contact.ContactService;
import edu.weber.model.Contact;
import edu.weber.repository.ContactRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MyServletTests {
	
	@Mock
	RequestDispatcher requestDispatcher;
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	ContactService service;
	
	@Mock
	ContactRepository repo;
	
	MyServlet testObj;
	List<Contact> testList;
	
	@Before
	public void setup() {
		testObj = new MyServlet(service);
		testList = Arrays.asList(new Contact[] {new Contact("Jack","Nancarrow"),new Contact("Test","Person","555-555-5555")});
	}
	
	@Test
	public void doGetHasRequestAttributeContacts() throws ServletException, IOException {
		ArgumentCaptor<Collection> servletRequestCapture = ArgumentCaptor.forClass(Collection.class);

		when(request.getRequestDispatcher(ArgumentMatchers.any(String.class))).thenReturn(requestDispatcher);
		when(request.getParameter("errormessage")).thenReturn("");
		
		testObj.doGet(request, response);

		verify(request,times(2)).setAttribute(ArgumentMatchers.any(String.class), servletRequestCapture.capture());
		
		Assert.assertNotNull(servletRequestCapture.getValue());
	}
	
	@Test
	public void doGetHasRequestAttributeContactsHasDefault() throws ServletException, IOException {
		ArgumentCaptor<Collection<Contact>> servletRequestCapture = ArgumentCaptor.forClass(Collection.class);

		when(request.getRequestDispatcher(ArgumentMatchers.any(String.class))).thenReturn(requestDispatcher);
		when(service.getContacts()).thenReturn(testList);
		//when(request.getParameter("errormessage")).thenReturn("");
		
		testObj.doGet(request, response);

		verify(request,times(2)).setAttribute(ArgumentMatchers.any(String.class), servletRequestCapture.capture());

		Collection<Contact> contactsCollection = servletRequestCapture.getValue();
		//How to do this with no database
		//Make the contactrepository stuff return a hardcoded list of contacts rather than database
		
		Assert.assertTrue(contactsCollection.size() > 0);

	}
	
	@Test
	public void doPostParameters() throws ServletException, IOException{
		ArgumentCaptor<String> servletRequestCapture = ArgumentCaptor.forClass(String.class);
		
		//when(request.getRequestDispatcher(ArgumentMatchers.any(String.class))).thenReturn(requestDispatcher);
		when(request.getParameter("homeaddr")).thenReturn("home");
		when(request.getParameter("busiaddr")).thenReturn("business");
		
		testObj.doPost(request, response);

		verify(request, times(6)).getParameter(servletRequestCapture.capture());
		
		Assert.assertNotNull(servletRequestCapture.getValue());
	}
	
	@Test
	public void myServletConstructorCanGetRepoInstance() throws ServletException, IOException{
		Assert.assertNotNull(new MyServlet(service));
	}
	
	@Test
	public void noAddressAfterPost() throws ServletException, IOException{
		when(request.getParameter("homeaddr")).thenReturn("");
		when(request.getParameter("busiaddr")).thenReturn("");
		testObj.doPost(request, response);
		verify(response).sendRedirect(ArgumentMatchers.any(String.class));
	}
	
}
