<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PERSON</title>
</head>
<body>

<h2>Person</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>age</th>
        <th>number phone</th>
        <th>action</th>
    </tr>
    <c:forEach var="person" items="${personList}">
        <tr>
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.surName}</td>
            <td>${person.age}</td>
            <td>${person.numberPhone}</td>
            <td>
                <a href="/person/edit/${person.id}">edit</a>
                <a href="/person/delete/${person.id}">delete</a>
                <a href="/animal/add/${person.id}">add_animal</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/person/add" var="add"/>
<a href="${add}">Add new person</a>
<h2>Break</h2>
<a href="${pageContext.request.contextPath}/record">Break record</a>
</body>
</html>