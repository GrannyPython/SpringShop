<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../panel.jsp" %>


<div class="container">
    <div class="col-md-12">
        <div class="row">
            <br/>
            <div class="col-md-6 text-center">
                <form action="${addProduct}" method="get">
                    <input type="submit" value="Create Product" class="bnt btn-success btn-lg">
                </form>
            </div>
            <div class="col-md-6 text-center">
                <form action="${addCategory}" method="get">
                    <input type="submit" value="Create Category" class="btn btn-success btn-lg">
                </form>
            </div>
        </div>

        <div class="row text-center">
            <div class="col-md-2"><p class="lead">Image</p></div>
            <div class="col-md-2"><p class="lead">Name</p></div>
            <div class="col-md-1"><p class="lead">Price</p></div>
            <div class="col-md-1"><p class="lead">Amount</p></div>
            <div class="col-md-2"><p class="lead">Description</p></div>

            <div class="col-md-2"><p class="lead">Edit</p></div>
            <div class="col-md-2"><p class="lead">Remove</p></div>

        </div>

        <c:forEach var="warehouse" items="${warehouseList}">
            <div class="row text-center">
                <div class="col-md-2 img-responsive">
                    <img src="<c:url value="imageDisplay?path=${warehouse.product.image}" />" width="75"
                         height="75"/>
                </div>
                <div class="col-md-2"><p class="lead">${warehouse.product.name}</p></div>
                <div class="col-md-1"><p class="lead">${warehouse.price}</p></div>
                <div class="col-md-1"><p class="lead">${warehouse.amount}</p></div>
                <div class="col-md-2"><p class="lead">${warehouse.description}</p></div>
                <spring:url value="/warehouse/edit/${warehouse.id}" var="editUrl"/>
                <spring:url value="/warehouse/remove/${warehouse.id}" var="removeUrl"/>

                <div class="col-md-2">
                    <a href="${editUrl}"><span style="font-size:1.5em;" class="glyphicon glyphicon-pencil"></span></a>
                </div>

                <div class="col-md-2">
                    <a href="${removeUrl}"><span style="font-size:1.5em;" class="glyphicon glyphicon-remove"></span></a>
                </div>


            </div>
        </c:forEach>
    </div>
</div>
