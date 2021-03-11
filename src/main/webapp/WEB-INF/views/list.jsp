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
    <style>
        td,th{
            font-family: sans-serif;
            font-size: large;
        }
    </style>
</head>
<body>
    <table border="1px solid grey">
        <thead>
            <tr style="border: 1px solid ; padding: 1px">
                <th>ID</th>
                <th>Name</th>
                <th>Family</th>
                <th>Age</th>
                <th>SID</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${arr}" var="student">

                <tr style="border: 1px solid ; padding: 1px">
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.family}</td>
                    <td>${student.age}</td>
                    <td>${student.sid}</td>
                    <td><a href="">Edit</a> , <a href="/delete.do?id=${student.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
