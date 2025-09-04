<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
</head>
<body>

<h2>Admin Dashboard</h2>

<h3>Users</h3>
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

<h3>Tasks</h3>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Status</th>
        <th>Assigned Users</th>
    </tr>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td>${task.id}</td>
            <td>${task.title}</td>
            <td>${task.description}</td>
            <td>${task.status}</td>
            <td>
                <c:forEach var="user" items="${task.assignedUsers}" varStatus="status">
                    ${user.username}<c:if test="${!status.last}">, </c:if>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/admin/tasks/new">Create New Task</a> | 
<a href="${pageContext.request.contextPath}/admin/users">Manage Users</a>

</body>
</html>
