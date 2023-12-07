<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Username</th>
        <th>Email</th>
        <th>Roles</th>
        <th>Teams</th>
        <th>Tasks</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <td>
                <c:forEach var="team" items="${user.teams}">
                    ${team.teamName}<br/>
                </c:forEach>
            </td>
            <td>
                <c:forEach var="task" items="${user.tasks}">
                    ${task.title}<br/>
                </c:forEach>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/users/update?userId=${user.userId}">
                    <button type="submit">Изменить</button>
                </a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/users/delete?userId=${user.userId}">
                    <button type="submit">Удалить</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<td>
    <a href="${pageContext.request.contextPath}/users/create">
        <button type="submit">Create new user</button>
    </a>
</td>
<td>
    <a href="${pageContext.request.contextPath}/menu">
        <button type="submit">Back to menu</button>
    </a>
</td>
</body>
</html>
