<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mapsa.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: peyma
  Date: 3/11/2021
  Time: 8:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home Page</title>
    <style>
        a {
            font-weight: bold;

        }
    </style>
</head>
<body>
    <h1>Student Home Page</h1> <br/>

    <a href="<c:url value="/list-page.do"/>">List of Students</a> <br/>
    <a href="/register.do">Register a Student</a> <br/>
    <a href="">Search</a> <br/>
</body>
</html>
