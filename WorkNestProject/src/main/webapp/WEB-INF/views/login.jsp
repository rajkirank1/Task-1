<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Login</title></head>
<body>
<h2>Login</h2>
<form action="auth/login" method="post">
    Email: <input type="text" name="email"/><br/>
    Password: <input type="password" name="password"/><br/>
    <input type="submit" value="Login"/>
</form>
</body>
</html>
