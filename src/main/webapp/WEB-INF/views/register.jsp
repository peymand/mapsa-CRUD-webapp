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
    <meta charset="utf-8">
    <title>Register page</title>
    <link rel="stylesheet" href="/style/style.css">
    <style>
      html {
        direction: ${messages.get("css_direction")};
      }
    </style>
</head>
<body class="body">
<div class="header">
    <h1 class="title">${messages.get("register_page_title")}</h1>
    <form action="<c:url value="/register.do"/>" method="get"><select name="lang">
        <option>EN</option>
        <option>FA</option>
    </select>
        <input type="submit" value="ok"></form>
</div>
<div class="menu">
    <a class="btn" href="<c:url value="/index.do"/>${messages.get("url_suffix")}">${messages.get("menu_home_btn")}</a>
    <a class="btn" href="<c:url value="/list-page.do"/>${messages.get("url_suffix")}">${messages.get("menu_studentlist_btn")}</a>
    <a class="btn" href="<c:url value="/register.do"/>${messages.get("url_suffix")}">${messages.get("menu_register_student_btn")}</a>
    <a class="btn" href="<c:url value="/search.do"/>${messages.get("url_suffix")}">${messages.get("menu_search_btn")}</a>
</div>
<div class="container">
    <span class="register-form">
    <form action="/student-register.do" method="post">
        <input type="hidden" name="operation" value="${operation}">
        <input type="hidden" name="sid" value="${student[0].getSid()}">
        <input type="hidden" name="id" value="${student[0].getId()}">
        <table>
            <tr>
                <td><p class="register-form-cells">${messages.get("name")}</p></td>
                <td><input type="text" name="name" value="${student[0].getName()}" class="register-form-cells" class="register-form-cells"/> <br/></td>
            </tr>

            <tr>
                <td><p class="register-form-cells">${messages.get("family")}</p></td>
                <td><input type="text" name="family" value="${student[0].getFamily()}" class="register-form-cells"/> <br/></td>
            </tr>
            <tr>
                <td><p class="register-form-cells">${messages.get("age")}</p></td>
                <td><input type="text" name="age" value="${student[0].getAge()}" class="register-form-cells"/> <br/></td>
            </tr>
            <tr>
                <td colspan="2" class="register-form-btn-holder"><input type="submit" value="${messages.get("register_page_btn_submit")}" class="register-form-btn"/></td><!--register_page_btn_save-->
            </tr>
        </table>
    </form>
    </span>
</div>
</body>
</html>

