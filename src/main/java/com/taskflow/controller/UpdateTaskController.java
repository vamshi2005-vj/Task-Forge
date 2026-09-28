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

@WebServlet("/UpdateTaskController")
public class UpdateTaskController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        UserModel user = (UserModel) session.getAttribute("user");

        int id = Integer.parseInt(request.getParameter("id"));

        TaskDAO dao = new TaskDAO();

        TaskModel task = dao.getTaskById(id);

        if (task == null) {
            response.sendRedirect("TaskListController");
            return;
        }

        if (task.getUserId() != user.getId()) {
            response.sendRedirect("TaskListController");
            return;
        }

        request.setAttribute("task", task);

        request.getRequestDispatcher("editTask.jsp")
               .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        UserModel user = (UserModel) session.getAttribute("user");

        int id = Integer.parseInt(request.getParameter("id"));

        TaskDAO dao = new TaskDAO();

        TaskModel existingTask = dao.getTaskById(id);

        if (existingTask == null) {
            response.sendRedirect("TaskListController");
            return;
        }

        if (existingTask.getUserId() != user.getId()) {
            response.sendRedirect("TaskListController");
            return;
        }

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        TaskModel task = new TaskModel();

        task.setId(id);
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(status);
        task.setUserId(user.getId());

        boolean result = dao.updateTask(task);

        if (result) {
            response.sendRedirect("TaskListController");
        } else {
            response.sendRedirect("editTask.jsp?id=" + id);
        }
    }
}