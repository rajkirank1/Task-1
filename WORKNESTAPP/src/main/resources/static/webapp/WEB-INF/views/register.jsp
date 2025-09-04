<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>

<h2>Register</h2>

<c:if test="${not empty error}">
    <div style="color:red">${error}</div>
</c:if>

<form:form method="post" modelAttribute="user" action="${pageContext.request.contextPath}/register">
    <table>
        <tr>
              <td>Username:</td>
            <td><form:input path="username" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email" type="email" /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:password path="password" /></td>
        </tr>
        <tr>
            <td>Role:</td>
            <td>
                <select name="role">
                    <option value="ROLE_USER">User</option>
                    <option value="ROLE_ADMIN">Admin</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Register" /></td>
        </tr>
    </table>
</form:form>

<a href="${pageContext.request.contextPath}/login">Already have an account? Login here</a>

</body>
</html>
