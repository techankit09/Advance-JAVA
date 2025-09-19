package com.rays.jdbc.preparedStatement;

import java.text.SimpleDateFormat;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		testAdd();	
	}
 public static  void testAdd() throws Exception{
	 
	 SimpleDateFormat sdf = new SimpleDateFormat("dd-yyyy-mm");
	 
	 UserModel Model  = new UserModel();
	 
	 UserBean Bean = new UserBean();
	 
	 Bean.setFirstName("Danny");
     Bean.setLastName("D");
     Bean.setLogin("danny0123");
	 Bean.setPassword("123456789");
	 Bean.setDob(sdf.parse("13-12-2001"));
	 
	 Model.add(Bean);
 }
}