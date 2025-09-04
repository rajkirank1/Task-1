<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.worknest.model.Task" %>
<%@ page import="com.worknest.model.Comment" %>

<%
    // Retrieve tasks list from controller
    List<Task> tasks = (List<Task>) request.getAttribute("tasks");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        border: 1px solid #333;
        padding: 8px;
    }
    th {
        background-color: #eee;
    }
</style>
</head>
<body>

<h2>User Dashboard</h2>

<% if (tasks == null || tasks.isEmpty()) { %>
    <p>No tasks assigned.</p>
<% } else { %>
    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Status</th>
                <th>Update Status</th>
                <th>Comments</th>
                <th>Add Comment</th>
            </tr>
        </thead>
        <tbody>
        <% for (Task task : tasks) { %>
            <tr>
                <td><%= task.getTitle() %></td>
                <td><%= task.getDescription() %></td>
                <td><%= task.getStatus() %></td>
                <td>
                    <form method="post" action="<%= request.getContextPath() %>/user/tasks/<%= task.getId() %>/status">
                        <select name="status">
                            <option value="PENDING" <%= "PENDING".equals(task.getStatus()) ? "selected" : "" %>>PENDING</option>
                            <option value="IN_PROGRESS" <%= "IN_PROGRESS".equals(task.getStatus()) ? "selected" : "" %>>IN_PROGRESS</option>
                            <option value="COMPLETED" <%= "COMPLETED".equals(task.getStatus()) ? "selected" : "" %>>COMPLETED</option>
                        </select>
                        <input type="submit" value="Update" />
                    </form>
                </td>
                <td>
                    <% if (task.getComments() != null && !task.getComments().isEmpty()) { %>
                        <ul>
                            <% for (Comment comment : task.getComments()) { %>
                                <li>
                                    <b><%= comment.getUser().getUsername() %></b>
                                    (<%= comment.getCreatedAt() %>): 
                                    <%= comment.getContent() %>
                                </li>
                            <% } %>
                        </ul>
                    <% } else { %>
                        No comments yet.
                    <% } %>
                </td>
                <td>
                    <form method="post" action="<%= request.getContextPath() %>/user/tasks/<%= task.getId() %>/comments">
                        <input type="text" name="content" placeholder="Add comment" required />
                        <input type="submit" value="Add" />
                    </form>
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
<% } %>

</body>
</html>
