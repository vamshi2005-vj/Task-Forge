package com.taskflow.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.taskflow.dao.UserDAO;
import com.taskflow.model.UserModel;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();

        UserModel user = dao.loginUser(email, password);

        if (user != null) {

            HttpSession session = request.getSession();

            session.setAttribute("user", user);

           
            response.sendRedirect("taskHome.jsp");

        } else {

          
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}