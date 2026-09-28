<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.taskflow.model.TaskModel" %>

<%
    TaskModel task = (TaskModel) request.getAttribute("task");

    if (task == null) {
        response.sendRedirect("TaskListController");
        return;
    }
%>

<%@ include file="header.jsp" %>
<%@ include file="navbar.jsp" %>

<div class="container py-5">

    <div class="row justify-content-center">

        <div class="col-md-7 col-lg-6">

            <div class="card shadow border-0">

                <div class="card-body p-4">

                    <h2 class="text-center mb-2">
                        Edit Task
                    </h2>

                    <p class="text-center text-muted mb-4">
                        Update your task details
                    </p>

                    <form action="UpdateTaskController" method="post">

                        <!-- Task ID -->
                        <input type="hidden"
                               name="id"
                               value="<%= task.getId() %>">

                        <!-- Title -->
                        <div class="mb-3">

                            <label for="title" class="form-label">
                                Task Title
                            </label>

                            <input type="text"
                                   class="form-control"
                                   id="title"
                                   name="title"
                                   value="<%= task.getTitle() %>"
                                   required>

                        </div>

                        <!-- Description -->
                        <div class="mb-3">

                            <label for="description" class="form-label">
                                Description
                            </label>

                            <textarea class="form-control"
                                      id="description"
                                      name="description"
                                      rows="5"
                                      required><%= task.getDescription() %></textarea>

                        </div>

                        <!-- Status -->
                        <div class="mb-4">

                            <label for="status" class="form-label">
                                Status
                            </label>

                            <select class="form-select"
                                    id="status"
                                    name="status">

                                <option value="PENDING"
                                    <%= "PENDING".equals(task.getStatus()) ? "selected" : "" %>>
                                    Pending
                                </option>

                                <option value="IN_PROGRESS"
                                    <%= "IN_PROGRESS".equals(task.getStatus()) ? "selected" : "" %>>
                                    In Progress
                                </option>

                                <option value="COMPLETED"
                                    <%= "COMPLETED".equals(task.getStatus()) ? "selected" : "" %>>
                                    Completed
                                </option>

                            </select>

                        </div>

                        <!-- Buttons -->
                        <div class="d-flex justify-content-between">

                            <a href="TaskListController"
                               class="btn btn-secondary">
                                Cancel
                            </a>

                            <button type="submit"
                                    class="btn btn-primary">
                                Update Task
                            </button>

                        </div>

                    </form>

                </div>

            </div>

        </div>

    </div>

</div>

<%@ include file="footer.jsp" %>