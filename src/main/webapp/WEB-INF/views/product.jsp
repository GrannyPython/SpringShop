<%@ include file="panel.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<br>
    <div class="container text-capitalize text-center" >
        <div class="row">
            <div class="col-md-4 ">
                Product Name
            </div>
            <div class="col-md-4 ">
                ${product.product.name}
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 ">
                Price
            </div>

            <div class="col-md-4 ">
                ${product.price}
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 ">
                quantity
            </div>
            <div class="col-md-4 ">
                ${product.amount}
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 ">
                Description
            </div>
            <div class="col-md-4 ">
                ${product.description}
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 ">
                Rating
            </div>
            <div class="col-md-4 ">
                ${product.rating}
            </div>
        </div>

        <form action="buy" method="post">
            <div class="col-md-4 " >
            <input type="number" name="amount" min="1"
                   max="${product.amount}" value="1" class="form-control" placeholder="quantity">
            </div>
            <div class="col-md-4 ">
                <input type="submit" value="Buy!" class="btn btn-lg btn-success btn-sm">
            </div>
        </form>
    </div>
