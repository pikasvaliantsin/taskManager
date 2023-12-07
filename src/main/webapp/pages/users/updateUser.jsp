<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create user</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/users/update" method="POST">
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
            <td><input type="text" name="username" value="${username}"></td>
            <td><input type="text" name="email" value="${email}"></td>
            <td><input type="text" name="password" value="${password}"></td>
            <td>
                <select name="role">
                    <c:forEach var="role" items="${roles}">
                        <c:choose>
                            <c:when test="${role == userRole}">
                                <option value="${role}" selected>${role}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${role}">${role}</option>
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
