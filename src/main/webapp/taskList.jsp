<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.taskflow.model.TaskModel" %>

<%
    ArrayList<TaskModel> tasks =
        (ArrayList<TaskModel>) request.getAttribute("tasks");
%>

<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>

<div class="container py-5">

    <div class="d-flex justify-content-between align-items-center mb-4">

        <div>
            <h2>My Tasks</h2>
            <p class="text-muted">
                View and manage your tasks
            </p>
        </div>

        <a href="createTask.jsp" class="btn btn-primary">
            + Create Task
        </a>

    </div>

    <% if (tasks == null || tasks.isEmpty()) { %>

        <div class="card shadow border-0">
            <div class="card-body text-center p-5">

                <h4>No Tasks Found</h4>

                <p class="text-muted">
                    You haven't created any tasks yet.
                </p>

                <a href="createTask.jsp"
                   class="btn btn-primary">
                    Create Your First Task
                </a>

            </div>
        </div>

    <% } else { %>

        <div class="row">

            <% for (TaskModel task : tasks) { %>

                <div class="col-md-6 col-lg-4 mb-4">

                    <div class="card shadow border-0 h-100">

                        <div class="card-body">

                            <h5 class="card-title">
                                <%= task.getTitle() %>
                            </h5>

                            <p class="card-text text-muted">
                                <%= task.getDescription() %>
                            </p>

                            <span class="badge bg-primary">
                                <%= task.getStatus() %>
                            </span>

                        </div>

                        <div class="card-footer bg-white border-0">

                           <a href="UpdateTaskController?id=<%= task.getId() %>"
                                 class="btn btn-sm btn-warning">
                                   Edit
                             </a>

                           <a href="DeleteTaskController?id=<%= task.getId() %>"
                             class="btn btn-sm btn-danger"
                             onclick="return confirm('Are you sure you want to delete this task?');">
                              Delete
                                 </a>

                        </div>

                    </div>

                </div>

            <% } %>

        </div>

    <% } %>

</div>

<%@ include file="footer.jsp" %>