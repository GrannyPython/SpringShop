<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="panel.jsp" %>


<div class="container">
    <div class="row" style="margin-top:20px">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <c:if test="${not empty error}">
                <div class="alert alert-danger" role="alert">
                    <p class="text-center"><h4>${error}</h4></p>
                </div>
            </c:if>
            <c:if test="${empty error}">
                <div class="alert alert-info" role="alert">
                    <p class="text"><h4>Please, visit you mail</h4></p>
                </div>
            </c:if>

            <form action="${registrationConfirm}" method="POST" role="form" class="form-horizontal">
                <fieldset>
                    <div class="form-group">
                        <input type="text" name="emailcode" class="form-control input-lg" placeholder="Write your code here ">
                        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                    </div>
                    <p class="lead">Please, confirm your password</p>
                </fieldset>
                <div class="col-xs-12 col-md-6">
                    <input type="submit" value="Check" class="btn btn-primary btn-block btn-lg"></div>
            </form>
        </div>
    </div>
</div>


