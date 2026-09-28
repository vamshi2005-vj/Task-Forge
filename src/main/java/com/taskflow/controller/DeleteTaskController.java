package com.taskflow.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.taskflow.dao.TaskDAO;

@WebServlet("/DeleteTaskController")
public class DeleteTaskController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        TaskDAO dao = new TaskDAO();

        boolean result = dao.deleteTaskById(id);

        if (result) {
            response.sendRedirect("TaskListController");
        } else {
            response.sendRedirect("TaskListController");
        }
    }
}