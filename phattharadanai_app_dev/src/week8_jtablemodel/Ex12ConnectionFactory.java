package week8_jtablemodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Ex12ConnectionFactory {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		// "oracle.jdbc.driver.OracleDriver"
		String driverName = "org.mariadb.jdbc.Driver";
		// "jdbc:oracle:thin:@10.30.2.50:1521:prog2"
		String connectionURL = "jdbc:mariadb://localhost:3306/test";
		String username = "Chatra";
		String password = "";	

		System.out.println("-------- MariaDB JDBC Connection Testing ------");

		try {

			Class.forName(driverName);

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your MariaDB JDBC Driver?");
			e.printStackTrace();
		}

		Connection connection = null;
		System.out.println("MariaDB JDBC Driver Registered!");

		try {

			connection = DriverManager.getConnection(connectionURL, username, password);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		System.out.println("Connected to database");
		return connection;
	}
}
