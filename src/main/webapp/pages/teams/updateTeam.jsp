<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update team</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/teams/update" method="POST">
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
            <td><input type="text" name="teamName" value="${name}"></td>
            <td>
                <c:forEach var="user" items="${users}">
                    <c:choose>
                        <c:when test="${members.contains(user)}">
                            <input type="checkbox" name="checkedMember" value="${user.userId}" checked>${user.username}
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" name="checkedMember" value="${user.userId}">${user.username}
                        </c:otherwise>
                    </c:choose>
                    <br/>
                </c:forEach>
            </td>
            <td>
                <c:forEach var="task" items="${allTasks}">
                    <c:choose>
                        <c:when test="${tasks.contains(task)}">
                            <input type="checkbox" name="checkedTasks" value="${task.taskId}" checked>${task.title}
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" name="checkedTasks" value="${task.taskId}">${task.title}
                        </c:otherwise>
                    </c:choose>
                    <br/>
                </c:forEach>

            </td>
        </tr>
        </tbody>
    </table>
    <input type="submit" value="UPDATE">
</form>
</body>
</html>

