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
    <title>List of Students</title>
    <link rel="stylesheet" href="/style/style.css">
    <style>
      html {
        direction: ${messages.get("css_direction")};
      }
    </style>
</head>
<body class="body">
<div class="header">
    <h1 class="title">${messages.get("lis_page_title")}</h1>
    <form action="<c:url value="/list-page.do"/>" method="get"><select name="lang">
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
    <table class="tbl-student-list">
        <thead class="tbl-student-list-head">
        <tr style="border: 1px solid ; padding: 1px">
            <th class="tbl-student-list-cls">${messages.get("id")}</th>
            <th class="tbl-student-list-cls">${messages.get("name")}</th>
            <th class="tbl-student-list-cls">${messages.get("family")}</th>
            <th class="tbl-student-list-cls">${messages.get("age")}</th>
            <th class="tbl-student-list-cls">${messages.get("sid")}</th>
            <th class="tbl-student-list-cls">${messages.get("list_tbl_head_action")}</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${arr}" var="student">

            <tr class="tbl-student-list-rows" style="border: 1px solid ; padding: 1px">
                <td class="tbl-student-list-cls">${student.getId()}</td>
                <td class="tbl-student-list-cls">${student.getName()}</td>
                <td class="tbl-student-list-cls">${student.getFamily()}</td>
                <td class="tbl-student-list-cls">${student.getAge()}</td>
                <td class="tbl-student-list-cls">${student.getSid()}</td>
                <td class="tbl-student-list-cls">
                    <a class="btn tbl-student-list-btn" href="/register.do?operation=update&id=${student.getId()}&${messages.get("url_suffix")}">${messages.get("list_tbl_btn_edit")}</a>
                    <a class="btn tbl-student-list-btn" href="/delete.do?id=${student.getId()}&${messages.get("url_suffix")}">${messages.get("list_tbl_btn_delete")}</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
