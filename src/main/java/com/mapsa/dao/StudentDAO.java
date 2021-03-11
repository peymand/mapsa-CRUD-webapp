package com.mapsa.dao;

import com.mapsa.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {

    void save(Student student) throws SQLException;

    List<Student> getAll() throws SQLException;

    void delete(int id) throws SQLException;
}
