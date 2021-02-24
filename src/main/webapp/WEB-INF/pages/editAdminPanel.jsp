<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<html>
<head>
    <title>${title}</title>
    <style>
        .errors {
            color: red;
        }
    </style>
    <script>
        $(document).ready(function() {
            let password = $('#password');
            if(${title=='EDIT'}){
                password.attr('hidden', true);
            }else {
                password.attr('hidden', false);
            }
        });
    </script>
</head>
<body>
<form:form action="${action}" method="POST" modelAttribute="editUser">
    <c:if test="${title=='EDIT'}">
        <form:input type="hidden" name="id" path="id"/>
    </c:if>

    <form:label for="login" path="login">login</form:label>
    <form:input type="text" name="login" id="login" path="login"/>
    <form:errors path="login" cssClass="errors"/>

    </br>
    <form:label for="role" path="role">role</form:label>
    <form:input type="text" name="role" id="role" path="role"/>
    <form:errors path="role" cssClass="errors"/>

    </br>
    <form:label for="password" path="password">password</form:label>
    <form:input type="text" name="password" id="password" path="password" />
    <form:errors path="password" cssClass="errors"/>

    </br>
    <form:label for="activateAccount" path="activateAccount">activate_account</form:label>
    <form:input type="text" name="activateAccount" id="activateAccount" path="activateAccount"/>
    <form:errors path="activateAccount" cssClass="errors"/>

    </br>
    <input type="submit" id="submitUser" value="${title} user">
    </br>
    <h2>Break</h2>
    <a href="${pageContext.request.contextPath}/">Break home</a>
</form:form>
</body>
</html>