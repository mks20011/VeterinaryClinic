<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <style>
        .errors {
            color: red;
        }
    </style>
    <script src="static/scripts/jquery-3.3.1.min.js"></script>

</head>
<body>

<form:form method="post" modelAttribute="user">
    <h2>Registration</h2>
    </br>

    <form:input id="login" path="login" required="required" placeholder="Login"/>
    <form:label path="login" for="login">Login</form:label>
    <div>
        <form:errors path="login" cssClass="errors"/>
    </div>

    <form:input type="password" id="password" path="password" placeholder="Password"
                required="required"/>
    <form:label path="password" for="password">Password</form:label>
    <div>
        <form:errors path="password" cssClass="errors"/>
    </div>

    <form:input type="password" id="confirmPassword" path="confirmPassword"
                placeholder="Confirm password" required="required"/>
    <form:label path="confirmPassword" for="confirmPassword">Confirm password</form:label>
    <div>
        <form:errors path="confirmPassword" cssClass="errors"/>
    </div>

    <form:input type="numberPhone" id="numberPhone" path="numberPhone" placeholder="numberPhone" required="required"/>
    <form:label path="numberPhone" for="numberPhone">Number Phone</form:label>
    <div>
        <form:errors path="numberPhone" cssClass="errors"/>
    </div>

    </br>
    <button id="button" type="submit">Registration</button>
    </br>
    <h2>Break</h2>
    <a href="${pageContext.request.contextPath}/login">Break login</a>
</form:form>

</body>
</html>
