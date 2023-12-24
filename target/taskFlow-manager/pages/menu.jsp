<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<td>
    <a href="${pageContext.request.contextPath}/users/read">
        <button type="submit">Users</button>
    </a>
</td>
<td>
    <a href="${pageContext.request.contextPath}/teams/read">
        <button type="submit">Teams</button>
    </a>
</td>
<td>
    <a href="${pageContext.request.contextPath}/tasks/read">
        <button type="submit">Tasks</button>
    </a>
</td>
<td>
    <a href="${pageContext.request.contextPath}/logout">
        <button type="submit">Logout</button>
    </a>
</td>
</body>
</html>
