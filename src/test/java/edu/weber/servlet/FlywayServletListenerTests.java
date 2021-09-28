package edu.weber.servlet;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletException;

@RunWith(MockitoJUnitRunner.class)
public class FlywayServletListenerTests {

	@Mock
	ServletContextEvent sce;
	
	FlywayServletListener testListener;
	
	@Before
	public void setup() {
		testListener = new FlywayServletListener();
	}
	
	@Test
	public void contextInitializedTest()throws ServletException, IOException{
		testListener.contextInitialized(sce);
	}
}
