<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>PRODUCT</title>
</head>
<body>

<h2>Product</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>quantity</th>
        <th>price</th>

    </tr>
    <c:forEach var="prod" items="${productList}">
        <tr>
            <td>${prod.id}</td>
            <td>${prod.name}</td>
            <td>${prod.quantity}</td>
            <td>${prod.price}</td>
            <td>
                <security:authorize access="hasAuthority('ROLE_ADMIN')">
                    <a href="/product/edit/${prod.id}">edit</a>
                    <a href="/product/delete/${prod.id}">delete</a>
                </security:authorize>
                <a href="/product/addToCart/${prod.id}">add to cart</a>
            </td>
        </tr>
    </c:forEach>
</table>


<security:authorize access="hasAuthority('ROLE_ADMIN')">
    <c:url value="/product/add" var="add"/>
    <h2>Add</h2>
    <a href="${add}">Add new product</a>
</security:authorize>
<h2>Break</h2>
<a href="${pageContext.request.contextPath}/">Break home</a>
</body>
</html>