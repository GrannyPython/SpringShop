<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../panel.jsp" %>


<div class="container">
    <br>
    <div class="row">
        <div class="col-md-3">
            <a href="sellerOrders" class="btn btn-info" role="button">Not processed</a>
        </div>
        <div class="col-md-3">
            <a href="sellerOrders?ds=shipped" class="btn btn-info" role="button">Shipped</a>
        </div>
        <div class="col-md-3">
            <a href="sellerOrders?ds=delivered" class="btn btn-info" role="button">Delivered</a>
        </div>
        <div class="col-md-3">
            <a href="showStat" class="btn btn-danger" role="button">Best products</a>
        </div>
    </div>
    <div class="col-md-12 text-center ">
        <c:if test="${not empty orderList}">
            <div class="row">
                <c:if test="${ds!=null}">
                    <h3>Category "${ds}"</h3><br/>
                </c:if>
                <c:if test="${ds==null}">
                    <h3>Category "Not Processed"</h3><br/>
                </c:if>
            </div>
        </c:if>
        <br/>
        <div class="text-capitalize ">
            <div class="col-md-3">
                <p class="itemName">Product ID</p>
            </div>
            <div class="col-md-3">
                <p class="itemName">Product Name</p>
            </div>
            <div class="col-md-6">
                <p class="itemName">Status</p>
            </div>
        </div>

        <c:if test="${not empty orderList}">
            <c:forEach var="ol" items="${orderList}">
                <div class="row text-center">
                    <div class="col-md-3"><h4>${ol.id}</h4></div>
                    <div class="col-md-3"><h4>${ol.product.name}</h4></div>

                    <c:if test="${ol.deliveryStatus == 'not processed'}">
                        <div class="col-md-2"><a href="sellerOrders?ds=not processed&ID=${ol.id}"
                                                 class="btn btn-success"
                                                 role="button">not Processed</a></div>

                        <div class="col-md-2"><a href="sellerOrders?ds=shipped&ID=${ol.id}" class="btn btn-info"
                                                 role="button">
                            shipped </a></div>
                        <div class="col-md-2"><a href="sellerOrders?ds=delivered&ID=${ol.id}" class="btn btn-info"
                                                 role="button">delivered</a>
                        </div>
                    </c:if>

                    <c:if test="${ol.deliveryStatus == 'shipped'}">
                        <div class="col-md-2"><a href="sellerOrders?ds=not processed&ID=${ol.id}" class="btn btn-info"
                                                 role="button">not Processed</a></div>

                        <div class="col-md-2"><a href="sellerOrders?ds=shipped&ID=${ol.id}" class="btn btn-success"
                                                 role="button">
                            shipped </a></div>
                        <div class="col-md-2"><a href="sellerOrders?ds=delivered&ID=${ol.id}" class="btn btn-info"
                                                 role="button">delivered</a></div>
                    </c:if>

                    <c:if test="${ol.deliveryStatus == 'delivered'}">
                        <div class="col-md-2"><a href="sellerOrders?ds=not processed&ID=${ol.id}" class="btn btn-info"
                                                 role="button">not Processed</a></div>
                        <div class="col-md-2"><a href="sellerOrders?ds=shipped&ID=${ol.id}" class="btn btn-info"
                                                 role="button">
                            shipped </a></div>
                        <div class="col-md-2"><a href="sellerOrders?ds=delivered&ID=${ol.id}" class="btn btn-success"
                                                 role="button">delivered</a></div>
                    </c:if>
                </div>
            </c:forEach>
        </c:if>


        <c:if test="${empty orderList}">
            <div class="row">
                <c:if test="${ds!=null}">
                    <h3>You have not orders in category "${ds}"</h3><br/>
                </c:if>
                <c:if test="${ds==null}">
                    <h3>You have not orders in category "Not Processed"</h3><br/>
                </c:if>
                <br/>
                <img src="<c:url value="/resources/core/img/idk.jpg" />" width="275"
                     height="200" alt="TestDisplay"/>
            </div>
        </c:if>
    </div>
</div>


