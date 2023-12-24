<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tasks</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Priority</th>
        <th>Status</th>
        <th>Assignee</th>
        <th>Team</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td>${task.title}</td>
            <td>${task.description}</td>
            <td>${task.priority}</td>
            <td>${task.status}</td>
            <td>${task.assignee.username}</td>
            <td>${task.team.teamName}</td>
            <td>
                <a href="${pageContext.request.contextPath}/tasks/update?taskId=${task.taskId}">
                    <button type="submit">Изменить</button>
                </a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/tasks/delete?taskId=${task.taskId}">
                    <button type="submit">Удалить</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<td>
    <a href="${pageContext.request.contextPath}/tasks/create">
        <button type="submit">Add new task</button>
    </a>
</td>
<td>
    <a href="${pageContext.request.contextPath}/menu">
        <button type="submit">Back to menu</button>
    </a>
</td>
</body>
</html>
