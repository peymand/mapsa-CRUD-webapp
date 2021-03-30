package com.mapsa.dao;

import com.mapsa.model.Student;
import com.mapsa.service.StudentServiceImpl;
import com.sun.istack.internal.NotNull;
import lombok.NonNull;

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
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1988");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  @Override
  public void save(Student student) throws SQLException {
    PreparedStatement ps = connection.prepareStatement("INSERT into student (sid,name,family,age) values (?,?,?,?)");
    ps.setString(1, student.getSid());
    ps.setString(2, student.getName());
    ps.setString(3, student.getFamily());
    ps.setInt(4, student.getAge());
    ps.executeUpdate();
  }

  @Override
  public List<Student> getAll() throws SQLException {
    List<Student> students = new ArrayList<>();

    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * from student");
    while (resultSet.next()) {
      Student student = new Student();
      student.setId(resultSet.getInt("id"));
      student.setSid(resultSet.getString("sid"));
      student.setName(resultSet.getString("name"));
      student.setFamily(resultSet.getString("family"));
      student.setAge(resultSet.getInt("age"));
      students.add(student);
    }
    return students;

  }

  @Override
  public void delete(int id) throws SQLException {
    PreparedStatement ps = connection.prepareStatement("delete from student where id = ?");
    ps.setInt(1, id);
    ps.executeUpdate();
  }

  @Override
  public List<Student> searchName(String name) throws SQLException {
    PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM student WHERE name=?");
    preparedStatement.setString(1, name);
    ResultSet resultSet = preparedStatement.executeQuery();
    List<Student> students=new ArrayList<>();
    while (resultSet.next()) {
     Student student =new Student();
     student.setId(resultSet.getInt("id"));
     student.setSid(resultSet.getString("sid"));
     student.setName(resultSet.getString("name"));
     student.setFamily(resultSet.getString("family"));
     student.setAge(resultSet.getInt("age"));
     students.add(student);
    }
    return students;
  }

  @Override
  public List<Student> searchFamily(String family) throws SQLException {
    PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM student WHERE family=?");
    preparedStatement.setString(1, family);
    ResultSet resultSet = preparedStatement.executeQuery();
    List<Student> students=new ArrayList<>();
    while (resultSet.next()) {
      Student student =new Student();
      student.setId(resultSet.getInt("id"));
      student.setSid(resultSet.getString("sid"));
      student.setName(resultSet.getString("name"));
      student.setFamily(resultSet.getString("family"));
      student.setAge(resultSet.getInt("age"));
      students.add(student);
    }
    return students;
  }

  @Override
  public List<Student> searchId(int id) throws SQLException {
    PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM student WHERE id=?");
    preparedStatement.setInt(1, id);
    ResultSet resultSet = preparedStatement.executeQuery();
    List<Student> students=new ArrayList<>();
    while (resultSet.next()) {
      Student student =new Student();
      student.setId(resultSet.getInt("id"));
      student.setSid(resultSet.getString("sid"));
      student.setName(resultSet.getString("name"));
      student.setFamily(resultSet.getString("family"));
      student.setAge(resultSet.getInt("age"));
      students.add(student);
    }
    return students;
  }

  @Override
  public List<Student> searchSId(String SId) throws SQLException {
    PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM student WHERE sid=?");
    preparedStatement.setString(1, SId);
    ResultSet resultSet = preparedStatement.executeQuery();
    List<Student> students=new ArrayList<>();
    while (resultSet.next()) {
      Student student =new Student();
      student.setId(resultSet.getInt("id"));
      student.setSid(resultSet.getString("sid"));
      student.setName(resultSet.getString("name"));
      student.setFamily(resultSet.getString("family"));
      student.setAge(resultSet.getInt("age"));
      students.add(student);
    }
    return students;
  }

  @Override
  public List<Student> searchAge(int age) throws SQLException {
    PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM student WHERE age=?");
    preparedStatement.setInt(1, age);
    ResultSet resultSet = preparedStatement.executeQuery();
    List<Student> students=new ArrayList<>();
    while (resultSet.next()) {
      Student student =new Student();
      student.setId(resultSet.getInt("id"));
      student.setSid(resultSet.getString("sid"));
      student.setName(resultSet.getString("name"));
      student.setFamily(resultSet.getString("family"));
      student.setAge(resultSet.getInt("age"));
      students.add(student);
    }
    return students;
  }
}
