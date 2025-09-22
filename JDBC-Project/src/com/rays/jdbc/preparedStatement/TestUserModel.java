package com.rays.preparedStatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		//testAdd();
		//TestDelete();
		//TestUpdate();
		//testbylogin();
		//testbyAuthenticate();
		//testbyid();
		testsearch();
	}

	public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-yyyy-mm");

		UserModel Model = new UserModel();

		UserBean Bean = new UserBean();

		Bean.setFirstName("Danny");
		Bean.setLastName("D");
		Bean.setLogin("danny@123gmail.com");
		Bean.setPassword("123456789");
		Bean.setDob(sdf.parse("13-12-2001"));

		Model.add(Bean);
	}

	public static void TestDelete() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setId(1);
		model.delete(bean);
	}
	
	public static void TestUpdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		
		bean.setId(2);
		bean.setFirstName("DANNY");
		bean.setLastName("D");
		bean.setLogin("danny@123gmail.com");
		bean.setPassword("123456789");
		bean.setDob(sdf.parse("12-2003-12"));
		
		model.update(bean);
	}
	public static void testbylogin() throws Exception {
	
		UserModel model = new UserModel();
	
		UserBean existsbean = model.findbylogin("danny@gmail.com");
		
		if(existsbean != null) {
			System.out.println("login id already exist");
		}else {
			System.out.println("login not found");
		}
	}
	public static void  testbyAuthenticate() throws Exception {
		
		UserModel model = new UserModel();
		
		UserBean existsbean =  model.Authenticate("lucky009@gmail.com","Lucky123");
		
		if(existsbean != null) {
			System.out.println("Login sucessfull");
		}else {
			System.out.println("login Failed");
		}
	  }
	
	public static void testChangepassword() throws Exception {
		
		UserModel model = new UserModel();
		
		model.Changepassword("123456789", "987654321"," ankitrawat123@gmail.com");
		
	}
	
	public static void testbyid() throws Exception {
		
		UserModel model = new UserModel();
		
		UserBean bean = model.findbyId(2);
		
		if(bean != null) {
			System.out.println("login id found");
		}else {
			System.out.println("login id not found");
	}
	}

 public static void testsearch() throws Exception {
	 
	    UserModel model = new UserModel();
	     List list = model.search(null);
	     
	     Iterator<UserBean> it = list.iterator();
	     
	     while(it.hasNext()) {
	    	 
	    UserBean bean = it.next();
	    System.out.print(bean.getId());
		System.out.println("\t"+bean.getFirstName());
		System.out.println("\t"+bean.getLastName());
		System.out.println("\t"+bean.getLogin());
		System.out.println("\t"+bean.getPassword());
		System.out.println("\t"+bean.getDob());
	}
	     }
     }

	
	