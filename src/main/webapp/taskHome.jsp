<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.taskflow.model.UserModel" %>

<%
    UserModel user = (UserModel) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>

<div class="container py-5">

    <div class="text-center mb-5">
        <h1>Welcome to TaskFlow</h1>

        <p class="text-muted">
            Hello, <strong><%= user.getName() %></strong> 👋
        </p>

        <p class="text-muted">
            Manage your tasks efficiently from one place.
        </p>
    </div>

    <div class="row justify-content-center">

        <!-- Create Task -->
        <div class="col-md-4 mb-4">
            <div class="card shadow border-0 h-100">
                <div class="card-body text-center p-4">

                    <h4>Create Task</h4>

                    <p class="text-muted">
                        Create a new task and manage your work.
                    </p>

                    <a href="createTask.jsp"
                       class="btn btn-primary">
                        Create Task
                    </a>

                </div>
            </div>
        </div>

        <!-- View Tasks -->
        <div class="col-md-4 mb-4">
            <div class="card shadow border-0 h-100">
                <div class="card-body text-center p-4">

                    <h4>My Tasks</h4>

                    <p class="text-muted">
                        View, update and delete your tasks.
                    </p>

                    <a href="TaskListController"
                       class="btn btn-success">
                        View Tasks
                    </a>

                </div>
            </div>
        </div>

    </div>

</div>

<%@ include file="footer.jsp" %>