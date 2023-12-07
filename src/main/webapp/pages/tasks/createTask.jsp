<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Task</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/tasks/create" method="POST">
    <table>
        <thead>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Assignee</th>
            <th>Team</th>
            <th>Priority</th>
            <th>Status</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" name="task" placeholder="put task title"></td>
            <td><input type="text" name="task_description" placeholder="put task description"></td>
            <td>
                <select name="user">
                    <c:forEach var="user" items="${users}">
                        <option value="${user.userId}">${user.username}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="team">
                    <c:forEach var="team" items="${teams}">
                        <option value="${team.teamId}">${team.teamName}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="priorities">
                    <c:forEach var="priority" items="${priorities}">
                        <option value="${priority}">${priority}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="statuses">
                    <c:forEach var="status" items="${statuses}">
                        <option value="${status}">${status}</option>
                    </c:forEach>
                </select>
            </td>
            <td><input type="submit" value="CREATE"></td>
        </tr>
        </tbody>
    </table>
</form>

</body>
</html>
