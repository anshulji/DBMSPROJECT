<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<%@ page isELIgnored="false"%>
<%@ page import="java.security.Principal" %>
<%@ page import="org.springframework.security.core.authority.AuthorityUtils" %>
<%@page session="true"%>
	
<%@ page isELIgnored="false"%>
<html lang="zxx">
<head>
	<title>Diva - Beauty salon</title>
	<meta charset="UTF-8">
	<meta name="keywords" content="diva, beauty, creative, html">
	<!-- Favicon -->   
	<link href="<c:url value="/resources/img/favicon.ico" />" rel="shortcut icon"/>

	<!-- Stylesheets -->
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css" />"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.min.css" />"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/flaticon.css" />"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/owl.carousel.css" />"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/animate.css" />"/>


	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

</head>
<body onload='document.loginForm.j_username.focus()'>	
	
	<!-- Header section -->
	<header class="header-section">
		<div class="header-warp">
			<!-- logo -->
			<a href="home.html" class="site-logo">
				<img src="<c:url value="/resources/img/logo.png" />" alt="">
			</a>
			<!-- responsive -->
			<div class="nav-switch">
				<i class="fa fa-bars"></i>
			</div>
			<!-- Navigation Menu -->
			<ul class="main-menu">
				<li><a href="/dbms/home">Home</a></li>
				<li><a href="/dbms/wishlist">Wishlist</a></li>
				<li><a href="/dbms/services">Services</a></li>
				<li><a href="/dbms/blog">Blog</a></li>
				<li><a href="/dbms/contact">Contact</a></li>
				<li><a href="/dbms/products">Products</a></li> 
				<li class="active"><a href="/dbms/appointment">Book Appointment</a></li>
				
			</ul>
			<div class="header-right">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
				<li><a href="<c:url value="/j_spring_security_logout" />" class="site-btn sb-small">
						Logout</a></li>
						</c:if>
				<c:if test="${pageContext.request.userPrincipal.name == null}" >
				<li><a href="<c:url value="login" />" class="site-btn sb-small">
						Login</a></li>
						</c:if>
			</div>
		</div>
	</header>
	<!-- Header section end -->
<br>
<div class="col-lg-6" style="width: 100%; margin: 0 auto;">
	<form:form method="post" modelAttribute="appointment" action="/dbms/appointment">
            <label for="">Date</label>
            <br>
            <form:input type="text" class="form-control" path="date" placeholder="yyyy/mm/dd" required="true"/>
         
			<br>			
			<label for="">Start Time</label>
			<br>
				<form:input path="start_time" type="text" class="form-control" placeholder="hh:mm:ss" required="true"/>
		
			<br>
			
			
			<label for="">Home Or Shop</label>
			<br>
				<form:input path="home_or_shop" type="text" class="form-control" placeholder="H/S" required="true"/>
			<br>
			
			<button type="submit" class="btn btn-primary">Submit</button>
				
				<td>${error}</td>
			
	</form:form>
	<br><br>
	<h2>Past Appointments</h2>
	<div class="container">
		<table class="table table-striped">
			<thead>
		      <tr>
		        <th>Date</th>
		        <th>Time</th>
		        <th>Home/Shop</th>
		        <th>Status</th>
		        <th>Amount</th>
		      </tr>
		    </thead>
		    <tbody>
		    
		    <c:forEach items="${list }" var="item">
		    <tr>
		    <td>${item.getDateString() }</td>
		    <td>${item.start_time }</td>
		    <td>${item.home_or_shop }</td>
		    <td>${item.status_name }</td>
		    <td>${item.amount }</td>
		    </tr>
		    </c:forEach>
		    </tbody>
		</table>
	</div>
	</div>
	
	
	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>