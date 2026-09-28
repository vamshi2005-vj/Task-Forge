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
                        Welcome Back
                    </h2>

                    <p class="text-center text-muted mb-4">
                        Login to your TaskFlow account
                    </p>


                    <!-- Login Form -->

                    <form action="LoginController" method="post">

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
                                   placeholder="Enter your password"
                                   required>

                        </div>


                        <!-- Login Button -->

                        <div class="d-grid">

                            <button type="submit"
                                    class="btn btn-primary">
                                Login
                            </button>

                        </div>

                    </form>


                    <!-- Register Link -->

                    <div class="text-center mt-4">

                        <span class="text-muted">
                            Don't have an account?
                        </span>

                        <a href="register.jsp">
                            Create Account
                        </a>

                    </div>

                </div>

            </div>

        </div>

    </div>

</div>


<%@ include file="footer.jsp" %>