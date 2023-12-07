<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ошибка</title>
</head>
<body>
<h1>Ошибка, пользователь с логином "${username}" уже существует!</h1>
<a href="${pageContext.request.contextPath}/users/create">
    <button type="submit">Вернуться назад</button>
</a>
</body>
</html>
