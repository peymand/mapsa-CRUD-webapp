package com.mapsa.controllers;

import com.mapsa.model.Student;
import com.mapsa.service.StudentService;
import com.mapsa.service.StudentServiceImpl;
import com.mapsa.utils.I18n;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

@WebServlet("/register.do")
public class RegisterPageController extends HttpServlet {
  private final StudentService studentService;

  public RegisterPageController() {
    studentService = new StudentServiceImpl();
  }

    private String language;
    private String country;
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String operation = req.getParameter("operation");
    String id = req.getParameter("id");
    if (req.getParameter("lang") != null && req.getParameter("lang").toLowerCase(Locale.ROOT).equals("fa")) {
      language = "fa";
      country = "IR";
    } else {
      language = "en";
      country = "US";
    }
    Locale locale = new Locale(language, country);
    req.setAttribute("messages", I18n.getStrings(locale));



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
