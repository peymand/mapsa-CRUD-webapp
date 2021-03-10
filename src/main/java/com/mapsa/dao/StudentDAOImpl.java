package com.mapsa.dao;

import com.mapsa.model.Student;
import com.mapsa.service.StudentServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void save(Student student) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT into student (age,name,family,sid) values (?,?,?,?)");
        ps.setInt(1, student.getAge());
        ps.setString(2, student.getName());
        ps.setString(3, student.getFamily());
        ps.setString(4, student.getSid());
        ps.executeUpdate();
    }
}
