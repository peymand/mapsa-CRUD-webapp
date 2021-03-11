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

@WebServlet("/delete.do")
public class StudentDeleteController extends HttpServlet {

    private StudentService studentService;

    public StudentDeleteController(){
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id =  req.getParameter("id");
        try {
            studentService.delete(Integer.parseInt(id));
            resp.sendRedirect("/list-page.do");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
