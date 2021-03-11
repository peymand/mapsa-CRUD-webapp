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

@WebServlet("/list-page.do")
public class StudentListController extends HttpServlet {

    private StudentService studentService;

    public StudentListController(){
        studentService = new StudentServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Student> all = studentService.getAll();
            req.setAttribute("arr",all);

            req.getRequestDispatcher("WEB-INF/views/list.jsp").
                    forward(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
