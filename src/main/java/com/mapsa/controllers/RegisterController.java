package com.mapsa.controllers;

import com.mapsa.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.SecureRandom;

@WebServlet("/student-register.do")
public class RegisterController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String family = req.getParameter("family");
        String ageStr = req.getParameter("age");
        String studentId = generateUniqueID();
        Student st = new Student(Integer.parseInt(ageStr),name,family,studentId);


    }

    private String generateUniqueID() {
        SecureRandom random = new SecureRandom();
        int i =  random.nextInt(1_000_000);
        return String.valueOf(i);
    }
}
