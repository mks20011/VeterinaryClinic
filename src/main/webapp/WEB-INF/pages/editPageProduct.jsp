<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>${title}</title>
    <style>
        .errors {
            color: red;
        }
    </style>
</head>
<body>
<form:form action="${action}" method="POST" modelAttribute="editProduct">
    <c:if test="${title=='EDIT'}">
        <form:input type="hidden" name="id" path="id"/>
    </c:if>

    <form:label for="name" path="name">Name</form:label>
    <form:input type="text" name="name" id="name" path="name"/>
    <form:errors path="name" cssClass="errors"/>

    <form:label for="quantity" path="quantity">Quantity</form:label>
    <form:input type="text" name="quantity" id="quantity" path="quantity"/>
    <form:errors path="quantity" cssClass="errors"/>

    <form:label for="price" path="price">Price</form:label>
    <form:input type="text" name="price" id="price" path="price"/>
    <form:errors path="price" cssClass="errors"/>

    <input type="submit" value="${title} product">
    </br>
    <h2>Break</h2>
    <a href="${pageContext.request.contextPath}/product">Break product</a>
</form:form>
</body>
</html>