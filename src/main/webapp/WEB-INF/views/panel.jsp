<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link type="text/css" rel="stylesheet" href="<c:url value="/resources/core/css/custom.css" />" />
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/core/css/bootstrap.css" />" />
<script src="<c:url value="/resources/core/js/bootstrap.js"/>"></script>

<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script src="<c:url value="/resources/core/js/bootstrap-datepicker.js"/>"></script>

<%--<script src="<c:url value="/resources/core/js/locales/bootstrap-datepicker.de.js"/>"></script>--%>


<spring:url value="/" var="index" />

<spring:url value="/warehouse" var="warehouse" />
<spring:url value="/cart" var="cart" />
<spring:url value="/userOrders" var="userOrders" />
<spring:url value="/logout" var="logout" />
<spring:url value="/login" var="login" />
<spring:url value="/registration" var="registration" />
<spring:url value="/registrationConfirm" var="registrationConfirm" />
<spring:url value="/cart" var="cart" />

<spring:url value="/account" var="account" />
<spring:url value="/account/update" var="accountUpdate" />
<spring:url value="/account/changePassword" var="changePassword" />

<spring:url value="/warehouse/addCategory" var="addCategory" />
<spring:url value="/warehouse/addProduct" var="addProduct" />
<spring:url value="/warehouse/addProductParams" var="addProductParams" />
<spring:url value="/warehouse/addParameter" var="addParameter" />

<spring:url value="/sellerOrders" var="sellerOrders" />
<spring:url value="/userOrders" var="userOrders" />



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<nav class="navbar">
    <div class="container" style="background-color: #4ea6bc">
        <div class="navbar-left"><a class="navbar-brand" href="${index}">Main Page</a></div>

        <sec:authorize access="hasAuthority('2')">
            <a class="navbar-brand" href="${account}">Account</a>
            <a class="navbar-brand" href="${userOrders}">My Orders</a>
            <div class="navbar-brand navbar-right">
                <a href="${cart}"><span class="glyphicon glyphicon-shopping-cart" style="color:white;
                font-size:1.5em; "aria-hidden="true"/></a>
            </div>

            <div class=" navbar-right"><a class="navbar-brand" href="${logout}">Exit</a></div>
        </sec:authorize>

        <sec:authorize access="hasAuthority('1')">
            <a class="navbar-brand" href="${account}">SellerAccount</a>
            <a class="navbar-brand" href="${warehouse}">Warehouse</a>
            <a class="navbar-brand" href="${sellerOrders}">User Tasks</a>
            <div class="navbar-right"> <a class="navbar-brand" href="${logout}">Exit</a> </div>
        </sec:authorize>

        <sec:authorize access="hasAuthority('ROLE_ANONYMOUS')">
            <a class="navbar-brand" href="${registration}">Registration</a>
            <a class="navbar-brand" href="${login}">Login</a>
            <div class="navbar-brand navbar-right lg"><a href="${cart}">
                <span class="glyphicon glyphicon-shopping-cart" style="color:white;  font-size:1.5em;"  aria-hidden="true"/></a></div>
        </sec:authorize>
    </div>
</nav>
