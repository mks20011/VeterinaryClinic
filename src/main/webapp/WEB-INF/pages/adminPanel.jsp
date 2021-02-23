<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin panel</title>
</head>
<body>

<h2>Users</h2>
<table>
    <tr>
        <th>id</th>
        <th>login</th>
        <th>role</th>
        <th>activate account</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.role}</td>
            <td>${user.activateAccount}</td>
            <td>
                <a href="/adminPanel/edit/${user.id}">edit</a>
                <a href="/adminPanel/delete/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/adminPanel/add" var="add"/>
<a href="${add}">Add new user</a>
<h2>Break</h2>
<a href="${pageContext.request.contextPath}/">Break home</a>
</body>
</html>