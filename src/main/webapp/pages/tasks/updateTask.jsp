<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Task</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/tasks/update" method="POST">
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
            <td><input type="text" name="task" value="${task}"></td>
            <td><input type="text" name="task_description" value="${task_description}"></td>
            <td>
                <select name="user">
                    <c:forEach var="user" items="${users}">
                        <c:choose>
                            <c:when test="${user == taskUser}">
                                <option value="${user.userId}" selected>${user.username}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${user.userId}">${user.username}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="team">
                    <c:forEach var="team" items="${teams}">
                        <c:choose>
                            <c:when test="${team == taskTeam}">
                                <option value="${team.teamId}" selected>${team.teamName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${team.teamId}">${team.teamName}</option>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="priorities">
                    <c:forEach var="priority" items="${priorities}">
                        <c:choose>
                            <c:when test="${priority==currentPriority}">
                                <option value="${priority}" selected>${priority}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${priority}">${priority}</option>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="statuses">
                    <c:forEach var="status" items="${statuses}">
                        <c:choose>
                            <c:when test="${status==currentStatus}">
                                <option value="${status}" selected>${status}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${status}">${status}</option>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>
                </select>
            </td>
            <td>
                <input type="submit" value="UPDATE">
            </td>
        </tr>
        </tbody>
    </table>
</form>

</body>
</html>
