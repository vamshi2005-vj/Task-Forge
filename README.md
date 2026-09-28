# TaskFlow – Enterprise Task Management System

TaskFlow is a Java-based web application designed to help users create and manage their tasks efficiently.

The application provides user authentication and allows each logged-in user to create, view, update, and delete their own tasks.

## Features

- User Registration
- User Login and Logout
- Session Management
- Create Tasks
- View User-Specific Tasks
- Update Tasks
- Delete Tasks
- Task Status Management
- MySQL Database Integration
- Responsive User Interface

## Technologies Used

- Java
- JSP
- Servlets
- JDBC
- MySQL
- HTML
- CSS
- Bootstrap
- Apache Tomcat 10.1
- Eclipse IDE

## Project Architecture

The application follows a layered/MVC-style architecture.

```text
User
 |
 v
JSP
 |
 v
Servlet / Controller
 |
 v
Model / POJO
 |
 v
DAO
 |
 v
JDBC
 |
 v
MySQL
## Project Structure

```text
TaskFlow
|
├── src/main/java
|   └── com.taskflow
|       ├── controller
|       ├── dao
|       ├── model
|       └── utility
|
└── src/main/webapp
    ├── header.jsp
    ├── navbar.jsp
    ├── footer.jsp
    ├── index.jsp
    ├── register.jsp
    ├── login.jsp
    ├── taskHome.jsp
    ├── createTask.jsp
    ├── taskList.jsp
    ├── editTask.jsp
    └── style.css
users
-------------------------
id
name
email
password
tasks
-------------------------
id
title
description
status
user_id

## Application Flow
Registration
     |
     v
Login
     |
     v
Session Creation
     |
     v
Task Dashboard
     |
     +----> Create Task
     |
     +----> View Tasks
     |          |
     |          +----> Edit Task
     |          |
     |          +----> Delete Task
     |
     v
Logout

## Author

**Prashanth Lingampally**

## Project Status

**Completed**
