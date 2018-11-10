package controller;

import java.sql.*;
public class Database {

	
	
	
	
	public Connection getConnection() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Kwikmedical","Java","Password");  
			
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from patientRecords");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();
			return con;
			}catch(Exception e){ System.out.println(e);}  
		
		return null;
	}
	
	public static void main(String args[]) {
	
	}
	
	
	
}
