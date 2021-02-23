<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
</head>
<body>
<h2>

    <a href="${pageContext.request.contextPath}/product">product</a>
    </br>
    <a href="${pageContext.request.contextPath}/login">login</a>
    </br>
    <a href="${pageContext.request.contextPath}/registration">registration</a>
</h2>
</br>
<form:form action="/logout" method="post">
    <input value="Logout ${message}" type="submit">
</form:form>
</br>
<h2>
    <security:authorize access="hasAuthority('ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath}/adminPanel">adminPanel</a>
        <a href="${pageContext.request.contextPath}/record">record</a>
    </security:authorize>
</h2>
</body>
</html>
