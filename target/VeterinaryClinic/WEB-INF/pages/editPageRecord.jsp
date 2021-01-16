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
        let animalList = null;
        // let select = $('#selectName');
        $(document).ready(function() {
            $('#research').click(function () {
                let numberPhone = $('#numberPhone').val();
                $('#select1').find('option').remove();
                if (numberPhone) {

                    $.ajax({
                        type: 'GET',
                        url: '/record/add/getSearchResult',
                        data: {numberPhone: numberPhone},
                        success: function (response) {
                            $('#idPerson').val(response.id);
                            $('#person').val(response.name + " " + response.surName + " " + response.age);
                            animalList = response.animalList;

                            animalList.forEach(function (element) {
                                $('#select1').append('<option value="'
                                    + element.id
                                    + '">'
                                    + element.view + " "
                                    + element.nickname + " "
                                    + "Возраст: " + element.age
                                    + '</option>');
                            });
                        }
                    });
                } else {
                    alert("Введите номер телефона")
                }
            });
        });
    </script>
</head>
<body>

<form:form action="${action}" method="POST" modelAttribute="editRecord">
    <c:if test="${title=='EDIT'}">
        <form:input type="hidden" name="id" path="id"/>
    </c:if>

    <form:label for="data" path="data">data</form:label>
    <form:input type="datetime-local"  path="data"/>
    <form:errors path="data" cssClass="errors"/>

    <form:label for="numberPhone" path="numberPhone">numberPhone</form:label>
    <form:input type="text" id="numberPhone" placeholder="Введите номер" path="numberPhone"/>
    <form:errors path="numberPhone" cssClass="errors"/>

    <input id="research"  type="button" value="Поиск клиента">

    <form:label for="select1" path="idAnimal">animal</form:label>
    <form:select path="idAnimal" id="select1">
    </form:select>

    <form:label for="idPerson" path="idPerson"/>
    <form:input id="idPerson" path="idPerson" type="hidden"/>
    <form:errors path="idPerson" cssClass="errors"/>

    <input type="submit" value="${title} record">
    </br>
    <label for="person">person</label>
    <p><input type="text" id="person" disabled></p>

    <h2>Break</h2>
    <a href="${pageContext.request.contextPath}/record">Break record</a>
</form:form>
</body>
</html>