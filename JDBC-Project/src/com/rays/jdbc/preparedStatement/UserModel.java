package com.rays.jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserModel {

	public int nextPk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
			
		}

		conn.close();

		return pk + 1;

	}
	public void add(UserBean bean) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	Connection c = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
	
   PreparedStatement pstmt = c.prepareStatement("Insert into st_user values(?,?,?,?,?,?)");
   
   int pk = nextPk();
   pstmt.setInt(1 , pk);
   pstmt.setString(2, bean.getFirstName());
   pstmt.setString(3, bean.getLastName());
   pstmt.setString(4, bean.getLogin());
   pstmt.setString(5, bean.getPassword());
   pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
   
   int i = pstmt.executeUpdate();
   System.out.println("Data Inserted Successfully" + i);
   c.close();	
	}
}