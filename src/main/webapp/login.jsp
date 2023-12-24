<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create user</title>
</head>
<body>
<form action="/login" method="POST">
    <td><input type="text" name="username" placeholder="put your username"></td>
    <td><input type="text" name="password" placeholder="put your password"></td>
    <td><input type="submit" value="LOGIN"></td>
</form>
</body>
</html>