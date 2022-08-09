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
        $(document).ready(function () {
            $(document.querySelectorAll("button")).click(function () {
                let id = this.id;
                let quantity = $('#quantity' + id).val();
                if (quantity) {
                    $.ajax({
                        type: 'GET',
                        url: '/product/add/getSearchProduct',
                        data: {id: id},
                        success: function (response) {
                            alert(response);
                        }
                    });
                } else {
                    alert("введите количество");
                }
            });
        });
    </script>

</head>
<body>
<h2>Product</h2>
<table>
    <tr>
        <security:authorize access="hasAuthority('ROLE_ADMIN')">
            <th>id</th>
        </security:authorize>
        <th>name</th>
        <th>quantity in stock</th>
        <th>price</th>
    </tr>
    <c:forEach var="prod" items="${productList}">
        <tr>
            <security:authorize access="hasAuthority('ROLE_ADMIN')">
                <td>${prod.id}</td>
            </security:authorize>
            <td>${prod.name}</td>
            <td>${prod.quantity}</td>
            <td>${prod.price}</td>
            <td>
                <security:authorize access="hasAuthority('ROLE_ADMIN')">
                    <a href="/product/edit/${prod.id}">edit</a>
                    <a href="/product/delete/${prod.id}">delete</a>
                </security:authorize>
                <button id="${prod.id}" value="add to cart"></button>

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