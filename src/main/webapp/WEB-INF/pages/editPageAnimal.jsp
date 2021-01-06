<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
        <title>${title}</title>
</head>
<body>

<form:form action="${action}" method="POST" modelAttribute="editAnimal">
    <c:if test="${title =='EDIT'}">
        <form:input type="hidden" name="id" path="id"/>
    </c:if>

    <form:label for="nickname" path="nickname">nickname</form:label>
    <form:input type="text" name="nickname" id="nickname" path="nickname"/>
    <form:errors path="nickname" cssClass="errors"/>

    <form:label for="view" path="view">view</form:label>
    <form:input type="text" name="view" id="view" path="view"/>
    <form:errors path="view" cssClass="errors"/>

    <form:label for="age" path="age">age</form:label>
    <form:input type="text" name="age" id="age" path="age"/>
    <form:errors path="age" cssClass="errors"/>
    </br>
    <label name="person">${person.id} ${person.name} ${person.numberPhone}</label>

    <form:label for="idPerson" path="idPerson"/>
    <form:input name="idPerson" id="idPerson" path="idPerson"  type="hidden"/>
    <form:errors path="idPerson" cssClass="errors"/>

    </br>
        <h2>${title}</h2>
        <input type="submit" value="${title} Animal">
    </br>
    <h2>Break</h2>
    <a href="${pageContext.request.contextPath}/animal">Break animal</a>
</form:form>
</body>
</html>