package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


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
	
		
		openConnection();

	}
	
	
	
	
	public void openConnection() {
		try{  
			Class.forName(JDBC_DRIVER);  
			System.out.println("Connecting to KwikMedical");
			con=DriverManager.getConnection(DB_URL, USER, PASS);  
			System.out.println("Successfully connected");
		
			
			} catch(Exception e){ 
				JOptionPane.showMessageDialog(null, "Error connecting to Database - Please contact System Administrator", "Critical Error", 0);
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
		try {
		if(con.isClosed()) {
			openConnection();
		}
		
		
		}catch(NullPointerException ex) {
			ex.printStackTrace();
		} catch(SQLException ex2) {
			ex2.printStackTrace();
		}
		
		return con;
	}
	

	
	
	
}
