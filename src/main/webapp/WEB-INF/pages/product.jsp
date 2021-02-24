<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<html>
<head>
    <title>PRODUCT</title>

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
    <h2>Product</h2>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>quantity</th>
            <th>price</th>
        </tr>
        <c:forEach var="prod" items="${productList}">
            <tr>
                <td>${prod.id}</td>
                <td>${prod.name}</td>
                <td>${prod.quantity}</td>
                <td>${prod.price}</td>
                <td>
                    <security:authorize access="hasAuthority('ROLE_ADMIN')">
                        <a href="/product/edit/${prod.id}">edit</a>
                        <a href="/product/delete/${prod.id}">delete</a>
                    </security:authorize>
                    <input  href="${pageContext.request.contextPath}/product/Add/product_order/${prod.id}" id="add" type="button" value="Добавить товар в корзину ">
                    <p>укажите количество твара</p>
                    <input type="hidden" id="quantity"/>
                </td>
            </tr>
        </c:forEach>
    </table>


    <security:authorize access="hasAuthority('ROLE_ADMIN')">
        <c:url value="/product/add" var="add"/>
        <h2>Add</h2>
        <a href="${add}">Add new product</a>
    </security:authorize>
    <h2>Break</h2>
    <a href="${pageContext.request.contextPath}/">Break home</a>
</body>
</html>