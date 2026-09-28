package com.taskflow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.taskflow.model.UserModel;
import com.taskflow.utility.DBConnection;

public class UserDAO {

    // Register User
    public boolean registerUser(UserModel user) {

        boolean result = false;

        try {

            Connection con = new DBConnection().getConnection();

            String query = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

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

    // Login User
    public UserModel loginUser(String email, String password) {

        UserModel user = null;

        try {

            Connection con = new DBConnection().getConnection();

            String query = "SELECT * FROM users WHERE email = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                user = new UserModel();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}