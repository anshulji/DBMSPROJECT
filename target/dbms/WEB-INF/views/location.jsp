 <%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="/dbms/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Location</title>
</head>
<body  style="background: #ffe6e6">
<img alt="" src='<c:url value="/resources/Screenshot(1).png"></c:url>'> 
<nav class="navbar navbar-inverse navbar-fixed-top"
		style="background: #ffcccc !important">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">RANJAN DECORATORS</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="/dbms/user"><span class="glyphicon glyphicon-home"></span>HOME</a></li>
				<li><a href="/dbms/allcat">CATEGORIES</a></li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
			<li><a href="/dbms/buyitem/cart"><span class="glyphicon glyphicon-shopping-cart"></span>CART</a></li>
				<li><c:if test="${pageContext.request.userPrincipal.name != null}">
					 <a href="<c:url value="/j_spring_security_logout" />"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a>
				</c:if></li>
			</ul>
		</div>
	</nav>
	<br>
	<br>
	<br>
<div class="container">
<form action="getlocation" class="form-inline">
<fieldset>
    <legend>Choose date</legend>

    <div>
        <label for="">Date</label>
        <input type="date"  name="bdate"
               min="${date }" ,max="2018-12-31" required="required" />
    </div>

</fieldset>


<input value="Submit" type="submit" class="btn btn-success">
</form>
<div class="list-group">
<h2>ALL LOCATIONS</h2>
<c:forEach items="${list }" var="loc">
<li class="list-group-item">Name: ${loc.lname } <br> Price: ${loc.price } <br> Address: ${loc.address }</li>
<br>
<br>
</c:forEach> 
</div>
<script src="/dbms/webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="/dbms/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>