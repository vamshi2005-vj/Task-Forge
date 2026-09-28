<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>

<%@ include file="navbar.jsp" %>


<div class="container py-5">

    <div class="row justify-content-center">

        <div class="col-md-6 col-lg-5">

            <div class="card shadow border-0">

                <div class="card-body p-4">

                    <h2 class="text-center mb-4">
                        Create Account
                    </h2>

                    <p class="text-center text-muted mb-4">
                        Join TaskFlow and manage your tasks efficiently.
                    </p>


                    <form action="RegisterController" method="post">

                        <!-- Name -->
                        <div class="mb-3">

                            <label for="name" class="form-label">
                                Full Name
                            </label>

                            <input type="text"
                                   class="form-control"
                                   id="name"
                                   name="name"
                                   placeholder="Enter your name"
                                   required>

                        </div>


                        <!-- Email -->
                        <div class="mb-3">

                            <label for="email" class="form-label">
                                Email Address
                            </label>

                            <input type="email"
                                   class="form-control"
                                   id="email"
                                   name="email"
                                   placeholder="Enter your email"
                                   required>

                        </div>


                        <!-- Password -->
                        <div class="mb-4">

                            <label for="password" class="form-label">
                                Password
                            </label>

                            <input type="password"
                                   class="form-control"
                                   id="password"
                                   name="password"
                                   placeholder="Create a password"
                                   required>

                        </div>
                        <!-- Confirm Password -->
<div class="mb-4">

    <label for="confirmPassword" class="form-label">
        Confirm Password
    </label>

    <input type="password"
           class="form-control"
           id="confirmPassword"
           name="confirmPassword"
           placeholder="Confirm your password"
           required>

</div>


                        <!-- Register Button -->
                        <div class="d-grid">

                            <button type="submit"
                                    class="btn btn-primary">
                                Create Account
                            </button>

                        </div>

                    </form>


                    <div class="text-center mt-4">

                        <span class="text-muted">
                            Already have an account?
                        </span>

                        <a href="login.jsp">
                            Login
                        </a>

                    </div>

                </div>

            </div>

        </div>

    </div>

</div>


<%@ include file="footer.jsp" %>