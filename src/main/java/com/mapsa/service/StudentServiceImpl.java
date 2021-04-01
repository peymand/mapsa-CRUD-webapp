package com.mapsa.service;

import com.mapsa.dao.StudentDAO;
import com.mapsa.dao.StudentDAOImpl;
import com.mapsa.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDAO studentDAO;

    public StudentServiceImpl() {
        studentDAO = new StudentDAOImpl();
    }

    @Override
    public void save(Student student) throws SQLException {
        studentDAO.save(student);
    }

    @Override
    public List<Student> getAll() throws SQLException {
        return studentDAO.getAll();
    }

    @Override
    public void delete(int id) throws SQLException{
        studentDAO.delete(id);
    }

  @Override
  public List<Student> searchName(String name) throws SQLException {
    return studentDAO.searchName(name);
  }

  @Override
  public List<Student> searchFamily(String family) throws SQLException {
    return studentDAO.searchFamily(family);
  }

  @Override
  public List<Student> searchId(int id) throws SQLException {
    return studentDAO.searchId(id);
  }

  @Override
  public List<Student> searchSId(String SId) throws SQLException {
    return studentDAO.searchSId(SId);
  }

  @Override
  public List<Student> searchAge(int age) throws SQLException {
    return studentDAO.searchAge(age);
  }

  @Override
  public boolean updateStudent(Student student) throws SQLException {
    return studentDAO.updateStudent(student);
  }
}
