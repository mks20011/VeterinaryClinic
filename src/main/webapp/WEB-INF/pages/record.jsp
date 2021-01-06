<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>RECORD</title>
</head>
<body>
<c:url value="/animal" var="animalPage"/>
<a href="${animalPage}">List animal</a>
</br>
<c:url value="/person" var="recordPage"/>
<a href="${recordPage}">List person</a>

<table>
    <tr>
        <td>id</td>
        <td>data</td>
        <td>name</td>
        <td>number</td>
        <td>animal</td>
        <td>action</td>
    </tr>
    <c:forEach var="record" items="${recordList}">
        <tr>
            <td>${record.id}</td>
            <td>${record.data}</td>
            <td>${record.person.name}</td>
            <td>${record.person.numberPhone}</td>
            <td>${record.animal.view}</td>
            <td>
                <a href="/record/edit/${record.id}">edit</a>
                <a href="/record/delete/${record.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new record</a>
</body>
</html>
