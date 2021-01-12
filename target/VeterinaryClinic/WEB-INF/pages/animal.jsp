<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ANIMAL</title>
</head>
<body>

<h2>Animal</h2>
<table>
    <tr>
        <th>id</th>
        <th>view</th>
        <th>nickname</th>
        <th>age</th>
        <th>idPerson</th>
        <th>action</th>
    </tr>
    <c:forEach var="animal" items="${animalList}">
        <tr>
            <td>${animal.id}</td>
            <td>${animal.view}</td>
            <td>${animal.nickname}</td>
            <td>${animal.age}</td>
            <td>${animal.idPerson}</td>
            <td>
                <a href="/animal/edit/${animal.id}">edit</a>
                <a href="/animal/delete/${animal.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Break</h2>
<a href="${pageContext.request.contextPath}/">Break home</a>
</body>
</html>