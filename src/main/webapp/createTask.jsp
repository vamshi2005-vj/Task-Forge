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

    <div class="row justify-content-center">

        <div class="col-md-7 col-lg-6">

            <div class="card shadow border-0">

                <div class="card-body p-4">

                    <h2 class="text-center mb-2">
                        Create New Task
                    </h2>

                    <p class="text-center text-muted mb-4">
                        Add a new task to your TaskFlow dashboard.
                    </p>

                    <form action="Task2Controller" method="post">

                        <!-- Task Title -->
                        <div class="mb-3">
                            <label for="title" class="form-label">
                                Task Title
                            </label>

                            <input type="text"
                                   class="form-control"
                                   id="title"
                                   name="title"
                                   placeholder="Enter task title"
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
                                      placeholder="Enter task description"
                                      required></textarea>
                        </div>

                        <!-- Status -->
                        <div class="mb-4">
                            <label for="status" class="form-label">
                                Status
                            </label>

                            <select class="form-select"
                                    id="status"
                                    name="status">

                                <option value="PENDING">
                                    Pending
                                </option>

                                <option value="IN_PROGRESS">
                                    In Progress
                                </option>

                                <option value="COMPLETED">
                                    Completed
                                </option>

                            </select>
                        </div>

                        <!-- Buttons -->
                        <div class="d-flex justify-content-between">

                            <a href="taskHome.jsp"
                               class="btn btn-secondary">
                                Back
                            </a>

                            <button type="submit"
                                    class="btn btn-primary">
                                Create Task
                            </button>

                        </div>

                    </form>

                </div>

            </div>

        </div>

    </div>

</div>

<%@ include file="footer.jsp" %>