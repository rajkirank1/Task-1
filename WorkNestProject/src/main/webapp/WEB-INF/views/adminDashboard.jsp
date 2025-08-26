<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Admin Dashboard</title></head>
<body>
<h2>Admin Dashboard</h2>
<p><a href="admin/users">Manage Users</a> | <a href="admin/tasks">Manage Tasks</a> | <a href="logout">Logout</a></p>

<h3>Task Overview</h3>
<ul>
    <li>Pending: ${pending}</li>
    <li>In Progress: ${inProgress}</li>
    <li>Completed: ${completed}</li>
    <li>Delayed: ${delayed}</li>
</ul>

<h3>Recent Comments</h3>
<c:forEach var="c" items="${comments}">
    <div>
        <strong>${c.user.name}</strong> on <em>${c.task.title}</em>: ${c.text}
    </div>
</c:forEach>

</body>
</html>
