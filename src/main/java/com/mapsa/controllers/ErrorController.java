package com.mapsa.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error.do")
public class ErrorController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorCode = req.getParameter("code");
        String msg = "could not delete your record!!!";
        req.setAttribute("errorMsg",msg);
        req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req,resp);
    }
}
