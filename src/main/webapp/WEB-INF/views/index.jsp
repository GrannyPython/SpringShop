<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:url var="last" value="${deploymentLog.totalPages}"/>
<c:url var="prev" value="${currentIndex - 1}"/>
<c:url var="next" value="${currentIndex + 1}"/>

<title>Shop Homepage</title>

<%@ include file="panel.jsp" %>


<div class="container">
    <div class="row">
        <div class="col-lg-3">

            <div class="img-responsive">
                <img src="<c:url value="/resources/core/img/afa6de318de6b3f285b782814beeae08.png" />" width="258.75"
                     height="250" alt="TestDisplay"/>
            </div>
            <br/>
            <div class="list-group">
                <c:if test="${not empty categoryList}">
                    <c:forEach var="item" items="${categoryList}">
                        <c:if test="${not empty category}">

                            <c:if test="${item.name == category}">
                                <a href="index?category=${item.name}&page=1"
                                   class="list-group-item list-group-item-success"> ${item.name} </a>
                            </c:if>
                            <c:if test="${item.name != category}">
                                <a href="index?category=${item.name}&page=1" class="list-group-item"> ${item.name} </a>
                            </c:if>
                        </c:if>
                        <c:if test="${empty category}">
                            <a href="index?category=${item.name}&page=1" class="list-group-item"> ${item.name} </a>
                        </c:if>
                    </c:forEach>
                </c:if>
            </div>
        </div>


        <div class="col-lg-9">
            <form action="${index}" method="get">
                <div class="row">
                    <div class="col-lg-8 input-lg">
                        <input type="text" name="product" class="form-control" placeholder="Find product">

                        <c:if test="${by != 'ByRating'}">
                            <div class="radio-inline">
                                <input type="radio" name="by" value=ByRating> By Rating
                            </div>
                            <div class="radio-inline">
                                <input type="radio" name="by" value=ByPrice checked> By Price
                            </div>
                        </c:if>

                        <c:if test="${by == 'ByRating'}">
                            <label>
                                <div class="radio-inline">
                                    <input type="radio" name="by" value=ByRating checked> By Rating
                                </div>
                            </label>
                            <div class="radiio-inline">
                                <label><input type="radio" name="by" value=ByPrice> By Price</label>
                            </div>
                        </c:if>
                    </div>

                    <input type="submit" value="Find" class="btn btn-lg btn-info btn-lg">
                </div>
            </form>


            <div class="row">
                <c:if test="${not empty productList}">
                    <c:forEach var="warehouse" items="${productList}">
                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail ">
                                <div class="g-block">
                                    <img class="g-item" src="<c:url value="imageDisplay?path=${warehouse.product.image}" />"/>
                                </div>
                                <div class="caption prod-caption text-center">
                                    <h4 class="text-primary text-center">${warehouse.product.name}</h4>
                                    </br>

                                    <div class="btn-group ">
                                        <a href="#" class="btn btn-default">$ ${warehouse.price}</a>
                                        <c:if test="${user.role != '1'}">
                                            <spring:url value="/buyProduct/${warehouse.id}" var="buy"/>
                                            <a href="${buy}" class="btn btn-success">Buy
                                                <span class="glyphicon glyphicon-plus" style="font-size:1em; "
                                                      aria-hidden="true"/>
                                            </a>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </div>
    <div class="row text-center">
        <nav>
            <ul class="pagination pagination-lg">
                <c:choose>
                    <c:when test="${currentIndex != 1}">
                        <li><a href="index?page=${prev}">&lt;</a></li>
                    </c:when>
                </c:choose>

                <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                    <c:choose>
                        <c:when test="${i == currentIndex}">
                            <li class="active"><a href="index?page=${i}"><c:out value="${i}"/></a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="index?page=${i}"><c:out value="${i}"/></a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:choose>
                    <c:when test="${currentIndex < page.totalPages}">
                        <li><a href="index?page=${next}">&gt;</a></li>
                    </c:when>
                </c:choose>
            </ul>
        </nav>
    </div>
</div>




