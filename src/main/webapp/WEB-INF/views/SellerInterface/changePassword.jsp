<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../panel.jsp" %>


<div class="container">
    <div class="row" style="margin-top:20px">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3 text-center">
            <form action="${changePassword}" method="POST" role="form" class="form-horizontal">
                <fieldset>
                    <div class="form-group">
                        <h2>Change your password</h2><br>
                        <input type="text" name="newPassword" class="form-control input-lg" placeholder="Check your Email" minlength="8">
                    </div>
                    <p class="lead">You will get new password by email</p>
                </fieldset>

                <div class="col-xs-12 col-md-6">
                    <input type="submit" value="Change" class="btn btn-primary btn-block btn-lg">
                </div>
                <div class="col-xs-12 col-md-6">
                    <a href="${account}" class="btn btn-lg btn-warning btn-block">Cancel</a>
                </div>


            </form>
        </div>
    </div>
</div>


