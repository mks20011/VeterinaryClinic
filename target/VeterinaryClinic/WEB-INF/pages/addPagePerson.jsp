<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add</title>
    <style>
        .errors {
            color: red;
        }
    </style>
</head>
<body>
<c:url value="/person/add" var="var"/>
<form:form action="${var}" method="POST" modelAttribute="addPerson">


    <form:label for="name" path="name"/>
    <form:input type="text" name="name" id="name" path="name"/>
    <form:errors path="name" cssClass="errors"/>

    <form:label for="surName" path="surName"/>
    <form:input type="text" name="surName" id="surName" path="surName"/>
    <form:errors path="surName" cssClass="errors"/>

    <form:label for="age" path="numberPhone"/>
    <form:input type="text" name="age" id="age" path="age"/>
    <form:errors path="age" cssClass="errors"/>

    <form:label for="numberPhone" path="numberPhone"/>
    <form:input type="text" name="numberPhone" id="numberPhone" path="numberPhone"/>
    <form:errors path="numberPhone" cssClass="errors"/>
    <input type="submit" value="Add new Person">
    </br>
    <h2>Break</h2>
    <a href="${pageContext.request.contextPath}/person">Break person</a>
</form:form>
</body>
</html>