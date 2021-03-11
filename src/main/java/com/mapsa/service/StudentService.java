package com.mapsa.service;

import com.mapsa.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    void save(Student student) throws SQLException;
    List<Student> getAll() throws SQLException;

    void delete(int id) throws SQLException;
}
