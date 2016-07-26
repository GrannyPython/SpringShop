<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/shop-homepage.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ include file="panel.jsp" %>
        <div class="row">
            <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">

                <c:if test="${not empty error}">
                    <div class="alert alert-success" role="alert">
                        <p class="text-center"><h4>${error}</h4></p>
                    </div>
                </c:if>
                <c:if test="${not empty message}">
                    <div class="alert alert-info" role="alert">
                        <p class="text-center"><h4>${message}</h4></p>
                    </div>
                </c:if>

                <form:form method="POST" class="form-signin" id="register-form" novalidate="novalidate" modelAttribute="userForm">
                    <h2>Please Sign Up</h2>
                    <hr class="colorgraph">
                    <div class="row">
                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <spring:bind path="name">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="name" class="form-control" id="name" placeholder="Name" autofocus="true"  required="true" value="${userForm.name}" ></form:input>
                                    <form:errors path="name"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <spring:bind path="surname">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="surname" class="form-control" id="surname" placeholder="Surname" value="${userForm.surname}"  autofocus="true"></form:input>
                                    <form:errors path="surname"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12 col-sm-6 col-md-6">
                        <spring:bind path="email">
                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                <form:input type="email" path="email" class="form-control" placeholder="Email Address" value="${userForm.email}"  autofocus="true" ></form:input>
                                <form:errors path="email"></form:errors>
                            </div>
                        </spring:bind>
                        </div>

                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <spring:bind path="phone">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="phone" class="form-control" placeholder="Phone" value="${userForm.phone}" autofocus="true"></form:input>
                                    <form:errors path="phone"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <spring:bind path="password">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="password" path="password" class="form-control" placeholder="Password" value="${userForm.password}" autofocus="true"></form:input>
                                    <form:errors path="password"></form:errors>
                                </div>
                            </spring:bind>
                        </div>

                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <spring:bind path="passwordConfirm">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="password" path="passwordConfirm" class="form-control" placeholder="Confirm your password" value="${userForm.passwordConfirm}"></form:input>
                                    <form:errors path="passwordConfirm"></form:errors>
                                </div>
                            </spring:bind>
                        </div>

                        <div class="col-xs-12 col-sm-6 col-md-6">

                            <spring:bind path="date">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="date" name="date" id="example1" path="date" class="form-control" placeholder="Date" value="${userForm.date}"></form:input>
                                    <form:errors path="date"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <spring:bind path="country">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="country" class="form-control" value="${userForm.country}"  placeholder="Country"  autofocus="true"></form:input>
                                    <form:errors path="country"></form:errors>
                                </div>
                            </spring:bind>
                        </div>

                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <spring:bind path="city">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="city" class="form-control" value="${userForm.city}"  placeholder="City" autofocus="true"></form:input>
                                    <form:errors path="city"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <spring:bind path="street">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="street" class="form-control" placeholder="Street" value="${userForm.street}" autofocus="true"></form:input>
                                    <form:errors path="street"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <spring:bind path="house">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="house" class="form-control" placeholder="House" value="${userForm.house}" autofocus="true"></form:input>
                                    <form:errors path="house"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <spring:bind path="flat">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="flat" class="form-control" placeholder="Flat" value="${userForm.flat}" autofocus="true"></form:input>
                                    <form:errors path="flat"></form:errors>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <spring:bind path="postalPin">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="text" path="postalPin" class="form-control" value="${userForm.postalPin}" placeholder="postal Pin" autofocus="true"></form:input>
                                    <form:errors path="postalPin"></form:errors>
                                </div>
                            </spring:bind>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <div class="form-group">
                                <label class="checkbox-inline">
                                    <input type="radio" name="role" value="1" checked>Seller
                                    <input type="radio" name="role" value="2"> Customer
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <input type="submit" value="Register" class="btn btn-primary btn-block btn-lg"></div>
                        <div class="col-xs-12 col-md-6">
                            <a href="${login}" class="btn btn-success btn-block btn-lg">Sign In</a></div>
                    </div>
                </form:form>
            </div>
        </div>


    <script type="text/javascript">
        // When the document is ready
        $(document).ready(function () {
            $('#example1').datepicker({
                format: "dd/mm/yyyy"
            });

        });
    </script>


<%--<form action="" method="post" id="register-form" novalidate="novalidate">--%>

    <%--<div class="label">First Name</div><input type="text" id="firstname" name="firstname" /><br />--%>
    <%--<div class="label">Last Name</div><input type="text" id="lastname" name="lastname" /><br />--%>
    <%--<div class="label">Email</div><input type="text" id="email" name="email" /><br />--%>
    <%--<div class="label">Password</div><input type="password" id="password" name="password" /><br />--%>
    <%--<div style="margin-left:140px;"><input type="submit" name="submit" value="Submit" /></div>--%>
<%--</form>--%>

<%--<script>--%>

    <%--// When the browser is ready...--%>
    <%--$(function() {--%>

        <%--// Setup form validation on the #register-form element--%>
        <%--$("#register-form").validate({--%>

            <%--// Specify the validation rules--%>
            <%--rules: {--%>
                <%--name: "required",--%>
                <%--surname: "required",--%>
<%--//                email: {--%>
<%--//                    required: true,--%>
<%--//                    email: true--%>
<%--//                },--%>
<%--//                password: {--%>
<%--//                    required: true,--%>
<%--//                    minlength: 5--%>
<%--//                },--%>
<%--//                agree: "required"--%>
            <%--},--%>

            <%--// Specify the validation error messages--%>
            <%--messages: {--%>
                <%--firstname: "Please enter your first name",--%>
                <%--lastname: "Please enter your last name",--%>
<%--//                password: {--%>
<%--//                    required: "Please provide a password",--%>
<%--//                    minlength: "Your password must be at least 5 characters long"--%>
<%--//                },--%>
<%--//                email: "Please enter a valid email address",--%>
<%--//                agree: "Please accept our policy"--%>
            <%--},--%>

            <%--submitHandler: function(form) {--%>
                <%--form.submit();--%>
            <%--}--%>
        <%--});--%>

    <%--});--%>

<%--</script>--%>



