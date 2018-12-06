package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
	
	public boolean openConnection() {
		try{  
			Class.forName(JDBC_DRIVER);  
			System.out.println("Connecting to KwikMedical");
			con=DriverManager.getConnection(DB_URL, USER, PASS);  
			System.out.println("Successfully connected");
			return true;
			
			} catch(SQLException e){ 
				JOptionPane.showMessageDialog(null, "Error connecting to Database - Please contact System Administrator", "Critical Error", 0);
				System.out.println(e);
				return false;
			}  catch(NullPointerException ex) {
				
				ex.printStackTrace();
				return false;
			} catch(ClassNotFoundException ex2) {
				ex2.printStackTrace();
				return false;
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
//		try {
////		if(con.isClosed()) {
////		Boolean success = openConnection();
////		if(!success) {
////			JOptionPane.showMessageDialog(null, "Error connecting to Database - Please contact System Administrator", "Critical Error", 0);
////		}
//		
//		}
//		
//		
//		}catch(NullPointerException ex) {
//			ex.printStackTrace();
//		} catch(SQLException ex2) {
//			ex2.printStackTrace();
//		}
		
		return con;
	}
	

	
	
	
}
