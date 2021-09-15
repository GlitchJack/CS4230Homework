package edu.weber.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import edu.weber.model.Contact;
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
	
	MyServlet testObj;
	
	@Before
	public void setup() {
		testObj = new MyServlet();
	}
	
	@Test
	public void doGetHasRequestAttributeContacts() throws ServletException, IOException {
		ArgumentCaptor<Collection> servletRequestCapture = ArgumentCaptor.forClass(Collection.class);

		when(request.getRequestDispatcher(ArgumentMatchers.any(String.class))).thenReturn(requestDispatcher);
		when(request.getParameter("errormessage")).thenReturn("");
		
		testObj.doGet(request, response);

		verify(request,times(3)).setAttribute(ArgumentMatchers.any(String.class), servletRequestCapture.capture());
		
		Assert.assertNotNull(servletRequestCapture.getValue());
	}
	
	@Test
	public void doGetHasRequestAttributeContactsHasDefault() throws ServletException, IOException {
		ArgumentCaptor<HashMap<String,Contact>> servletRequestCapture = ArgumentCaptor.forClass(HashMap.class);

		when(request.getRequestDispatcher(ArgumentMatchers.any(String.class))).thenReturn(requestDispatcher);
		//when(request.getParameter("errormessage")).thenReturn("");
		
		testObj.doGet(request, response);

		verify(request,times(3)).setAttribute(ArgumentMatchers.any(String.class), servletRequestCapture.capture());

		HashMap<String,Contact> contactsCollection = servletRequestCapture.getValue();
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
	
}
