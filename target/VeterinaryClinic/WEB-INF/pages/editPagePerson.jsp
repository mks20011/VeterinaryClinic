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
<form:form action="${action}" method="POST" modelAttribute="editPerson">
<c:if test="${title=='EDIT'}">
    <form:input type="hidden" name="id" path="id"/>
</c:if>

    <form:label for="name" path="name">Name</form:label>
    <form:input type="text" name="name" id="name" path="name"/>
    <form:errors path="name" cssClass="errors"/>

    <form:label for="surName" path="surName">SurName</form:label>
    <form:input type="text" name="surName" id="surName" path="surName"/>
    <form:errors path="surName" cssClass="errors"/>

    <form:label for="age" path="age">Age</form:label>
    <form:input type="text" name="age" id="age" path="age"/>
    <form:errors path="age" cssClass="errors"/>

    <form:label for="numberPhone" path="numberPhone">NumberPhone</form:label>
    <form:input type="text" name="numberPhone" id="numberPhone" path="numberPhone"/>
    <form:errors path="numberPhone" cssClass="errors"/>

    <input type="submit" value="${title} person">
    </br>
    <h2>Break</h2>
    <a href="${pageContext.request.contextPath}/person">Break person</a>
</form:form>
</body>
</html>