package com.mapsa.dao;

import com.mapsa.model.Student;
import com.mapsa.service.StudentServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Student> getAll() throws SQLException {
        List<Student> students = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from student");
        while (resultSet.next()){
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setAge(resultSet.getInt("age"));
            student.setName(resultSet.getString("name"));
            student.setFamily(resultSet.getString("family"));
            student.setSid(resultSet.getString("sid"));
            students.add(student);
        }
        return students;

    }

    @Override
    public void delete(int id) throws SQLException{


        PreparedStatement ps = connection.prepareStatement("delete from student where id = ?");
        ps.setInt(1,id);
        ps.executeUpdate();

        throw new SQLException();

    }
}
