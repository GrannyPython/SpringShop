<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../panel.jsp" %>

<div class="list-group">
    <div class="container ">
        <h3 class="text-center text-capitalize text-primary ">
            Information about user
        </h3>
        <br/>

        <div class="row">
            <div class="col-md-6 text-capitalize text-center">
                <h4 class="text-capitalize">Name</h4>
            </div>
            <div class="col-md-6  text-center">
                <p>${user.name}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 text-center text-capitalize">
                <h4 class="text-capitalize">Surname</h4>
            </div>

            <div class="col-md-6 text-center text-capitalize">
                <p>${user.surname}</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 text-center text-capitalize">
                <h4 class="text-capitalize">Phone</h4>
            </div>
            <div class="col-md-6 text-center text-capitalize">
                <p>${user.phone}</p>
            </div>
        </div>
        <c:if test="${user.role == '2'}">
            <div class="row">
                <div class="col-md-6 text-center text-capitalize">
                    <h4 class="text-capitalize">City</h4>
                </div>
                <div class="col-md-6 text-center text-capitalize">
                    <p>${user.city}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 text-center text-capitalize">
                    <h4 class="text-capitalize">Country</h4>
                </div>
                <div class="col-md-6 text-center text-capitalize">
                    <p>${user.country}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 text-center text-capitalize">
                    <h4 class="text-capitalize">Postal Pin</h4>
                </div>
                <div class="col-md-6 text-center text-capitalize">
                    <p>${user.postalPin}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 text-center text-capitalize">
                    <h4 class="text-capitalize">Street</h4>
                </div>
                <div class="col-md-6 text-center text-capitalize">
                    <p>${user.street}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 text-center text-capitalize">
                    <h4 class="text-capitalize">House</h4>
                </div>
                <div class="col-md-6 text-center text-capitalize">
                    <p>${user.house}</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 text-center text-capitalize">
                    <h4 class="text-capitalize">Flat Number</h4>
                </div>
                <div class="col-md-6  text-capitalize text-center">
                    <p>${user.flat}</p>
                </div>
            </div>
        </c:if>

        <div class="col-md-6 text-center text-capitalize">
            <form action="${changePassword}" method="get">
                <input type="submit" value="Change Password" class="btn btn-lg btn-danger btn-lg">
            </form>
        </div>
        <div class="col-md-6 text-center text-capitalize">
            <form action="${accountUpdate}" method="get">
                <input type="submit" value="Update Profile" class="btn btn-lg btn-info btn-lg">
            </form>
        </div>
    </div>
</div>
