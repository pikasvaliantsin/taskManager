<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Teams</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Members</th>
        <th>Tasks</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="team" items="${teams}">
        <tr>
            <td>${team.teamName}</td>
            <td>
                <c:forEach var="member" items="${team.members}">
                    ${member.username}<br/>
                </c:forEach>
            </td>
            <td>
                <c:forEach var="task" items="${team.tasks}">
                    ${task.title}<br/>
                </c:forEach>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/teams/update?teamId=${team.teamId}">
                    <button type="submit">Изменить</button>
                </a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/teams/delete?teamId=${team.teamId}">
                    <button type="submit">Удалить</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<td>
    <a href="${pageContext.request.contextPath}/teams/create">
        <button type="submit">Create new team</button>
    </a>
</td>
<td>
    <a href="${pageContext.request.contextPath}/menu">
        <button type="submit">Back to menu</button>
    </a>
</td>
</body>
</html>
