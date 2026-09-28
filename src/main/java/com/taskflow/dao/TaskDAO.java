package com.taskflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.taskflow.model.TaskModel;
import com.taskflow.utility.DBConnection;

public class TaskDAO {

    // Create Task
    public boolean createTask(TaskModel task) {

        boolean result = false;

        try {

            Connection con = new DBConnection().getConnection();

            String query = "INSERT INTO tasks(title, description, status, user_id) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getStatus());
            ps.setInt(4, task.getUserId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                result = true;
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // Get All Tasks
    public ArrayList<TaskModel> getAllTasks() {

        ArrayList<TaskModel> tasks = new ArrayList<>();

        try {

            Connection con = new DBConnection().getConnection();

            String query = "SELECT * FROM tasks";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                TaskModel task = new TaskModel();

                task.setId(rs.getInt("id"));
                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));
                task.setStatus(rs.getString("status"));
                task.setUserId(rs.getInt("user_id"));

                tasks.add(task);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tasks;
    }
    public ArrayList<TaskModel> getTasksByUserId(int userId) {

        ArrayList<TaskModel> tasks = new ArrayList<>();

        try {

            Connection con = new DBConnection().getConnection();

            String query = "SELECT * FROM tasks WHERE user_id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                TaskModel task = new TaskModel();

                task.setId(rs.getInt("id"));
                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));
                task.setStatus(rs.getString("status"));
                task.setUserId(rs.getInt("user_id"));

                tasks.add(task);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tasks;
    }

    // Get Task By ID
    public TaskModel getTaskById(int id) {

        TaskModel task = null;

        try {

            Connection con = new DBConnection().getConnection();

            String query = "SELECT * FROM tasks WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                task = new TaskModel();

                task.setId(rs.getInt("id"));
                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));
                task.setStatus(rs.getString("status"));
                task.setUserId(rs.getInt("user_id"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return task;
    }

    // Update Task
    public boolean updateTask(TaskModel task) {

        boolean result = false;

        try {

            Connection con = new DBConnection().getConnection();

            String query = "UPDATE tasks SET title = ?, description = ?, status = ? WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getStatus());
            ps.setInt(4, task.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                result = true;
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // Delete Task
    public boolean deleteTaskById(int id) {

        boolean result = false;

        try {

            Connection con = new DBConnection().getConnection();

            String query = "DELETE FROM tasks WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                result = true;
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}