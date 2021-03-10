package com.mapsa.dao;

import com.mapsa.model.Student;

import java.sql.SQLException;

public interface StudentDAO {

    void save(Student student) throws SQLException;
}
