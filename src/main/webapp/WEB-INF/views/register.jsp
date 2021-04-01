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
    <title>Register page</title>
    <link rel="stylesheet" href="/style/style.css">
</head>
<body class="body">
<h1>Student Home Page</h1>
<div class="heading">
    <a class="btn" href="/index.do"/>Home</a>
    <a class="btn" href="<c:url value='/list-page.do'/>">List of Students</a>
    <a class="btn" href="/register.do">Register a Student</a>
    <a class="btn" href="/search.do">Search</a>
</div>
<div class="container">
    <span class="register-form">
    <form action="/student-register.do" method="post">
        <input type="hidden" name="operation" value="${operation}">
        <input type="hidden" name="sid" value="${student[0].getSid()}">
        <input type="hidden" name="id" value="${student[0].getId()}">
        <table>
            <tr>
                <td><p class="register-form-cells">Name:</p></td>
                <td><input type="text" name="name"  value="${student[0].getName()}" class="register-form-cells" class="register-form-cells"/> <br/></td>
            </tr>

            <tr>
                <td><p class="register-form-cells">Family:</p></td>
                <td><input type="text" name="family" value="${student[0].getFamily()}" class="register-form-cells"/> <br/></td>
            </tr>
            <tr>
                <td><p class="register-form-cells">Age:</p></td>
                <td><input type="text" name="age" value="${student[0].getAge()}" class="register-form-cells"/> <br/></td>
            </tr>
            <tr>
                <td colspan="2" class="register-form-btn-holder"><input type="submit" value="Save" class="register-form-btn"/></td>
            </tr>
        </table>
    </form>
    </span>
</div>
</body>
</html>
