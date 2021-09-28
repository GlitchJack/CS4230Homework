package edu.weber.repository;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import jakarta.servlet.ServletException;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseConnectionTests {

	@Mock
	DataSource source;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void getDataSourceCanGetDataSource() throws ServletException, IOException{
		try {
			DatabaseConnection.getDataSource();
		}catch(RuntimeException e) {
			//Assert.assertTrue(true);
		}
	}
}
