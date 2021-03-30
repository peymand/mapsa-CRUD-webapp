<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <a class="btn" href="/index.do">Home</a>
    <a class="btn" href="<c:url value="/list-page.do"/>">List of Students</a>
    <a class="btn" href="/register.do">Register a Student</a>
    <a class="btn" href="/search.do">Search</a>
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
                <td><input type="submit" value="Search" class="tbl-search-input-btn"></td>
            </tr>
        </form>
    </table>
</div>
</body>
</html>
