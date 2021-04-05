<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/style/style.css">
    <title>Home Page</title>
    <style>
      html {
        direction: ${messages.get("css_direction")};
      }
    </style>
</head>
<body class="body">
<div class="header">
    <h1 class="title">${messages.get("search_page_title")}</h1>
    <form action="<c:url value="/search.do"/>" method="get"><select name="lang">
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
    <table class="tbl-search">
        <form method="post" action="/search-result.do">
            <tr>
                <td><input type="text" name="userInput" class="tbl-search-input"></td>
                <td><select class="tbl-search-input-selector" name="searchType">
                    <option>Name</option>
                    <option>Family</option>
                    <option>Age</option>
                    <option>Id</option>
                </select></td>
                <td><input type="submit" value="${messages.get("search_page_btn")}" class="tbl-search-input-btn"></td>
            </tr>
        </form>
    </table>
</div>
</body>
</html>
