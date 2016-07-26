<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../panel.jsp" %>

<form:form method="POST" class="form-signin" modelAttribute="acForm">

    <div class="container text-center">
        <div class="row ">
            <div class="col-md-6">
                <h4>Name</h4>
            </div>

            <div class="col-md-6">
                <p>
                    <input type="text" class="form-control"  name="name" value="${user.name}" minlength=3 required>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <h4>Surname: </h4>
            </div>
            <div class="col-md-6">
                <p>
                    <input type="text" name="surname" class="form-control"  value="${user.surname}" minlength="3" required>
                </p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <h4>Phone: </h4>
            </div>
            <div class="col-md-6">
                <p>
                    <input type="text" name="phone" class="form-control"  value="${user.phone}" minlength="3" required>
                </p>
            </div>
        </div>


        <c:if test="${user.role == '2'}">
            <div class="row">
                <div class="col-md-6">
                    <h4>City: </h4>
                </div>
                <div class="col-md-6">
                    <p>
                        <input type="text" name="city" class="form-control"  value="${user.city}" minlength="3">
                    </p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <h4>Country:</h4>
                </div>
                <div class="col-md-6">
                    <p>
                        <input type="text" name="country" class="form-control"  value="${user.country}" required>
                    </p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <h4>PostalPin:</h4>
                </div>
                <div class="col-md-6">
                    <p>
                        <input type="text" name="postalPin" class="form-control"  value="${user.postalPin}" minlength="6">
                    </p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <h4>Street: </h4>
                </div>
                <div class="col-md-6">
                    <p>
                        <input type="text" name="street" class="form-control"  value="${user.street}" minlength="3">
                    </p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <h4> House: </h4>
                </div>
                <div class="col-md-6">
                    <p>
                        <input type="text" name="house" class="form-control"  value="${user.house}" required>
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <h4>Flat Number: </h4>
                </div>
                <div class="col-md-6 center-block">
                    <p>
                        <input type="text" name="flat" class="form-control"  value="${user.flat}" required>
                    </p>
                </div>
            </div>
        </c:if>

        <input class="btn btn-lg btn-primary" type="submit" value="Update Profile">
    </div>
</form:form>
</body>
</html>
