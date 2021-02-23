<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<form:form method="post" action="/login">
    <h2>Login in</h2>
    </br>
    <span>${message}</span>
    </br>
    <div>
        <input id="login" name="login" type="text" placeholder="Login"/>
        <label for="login">Login</label>
    </div>
    </br>
    <div>
        <input id="password" name="password" type="password" placeholder="Password"/>
        <label for="password">Password</label>
    </div>
    </br>
    <span>${error}</span>
    </br>
    <div>
        <button type="submit">Log In</button>
    </div>
    </br>
    <h2>Registration</h2>
    <a href="${pageContext.request.contextPath}/registration">Create new account</a>
    <h2>Break</h2>
    <a href="${pageContext.request.contextPath}/">Break home</a>
</form:form>


</body>
</html>
