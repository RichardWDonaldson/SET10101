package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {

	private Connection con;
	private String JDBC_DRIVER;
	private String DB_URL;
	private String USER;
	private String PASS;
	
	
	public Database() {
		JDBC_DRIVER = "com.mysql.jdbc.Driver";
		DB_URL = "jdbc:mysql://localhost:3306/Kwikmedical";
		USER = "Java";
		PASS = "Password";
		con = null;
		
		openConnection();
	}
	
	
	
	
	public void openConnection() {
		try{  
			Class.forName(JDBC_DRIVER);  
			System.out.println("Connecting to KwikMedical");
			con=DriverManager.getConnection(DB_URL, USER, PASS);  
			System.out.println("Successfully connected");
		
			
			} catch(Exception e){ 
				
				System.out.println(e);
			}  
		
			}

	
	public void closeConnection() {
		try {
			if(con!= null) {
			con.close();	
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Connection closed");
	}
	
	public Connection getConnection() {
		return con;
	}
	

	
	
	
}
