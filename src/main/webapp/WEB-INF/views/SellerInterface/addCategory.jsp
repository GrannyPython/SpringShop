<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../panel.jsp" %>

<div class="container">
    <div class="col-md-12">
        <div class="row">
            <div class="col-md-6">
                <h4 class="text-center">Create category</h4>

                <form:form class="form-horizontal" method="post" modelAttribute="categoryForm"
                           action="${addCategory}">

                    <div class="row">
                        <label class="col-md-4">Category Name</label>

                        <div class="col-md-8">
                            <form:input path="name" type="text" class=" form-control"
                                        id="name" placeholder="Name" required="true"/>
                        </div>
                    </div>

                    <div class="row">
                        <label class="col-md-4">Parameters</label>

                        <form:select path="parameters" multiple="true" items="${parameters}"
                                     size="${fn:length(parameters)}" required="true"/>
                        <div class="col-md-8"></div>
                    </div>

                    <input type="submit" class="btn btn-md text-center btn-primary" value="Add Category">
                </form:form>
            </div>


            <div class="col-md-6">
                <h4 class="text-center">Create parameter</h4>

                <form action="${addParameter}" method="post">
                    <div class="row">
                        <label class="col-md-4">Parameter Name:</label>

                        <div class="col-md-8">
                            <input type="text" class="form-control text-center" name="parameterName" required>
                        </div>
                    </div>
                    <input type="submit" class="text-center btn btn-primary btn-md" value="Add Parameter">
                </form>
            </div>
        </div>
    </div>
</div>
