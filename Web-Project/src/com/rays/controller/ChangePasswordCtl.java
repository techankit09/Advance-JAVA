package com.rays.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/ChangePasswordCtl")
public class ChangePasswordCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.sendRedirect("ChangePassword.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	String login = request.getParameter("login");
	String oldPassword = 	request.getParameter("oldPassword");
	String newPassword = 	request.getParameter("newPassword");
	
	UserModel model = new UserModel();
	UserBean  bean  = new UserBean();
	
	try {
		model.changePassword(oldPassword, newPassword, login);
		request.setAttribute("successMsg", "password Changed Successfully");
	} catch (Exception e) {
		request.setAttribute("errorMsg", e.getMessage());
		e.printStackTrace();
	}
    RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.jsp");
    rd.forward(request, response);
	}
}
