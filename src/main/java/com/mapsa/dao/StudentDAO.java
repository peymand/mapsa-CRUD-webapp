package com.mapsa.dao;

import com.mapsa.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {

  void save(Student student) throws SQLException;

  List<Student> getAll() throws SQLException;

  void delete(int id) throws SQLException;

  List<Student> searchName(String name) throws SQLException;
  List<Student> searchFamily(String family) throws SQLException;
  List<Student> searchId(int id) throws SQLException;
  List<Student> searchSId(String SId) throws SQLException;
  List<Student> searchAge(int age) throws SQLException;
  boolean updateStudent(Student student) throws SQLException;
}
