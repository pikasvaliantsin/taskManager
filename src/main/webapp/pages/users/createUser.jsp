<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create user</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/users/create" method="POST">
    <table>
        <thead>
        <tr>
            <th>Username</th>
            <th>Email</th>
            <th>Password</th>
            <th>Roles</th>
            <th>Teams</th>
            <th>Tasks</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><input type="text" name="username" placeholder="put your username"></td>
            <td><input type="text" name="email" placeholder="put your email"></td>
            <td><input type="text" name="password" placeholder="put your password"></td>
            <td>
                <select name="role">
                    <c:forEach var="role" items="${roles}">
                        <option value="${role}">${role}</option>
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
            <td>
                <select name="team">
                    <c:forEach var="team" items="${teams}">
                        <option value="${team.teamId}">${team.teamName}</option>
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
