<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../panel.jsp" %>

<div class="container text-center">
<div class="row">
    <h3 class="text-capitalize"> Change your product</h3>
</div>

    <form action="${warehouseEdit}" method="post">
        <div class="row">
            <div class="col-md-2">
                <h3>Name</h3>
            </div>
            <div class="col-md-10">
                <h3>
                    ${wh.product.name}
                </h3>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                <h4>Price: </h4>
            </div>
            <div class="col-md-10">
                <p>
                    <input type="text" name="price" class="input-lg" value="${wh.price}">
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                <h4>Amount: </h4>
            </div>
            <div class="col-md-10">
                <p>
                    <input type="text" name="amount" class="input-lg" value="${wh.amount}">
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
                <h4>Description: </h4>
            </div>
            <div class="col-md-10">
                <p>
                    <input type="text" class="input-lg" name="description" value="${wh.description}">
                </p>
            </div>
        </div>

        <input type="submit" class="btn-lg btn btn-success" value="Update Product Info">

    </form>
</div>