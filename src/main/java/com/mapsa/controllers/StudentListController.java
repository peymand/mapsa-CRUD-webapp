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

@WebServlet("/list-page.do")
public class StudentListController extends HttpServlet {

  private StudentService studentService;

  public StudentListController() {
    studentService = new StudentServiceImpl();
  }

      private String language;
      private String country;
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      if (req.getParameter("lang") != null && req.getParameter("lang").toLowerCase(Locale.ROOT).equals("fa")) {
        language = "fa";
        country = "IR";
      } else {
        language = "en";
        country = "US";
      }
      Locale locale = new Locale(language, country);
      req.setAttribute("messages", I18n.getStrings(locale));
      List<Student> all = studentService.getAll();
      req.setAttribute("arr", all);

      req.getRequestDispatcher("WEB-INF/views/list.jsp").
        forward(req, resp);

    } catch (SQLException e) {
      resp.sendRedirect("/error.do?code=101");
    }

  }
}
