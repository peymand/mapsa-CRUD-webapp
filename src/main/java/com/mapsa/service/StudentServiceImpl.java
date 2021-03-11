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
}
