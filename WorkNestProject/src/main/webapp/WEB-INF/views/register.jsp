<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Register</title></head>
<body>
<h2>Register</h2>
<form action="auth/register" method="post">
    Name: <input type="text" name="name"/><br/>
    Email: <input type="text" name="email"/><br/>
    Password: <input type="password" name="password"/><br/>
    Role: <select name="role"><option>USER</option><option>ADMIN</option></select><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
