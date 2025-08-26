<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Task Details</title></head>
<body>
<h2>${task.title}</h2>
<p>${task.description}</p>
<p>Assigned to: ${task.assignedUser.name}</p>
<p>Status: ${task.status}</p>

<h3>Comments</h3>
<c:forEach var="c" items="${comments}">
    <div><strong>${c.user.name}</strong>: ${c.text}</div>
</c:forEach>

<h3>Add Comment</h3>
<form action="/comment/add" method="post">
    <input type="hidden" name="taskId" value="${task.id}"/>
    <textarea name="text"></textarea><br/>
    <input type="submit" value="Add"/>
</form>

</body>
</html>
