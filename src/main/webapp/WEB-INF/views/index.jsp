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
    <link rel="stylesheet" href="/style/style.css">
    <title>Home Page</title>
</head>
<body class="body">
<h1>Student Home Page</h1>
<div class="heading">
    <a class="btn" href="<c:url value="/list-page.do"/>">List of Students</a>
    <a class="btn" href="/register.do">Register a Student</a>
    <a class="btn" href="">Search</a>
</div>
</body>
</html>
