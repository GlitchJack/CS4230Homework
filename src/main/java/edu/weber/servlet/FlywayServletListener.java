package edu.weber.servlet;

import org.flywaydb.core.Flyway;
import edu.weber.repository.DatabaseConnection;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class FlywayServletListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Flyway flyway = null;
		try {
			flyway = Flyway.configure().dataSource(DatabaseConnection.getDataSource()).load();
		}catch(RuntimeException e) {
			
		}
		System.out.println("Starting FlyWay Migration");
		try {
			flyway.migrate();
		}catch(NullPointerException e) {
			
		}
		System.out.println("Finished FlyWay Migration");

	}
}
