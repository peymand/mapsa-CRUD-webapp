package com.mapsa.controllers;

import com.mapsa.model.Student;
import com.mapsa.service.StudentService;
import com.mapsa.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.SQLException;

@WebServlet("/student-register.do")
public class RegisterController extends HttpServlet {

  private StudentService studentService;

  public RegisterController() {
    studentService = new StudentServiceImpl();
  }


  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    String family = req.getParameter("family");
    String ageStr = req.getParameter("age");
    String operation = req.getParameter("operation");

    if (operation.equals("update")) {
      try {
        String id = req.getParameter("id");
        String sId = req.getParameter("sid");
        Student st = new Student(Integer.parseInt(id), Integer.parseInt(ageStr), name, family, sId);
        updateStudent(st);
        resp.sendRedirect("/list-page.do");
      } catch (SQLException throwables) {
        //if cant update student and get exception
      }
    } else {
      String sId = generateUniqueID();
      Student st = new Student(0, Integer.parseInt(ageStr), name, family, sId);
      registerNewStudent(st);
      resp.sendRedirect("/list-page.do");
    }
  }

  private boolean registerNewStudent(Student student) {
    try {
      studentService.save(student);
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

  private String generateUniqueID() {
    SecureRandom random = new SecureRandom();
    int i = random.nextInt(999999 - 100000) + 100000;
    return String.valueOf(i);
  }

  private boolean updateStudent(Student student) throws SQLException {
    studentService.updateStudent(student);
    return true;
  }

}
