<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Users</title>
</head>
<body>

<h2>Users List</h2>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/admin/dashboard">Back to Dashboard</a>

</body>
</html>
