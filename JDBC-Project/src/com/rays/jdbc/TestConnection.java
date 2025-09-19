package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	  // 1. class Loader
	  
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  
	  // 2. Make Connection to the Database
	  
	 Connection  c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
	 
	  // 3. Create Statement
	 
	 Statement stmt = c.createStatement();
	 
	  // 4. Execute Query and get ResultSet
	 
	 ResultSet rs = stmt.executeQuery("select * from employee");
	 
	 while(rs.next()) {
		 
		 System.out.print(rs.getInt(1));
		 System.out.print("\t" + rs.getString(2));
		 System.out.print("\t" +rs.getString(3));
		 System.out.println("\t" +rs.getInt(4));
		  
	 }
   }
 }
