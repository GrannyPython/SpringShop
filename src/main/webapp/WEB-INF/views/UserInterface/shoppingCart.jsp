<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="css/custom.css"/>
<%@ include file="../panel.jsp" %>

<div class="container text-center">
    <div class="col-md-5 col-sm-12">
        <img src="<c:url value="/resources/core/img/sprite.png" />" width=""
             height="250" alt="TestDisplay"/>

        <h1>Your shopping cart</h1>
    </div>

    <c:if test="${not empty scList}">
        <div class="col-md-7 col-sm-12 ">
            <table class="table">
                <thead>
                <tr>
                    <th>ITEM</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total Price</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="sc" items="${scList}">
                        <tr>
                            <th scope="row">${sc.warehouse.product.name}</th>
                            <td>${sc.amount}</td>
                            <td>${sc.warehouse.price}</td>
                            <td>${fn:substringBefore(sc.warehouse.price*sc.amount, '.')}</td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="${cart}" method="post">
                <div class="row">
                    <div class="col-md-4 text-center">
                        <input type="radio" name="paymentMethod" value=Visa checked> Visa
                        <input type="radio" name="paymentMethod" value=MasterCard> MasterCard
                    </div>
                    <div class="col-md-4 text-center">
                        <input type="radio" name="deliveryMethod" value=cheapest checked> cheapest
                        <input type="radio" name="deliveryMethod" value=fastest> fastest
                    </div>
                </div>
                <input type="submit" value="Buy" class="btn btn-primary btn-lg btn-success">
            </form>
        </div>
    </c:if>

    <c:if test="${empty scList}">
        <div class="col-md-7 col-sm-12 text-left">
            <img src="<c:url value="/resources/core/img/crt.png" />" width="400"
                 height="300" />
        </div>
    </c:if>
</div>


</body>
</html>