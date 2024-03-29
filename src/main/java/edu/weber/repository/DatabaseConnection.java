package edu.weber.repository;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DatabaseConnection {
	
	private static final String MYSQL_URL_KEY = "MYSQL_URL";
	private static final String MYSQL_USER_KEY = "MYSQL_USER";
	private static final String MYSQL_PASSWORD_KEY = "MYSQL_PASSWORD";
	private static final String MYSQL_DATABASE_KEY = "MYSQL_DATABASE";
	
	private static DataSource dataSource;
	
	private DatabaseConnection() {}
	
	public static DataSource getDataSource() {
		if(dataSource == null) {
			MysqlDataSource source = new MysqlDataSource();
			source.setDatabaseName(System.getenv(MYSQL_DATABASE_KEY));
			//System.out.println(System.getenv(MYSQL_DATABASE_KEY));
			source.setUrl(getMySQLUrl());
			//System.out.println(getMySQLUrl());
			source.setUser(System.getenv(MYSQL_USER_KEY));
			//System.out.println(System.getenv(MYSQL_USER_KEY));
			source.setPassword(System.getenv(MYSQL_PASSWORD_KEY));
			//System.out.println(System.getenv(MYSQL_PASSWORD_KEY));
			dataSource = source;
			try {
				dataSource.getConnection().isValid(5);
			} catch(SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Error connecting to database");
			}
		}
		return dataSource;
	}
	
	private static String getMySQLUrl() {
		//set the environment variables or else url is null
		String url = System.getenv(MYSQL_URL_KEY);
		String schema = System.getenv(MYSQL_DATABASE_KEY);
		try {
			if(url.startsWith("jdbc:mysql")) {
				return url;
			}else {
				return String.format("%s%s/%s", "jdbc:mysql://", url, schema);
			}
		}catch(NullPointerException e) {
			return "/";
		}
	}
}
