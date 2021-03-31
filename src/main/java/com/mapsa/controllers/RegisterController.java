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

    public RegisterController(){
        studentService = new StudentServiceImpl();
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String family = req.getParameter("family");
        String ageStr = req.getParameter("age");
        String studentId = generateUniqueID();
        Student st = new Student(0,Integer.parseInt(ageStr),name,family,studentId);
        try {
            studentService.save(st);
        } catch (SQLException e) {

        }
            resp.sendRedirect("/index.do");
    }

    private String generateUniqueID() {
        SecureRandom random = new SecureRandom();
        int i =  random.nextInt(999999 - 100000) + 100000;
        return String.valueOf(i);
    }
}
