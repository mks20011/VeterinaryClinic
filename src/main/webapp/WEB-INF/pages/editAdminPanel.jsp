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
<form:form action="${action}" method="POST" modelAttribute="editUser">
    <c:if test="${title=='EDIT'}">
        <form:input type="hidden" name="id" path="id"/>
    </c:if>

    <form:label for="login" path="login">login</form:label>
    <form:input type="text" name="login" id="login" path="login"/>
    <form:errors path="login" cssClass="errors"/>

    <form:label for="role" path="role">role</form:label>
    <form:input type="text" name="role" id="role" path="role"/>
    <form:errors path="role" cssClass="errors"/>

    <form:label for="activateAccount" path="activateAccount">activate_account</form:label>
    <form:input type="text" name="activateAccount" id="activateAccount" path="activateAccount"/>
    <form:errors path="activateAccount" cssClass="errors"/>


    <input type="submit" value="${title} person">
    </br>
    <h2>Break</h2>
    <a href="${pageContext.request.contextPath}/person">Break person</a>
</form:form>
</body>
</html>