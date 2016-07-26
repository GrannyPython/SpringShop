<%@ include file="../panel.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="col-md-12 ">
        <div class="row text-center">
            <div class="col-md-2"><p class="itemName">OrderID</p></div>
            <div class="col-md-2"><p class="itemName">Date Order</p></div>
            <div class="col-md-2"><p class="itemName">DelivMethod</p></div>
            <div class="col-md-2"><p class="itemName">PaymentMethod</p></div>
            <div class="col-md-2"><p class="itemName">PaymenttStatus</p></div>
        </div>

        <c:if test="${not empty orderList}">
            <c:forEach var="o" items="${orderList}">
                <div class="row text-center">
                    <div class="col-md-2"><p>${o.id}</p></div>
                    <div class="col-md-2"><p>${o.date}</p></div>
                    <div class="col-md-2"><p>${o.deliveryMethod}</p></div>
                    <div class="col-md-2"><p>${o.paymentMethod}</p></div>
                    <div class="col-md-2"><p>${o.paymentStatus}</p></div>
                </div>
            </c:forEach>
        </c:if>

        <c:if test="${empty orderList}">
            <div class="row text-center">
                <h3>You didnt make order yet</h3>
            </div>
        </c:if>
        <div class="col-md-12 text-center">
            <img src="<c:url value="/resources/core/img/ol.png" />" width="343"
                 height="512"/>
        </div>
    </div>
</div>
