package com.taskflow.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.taskflow.dao.TaskDAO;
import com.taskflow.model.TaskModel;
import com.taskflow.model.UserModel;

@WebServlet("/TaskListController")
public class TaskListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        UserModel user = (UserModel) session.getAttribute("user");

        int userId = user.getId();

        TaskDAO dao = new TaskDAO();

        ArrayList<TaskModel> tasks = dao.getTasksByUserId(userId);

       
        request.setAttribute("tasks", tasks);

        
        request.getRequestDispatcher("taskList.jsp")
               .forward(request, response);
    }
}