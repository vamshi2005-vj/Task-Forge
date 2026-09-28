package com.taskflow.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.taskflow.dao.TaskDAO;
import com.taskflow.model.TaskModel;
import com.taskflow.model.UserModel;

@WebServlet("/Task2Controller")
public class Task2Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        UserModel user = (UserModel) session.getAttribute("user");

        TaskModel task = new TaskModel();

        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(status);
        task.setUserId(user.getId());

        TaskDAO dao = new TaskDAO();

        boolean result = dao.createTask(task);

        if (result) {
            response.sendRedirect("taskHome.jsp");
        } else {
            response.sendRedirect("createTask.jsp");
        }
    }
}