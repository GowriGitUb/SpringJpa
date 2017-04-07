/**
 * 
 */
package com.org.soft.email;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author samy
 *
 */
public class JdbcConnection {

	//Database Driver and Url
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/mailcommunication";
	
	//Database credentials
	static final String USERNAME = "root";
	static final String PASSWORD ="root"; 
	
	public Connection getConnection (){
		Connection connection = null;
		try {
			//Register Db Connection
			Class.forName(JDBC_DRIVER);
			
			//Open a connection
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
		
}
