package com.taskflow.controller;

import java.io.IOException;

import com.taskflow.dao.UserDAO;
import com.taskflow.model.UserModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!password.equals(confirmPassword)) {
		    response.sendRedirect("register.jsp?error=password");
		    return;
		}

		UserModel user = new UserModel();

		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);

		UserDAO dao = new UserDAO();

		boolean result = dao.registerUser(user);

		if (result) {
		    response.sendRedirect("login.jsp");
		} else {
		    response.sendRedirect("register.jsp");
		}
	}
}