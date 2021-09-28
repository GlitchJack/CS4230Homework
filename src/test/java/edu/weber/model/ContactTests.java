package edu.weber.model;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import jakarta.servlet.ServletException;

@RunWith(MockitoJUnitRunner.class)
public class ContactTests {
	//I have resorted to testing getters and setters muahahaha
	
	Contact testCont;
	
	@Before
	public void setup() {
		testCont = new Contact("Jack", "Nancarrow", "666-666-6666", "Nunya St.", "Business Ave.");
	}
	
	@Test
	public void getMethodsGetValues() throws ServletException, IOException{
		Assert.assertTrue(testCont.getBusinessAddress() != null);
		Assert.assertTrue(testCont.getHomeAddress() != null);
		Assert.assertTrue(testCont.getLastName() != null);
		Assert.assertTrue(testCont.getPhoneNum() != null);
	}
	
}
