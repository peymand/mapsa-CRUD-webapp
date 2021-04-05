package com.mapsa.controllers;

import com.mapsa.model.Student;
import com.mapsa.service.StudentServiceImpl;
import com.mapsa.utils.I18n;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet("/search-result.do")
public class SearchStudent extends HttpServlet {
  private StudentServiceImpl studentService;
  private String language;
  private String country;
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userInput = req.getParameter("userInput");
    String searchType = req.getParameter("searchType");
    studentService = new StudentServiceImpl();

    if (req.getParameter("lang") != null && req.getParameter("lang").toLowerCase(Locale.ROOT).equals("fa")) {
      language = "fa";
      country = "IR";
    } else {
      language = "en";
      country = "US";
    }
    Locale locale = new Locale(language, country);
    req.setAttribute("messages", I18n.getStrings(locale));




    try {
      List<Student> students = search(userInput,searchType);
      req.setAttribute("arr", students);
      req.getRequestDispatcher("/WEB-INF/views/list.jsp").include(req, resp);
    } catch (SQLException throwables) {
      //
    }
  }
  private List<Student> search(String userInput,String searchType)throws SQLException{
    List<Student> students=new ArrayList<>();
    switch (searchType){
      case"Name":{
        students= studentService.searchName(userInput);
        break;}
      case "Family":{
        students= studentService.searchFamily(userInput);
        break;}
      case "Id":{
        students= studentService.searchId(Integer.parseInt(userInput));
        break;}
      case "sid":{
        students= studentService.searchSId(userInput);
        break;}
      case "Age":{
        students= studentService.searchAge(Integer.parseInt(userInput));
        break;}
    }
      return students;
  }
}