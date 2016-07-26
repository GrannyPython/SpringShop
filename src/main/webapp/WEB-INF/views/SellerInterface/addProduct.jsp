<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../panel.jsp" %>


<div class="container center-block">
    <br/>
    <form:form class="form-horizontal" method="post" modelAttribute="productForm" action="${addProduct}">

        <div class="row">
            <label class="col-sm-2 control-label">Name</label>
            <div class="col-sm-10">
                <input name="name" path="name" type="text" class="form-control" id="name" placeholder="Name" required/>
            </div>
            <br/>
        </div>

        <div class="row">
            <label class="col-sm-2 control-label">Categories</label>
            <div class="col-sm-5">
                <form:select path="category" class="form-control" items="${categories}"
                             size="${fn:length(categories)}" required="true"/>
                <div class="col-sm-5"></div>
            </div>
        </div>
        <br/>

        <div class="row">
            <label class="col-sm-2 control-label">Quantity</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="amount" required>
            </div>
            <br/>
        </div>

        <div class="row">
            <label class="col-sm-2 control-label">Price</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" name="price" required>
            </div>
            <br/>
        </div>

        <div class="row">
            <label class="col-sm-2 control-label">Description</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="description" required>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn-lg btn-primary">Add Product</button>
            </div>
        </div>

    </form:form>
</div>