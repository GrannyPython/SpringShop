<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../panel.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <br>
    <div class="row">
        <div class="col-md-12 ">
            <p class="lead text-center">The most popular products</p>

            <div class="row text-center">
                <div class="col-md-6 text-center"><h4>Product ID</h4></div>
                <div class="col-md-6 text-center"><h4>Product Name</h4></div>
            </div>

            <c:if test="${not empty popular}">
                <c:forEach var="p" items="${popular}">
                    <div class="row text-center">
                        <div class="col-md-6"><p>${p.productID}</p></div>
                        <div class="col-md-6"><p>${p.name}</p></div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>