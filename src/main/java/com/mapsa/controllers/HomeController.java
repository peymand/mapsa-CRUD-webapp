package com.mapsa.controllers;


import com.mapsa.utils.I18n;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet("/index.do")
public class HomeController extends HttpServlet {
  private String language;
  private String country;

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getParameter("lang") != null && req.getParameter("lang").toLowerCase(Locale.ROOT).equals("fa")) {
      language = "fa";
      country = "IR";
    } else {
      language = "en";
      country = "US";
    }
    Locale locale = new Locale(language, country);
    req.setAttribute("messages", I18n.getStrings(locale));
    req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
  }

}
