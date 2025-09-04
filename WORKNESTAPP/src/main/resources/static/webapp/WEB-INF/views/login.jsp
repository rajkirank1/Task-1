<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h2>Login</h2>

<c:if test="${not empty error}">
    <div style="color:red">${error}</div>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/login">
    <table>
        <tr>
        <td>Username:</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Login" /></td>
        </tr>
    </table>
</form>

<a href="${pageContext.request.contextPath}/register">Don't have an account? Register here</a>

</body>
</html>
