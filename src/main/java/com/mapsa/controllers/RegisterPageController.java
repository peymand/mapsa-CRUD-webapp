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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/register.do")
public class RegisterPageController extends HttpServlet {
  private final StudentService studentService;

  public RegisterPageController() {
    studentService = new StudentServiceImpl();
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String operation = req.getParameter("operation");
    String id = req.getParameter("id");
    if (operation!=null &&operation.equals("update")) {
      req.setAttribute("operation", "update");
      try {
        List<Student> students = studentService.searchId(Integer.parseInt(id));
        req.setAttribute("student", students);
        req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }else
    req.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(req, resp);

  }
}
