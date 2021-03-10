package com.mapsa.service;

import com.mapsa.dao.StudentDAO;
import com.mapsa.dao.StudentDAOImpl;
import com.mapsa.model.Student;

import java.sql.SQLException;

public class StudentServiceImpl implements StudentService {

    StudentDAO studentDAO;

    public StudentServiceImpl(){
        studentDAO = new StudentDAOImpl();
    }

    @Override
    public void save(Student student) throws SQLException {
        studentDAO.save(student);
    }
}
