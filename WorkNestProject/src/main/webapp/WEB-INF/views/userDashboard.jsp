<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>User Dashboard</title></head>
<body>
<h2>Your Tasks</h2>
<p><a href="logout">Logout</a></p>

<table border="1">
    <tr><th>Title</th><th>Start</th><th>Due</th><th>Status</th><th>Actions</th></tr>
    <c:forEach var="t" items="${tasks}">
        <tr>
            <td>${t.title}</td>
            <td>${t.startDate}</td>
            <td>${t.dueDate}</td>
            <td>${t.status}</td>
            <td>
                <form action="task/updateStatus" method="post" style="display:inline">
                    <input type="hidden" name="taskId" value="${t.id}"/>
                    <select name="status">
                        <option>IN_PROGRESS</option>
                        <option>COMPLETED</option>
                    </select>
                    <input type="submit" value="Update"/>
                </form>
                <a href="task/details?taskId=${t.id}">Details</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
