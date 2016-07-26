<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../panel.jsp" %>


<div class="container center-block" >
    <form action="${addProductParams}" method="post" enctype="multipart/form-data">

        <c:forEach var="item" items="${productForm.category.parameters}">
            <div class="row">
                <div class="col-md-2">
                    <p>${item.name}: </p>
                </div>
                <div class="col-md-2">
                    <input type="text" name="myValues" required>
                    <input type="hidden" value="${item.name}" name="myParams">
                </div>
            </div>
        </c:forEach>



    <div class="row">
        <div class="col-md-2">
            <p>Photo:</p>
        </div>
        <div class="col-md-2">
            <input type="file" name="imageData"/>

        </div>
    </div>

    <input type="submit" value="Add">
    </form>
</div>
