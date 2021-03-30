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
<html>
<head>
    <title>List of Students</title>
    <link rel="stylesheet" href="/style/style.css">
    <style>
      td, th {
        font-family: sans-serif;
        font-size: large;
      }
    </style>
</head>
<body class="body">
    <h1>Student Home Page</h1>
<div class="heading">
    <a class="btn" href="<c:url value="/list-page.do"/>">List of Students</a>
    <a class="btn" href="/register.do">Register a Student</a>
    <a class="btn" href="">Search</a>
</div>
<div class="container">
    <table class="tbl-student-list">
        <thead class="tbl-student-list-head">
        <tr style="border: 1px solid ; padding: 1px">
            <th class="tbl-student-list-cls">ID</th>
            <th class="tbl-student-list-cls">Name</th>
            <th class="tbl-student-list-cls">Family</th>
            <th class="tbl-student-list-cls">Age</th>
            <th class="tbl-student-list-cls">SID</th>
            <th class="tbl-student-list-cls">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${arr}" var="student">

            <tr class="tbl-student-list-rows" style="border: 1px solid ; padding: 1px">
                <td class="tbl-student-list-cls">${student.id}</td>
                <td class="tbl-student-list-cls">${student.name}</td>
                <td class="tbl-student-list-cls">${student.family}</td>
                <td class="tbl-student-list-cls">${student.age}</td>
                <td class="tbl-student-list-cls">${student.sid}</td>
                <td class="tbl-student-list-cls"><a class="btn tbl-student-list-btn" href="">Edit</a>
                    <a class="btn tbl-student-list-btn" href="/delete.do?id=${student.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
