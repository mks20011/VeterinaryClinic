<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>RECORD</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/animal">List animal</a>
</br>
<a href="${pageContext.request.contextPath}/person">List person</a>

<table>
    <tr>
        <td>id</td>
        <td>data</td>
        <td>person</td>
        <td>animal</td>
        <td>action</td>
    </tr>
    <c:forEach var="record" items="${recordList}">
        <tr>
            <td>${record.id}</td>
            <td>${record.data}</td>
            <td>${record.person.id}</td>
            <td>${record.idAnimal}</td>
            <td>
                <a href="/record/edit/${record.id}">edit</a>
                <a href="/record/delete/${record.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h2>Add</h2>
<c:url value="/record/add" var="add"/>
<a href="${add}">Add new record</a>
<h2>Break</h2>
<a href="${pageContext.request.contextPath}/">Break home</a>
</body>
</html>
