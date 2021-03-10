<%--
  Created by IntelliJ IDEA.
  User: peyma
  Date: 3/10/2021
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register page</title>
</head>
<body>
    <form style="border: 1px black dotted" action="/student-register.do" method="post">
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name"/> <br/></td>
            </tr>

            <tr>
                <td>Family:</td>
                <td><input type="text" name="family"/> <br/></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><input type="text" name="age"/> <br/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Register"/></td>
            </tr>
        </table>




    </form>
</body>
</html>
