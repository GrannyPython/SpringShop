<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>  <meta charset="utf-8">
</head>
<body>

<%@ include file="panel.jsp" %>

<div class="container">



    <div class="row" style="margin-top:20px">

        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <c:if test="${not empty error}">
                <div class="alert alert-warning" role="alert">
                    <p class="text-center"><h4>${error}</h4></p>
                </div>
            </c:if>
            <c:if test="${not empty message}">
                <div class="alert alert-info" role="alert">
                    <p class="text-center"><h4>${message}</</p>
                </div>
            </c:if>

            <form action="${login}" method="POST" role="form" class="form-horizontal">
                <fieldset>
                    <h2>Please Sign In</h2>

                    <div class="form-group">
                        <input type="email" name="email" class="form-control input-lg" placeholder="Email Address" value="${email}" required>
                    </div>

                    <div class="form-group">
                        <input type="password" name="password" class="form-control input-lg" placeholder="Password" <%--required--%>>
                    </div>

                    <hr class="colorgraph">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Sign In">
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <a href="${registration}" class="btn btn-lg btn-primary btn-block">Register</a>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </fieldset>
            </form>
        </div>
    </div>
</div>









<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>

<%--<c:set var="contextPath" value="${pageContext.request.contextPath}"/>--%>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->--%>
    <%--<title>Log in with your account</title>--%>

    <%--<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link href="${contextPath}/resources/css/common.css" rel="stylesheet">--%>

    <%--<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->--%>
    <%--<!--[if lt IE 9]>--%>
    <%--<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>--%>
    <%--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>--%>
    <%--<![endif]-->--%>
<%--</head>--%>

<%--<body>--%>

<%--<div class="container">--%>
    <%--<form method="POST" action="${contextPath}/login" class="form-signin">--%>
        <%--<h2 class="form-heading">Log in</h2>--%>

        <%--<div class="form-group ${error != null ? 'has-error' : ''}">--%>
            <%--<span>${message}</span>--%>
            <%--<input name="username" type="text" class="form-control" placeholder="Username"--%>
                   <%--autofocus="true"/>--%>
            <%--<input name="password" type="password" class="form-control" placeholder="Password"/>--%>
            <%--<span>${error}</span>--%>
            <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

            <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>--%>
            <%--<h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>--%>
        <%--</div>--%>

    <%--</form>--%>

<%--</div>--%>
<%--<!-- /container -->--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
<%--<script src="${contextPath}/resources/js/bootstrap.min.js"></script>--%>
<%--</body>--%>
<%--</html>--%>
