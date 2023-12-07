<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create team</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/teams/create" method="POST">
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Member</th>
            <th>Task</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" name="teamName" placeholder="put your teamName"></td>
            <td>
                <select name="member">
                    <c:forEach var="user" items="${users}">
                        <option value="${user.userId}">${user.username}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="task">
                    <c:forEach var="task" items="${tasks}">
                        <option value="${task.taskId}">${task.title}</option>
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
