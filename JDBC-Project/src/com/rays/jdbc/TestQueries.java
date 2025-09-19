package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestQueries{
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	Connection c =	DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
	
	Statement st = c.createStatement();
	
	int i = st.executeUpdate("Delete from employee where id = 16");
	
	System.out.println("Data deleted successfully"+ i);
			
	c.close();
	}
}

