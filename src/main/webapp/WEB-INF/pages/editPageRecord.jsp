<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>


<html>
<head>
    <title>${title}</title>
    <style>
        .errors {
            color: red;
        }
    </style>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css"
          rel="stylesheet"/>
    <script>
        $(document).ready(function () {
            $('#search').click(function () {
                let numberPhone = $('#search').val();
                $.ajax({
                    type: 'POST',
                    url: '/add/getSearchResult',
                    data:  {numberPhone: numberPhone},
                    success: function (response) {
                        console.log(response);
                        // $.each(response, function (key, value) {
                        //     console.log(key);
                        //     console.log(value);
                        // });
                    }
                });
            });
        });
    </script>
</head>
<body>

<form:form action="${action}" method="POST" modelAttribute="editRecord">
    <c:if test="${title=='EDIT'}">
        <form:input type="hidden" name="id" path="id"/>
    </c:if>

    <form:label for="data" path="data"/>
    <form:input type="data" name="data" id="data" path="data"/>
    <form:errors path="data" cssClass="errors"/>

    <input type="text" id="search" placeholder="Введите номер">

    <label type="text" id="name"></label>

    <input type="submit" value="${title} record">
    </br>
    <h2>Break</h2>
    <a href="${pageContext.request.contextPath}/">Break record</a>
</form:form>
</body>
</html>