package com.rays.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

		UserBean existsbean = findbylogin(bean.getLogin());

		if (existsbean != null) {
			throw new Exception("Login id already exist");
		}

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = c.prepareStatement("Insert into st_user values(?,?,?,?,?,?)");

		int pk = nextPk();
		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getLogin());
		pstmt.setString(5, bean.getPassword());
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));

		int i = pstmt.executeUpdate();
		System.out.println("Data Inserted Successfully" + i);
		c.close();
	}
	// delete records//

	public void delete(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = c.prepareStatement("delete from st_user where id = ?");

		pstmt.setInt(1, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Data delete sucessfully:" + i);
		c.close();
	}
	// update record//

	public void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = c.prepareStatement(
				"update st_user set firstname = ?,lastname = ?, login = ?, password = ?,dob = ? where id =?");

		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLogin());
		pstmt.setString(4, bean.getPassword());
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setInt(6, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("Data Updated Sucessfully:" + i);
		c.close();

	}
	// findbyLogin//

	public UserBean findbylogin(String login) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = c.prepareStatement("select * from st_user where login = ?");

		pstmt.setString(1, login);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setLogin(rs.getString(4));
		}
		return bean;
	}

	// authentication by login password//

	public UserBean Authenticate(String login, String password) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		PreparedStatement pstmt = c.prepareStatement("select * from st_user where login = ? and password = ?");

		pstmt.setString(1, login);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;
		while (rs.next()) {

			bean = new UserBean();
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
		}
		return bean;
	}
	// forget password//

	public void Changepassword(String oldpassword, String Newpassword, String login) throws Exception {

		UserBean bean = findbylogin(login);

		if (bean.getPassword().equals(oldpassword)) {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			PreparedStatement pstmt = c.prepareStatement("update st_user set password = ? where id = ?");

			pstmt.setString(1, Newpassword);
			pstmt.setString(2, login);

			int i = pstmt.executeUpdate();
			System.out.println("Password changed sucessfully" + i);
			c.close();

		} else {
			throw new Exception("password changed failed");
		}
	}

	public UserBean findbyId(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		PreparedStatement pstmt = c.prepareStatement("select * from st_user where id = ?");

		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
		}
		c.close();
		return bean;
	}

	public List search(UserBean bean) throws Exception {

		List list = new ArrayList();
		StringBuffer sql = new StringBuffer("select * from st_user where 1 = 1");

		if (bean != null) {
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + bean.getFirstName() + "%'");
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" and lastName like '" + bean.getLastName() + "%'");
			}
			if (bean.getLogin() != null && bean.getLogin().length() > 0) {
				sql.append(" and login like '" + bean.getLogin() + "%'");
			}
			if (bean.getPassword() != null && bean.getPassword().length()>0) {
				sql.append(" and password like '" + bean.getPassword()+ "%'");
			}
		    if (bean.getDob() != null && bean.getDob().getTime()>0){
		    	sql.append(" and dob like '" + new java.sql.Date(bean.getDob().getTime())+"%'");
				
			}
		}

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		System.out.println(sql.toString());

		PreparedStatement pstmt = c.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLogin(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(rs.getDate(6));
			list.add(bean);
		}

		return list;
	}
	}
