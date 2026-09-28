<%
    com.taskflow.model.UserModel loggedInUser =
        (com.taskflow.model.UserModel) session.getAttribute("user");
%>

<nav class="navbar navbar-expand-lg main-navbar">
    <div class="container">

        <a class="navbar-brand" href="index.jsp">
            PRASHANTH | TASKFLOW
        </a>

        <div class="ms-auto d-flex align-items-center">

            <% if (loggedInUser == null) { %>

                <!-- Before Login -->
                <a class="nav-link me-3" href="login.jsp">
                    Login
                </a>

                <a class="nav-link" href="register.jsp">
                    Register
                </a>

            <% } else { %>

                <!-- After Login -->
                <a class="nav-link me-3" href="taskHome.jsp">
                    Dashboard
                </a>

                <a class="nav-link me-3" href="createTask.jsp">
                    Create Task
                </a>

                <a class="nav-link" href="LogoutController">
                    Logout
                </a>

            <% } %>

        </div>

    </div>
</nav>