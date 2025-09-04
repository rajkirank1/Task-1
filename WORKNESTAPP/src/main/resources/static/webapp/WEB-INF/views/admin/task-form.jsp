<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Task</title>
</head>
<body>

<h2>Create New Task</h2>

<form:form method="post" modelAttribute="task" action="${pageContext.request.contextPath}/admin/tasks">
    <table>
        <tr>
            <td>Title:</td>
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><form:textarea path="description" rows="4" cols="40" /></td>
        </tr>
        <tr>
            <td>Assign to Users:</td>
            <td>
                <c:forEach var="user" items="${users}">
                    <input type="checkbox" name="assignedUserIds" value="${user.id}" /> ${user.username}<br/>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Create Task" /></td>
        </tr>
    </table>
</form:form>

<a href="${pageContext.request.contextPath}/admin/dashboard">Back to Dashboard</a>

</body>
</html>
