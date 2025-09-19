package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		Statement s = c.createStatement();

		int i = s.executeUpdate("Insert into employee values(16,'Danny','DELL',686887,5)");

		System.out.println("data inserted successfully: " + i);

		c.close();

	}

}
