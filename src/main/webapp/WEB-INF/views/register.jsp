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
				<li><a href="/home">Home</a></li>
				<li><a href="/wishlist">Wishlist</a></li>
				<li><a href="/services">Services</a></li>
				<li><a href="/blog">Blog</a></li>
				<li><a href="/contact">Contact</a></li>
				<li><a href="/products">Products</a></li>
				<li><a href="/appointment">Book Appointment</a></li>
				
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
	<form:form method="post" modelAttribute="user" action="/register">
            <label for="">USERNAME</label>
            <br>
            <form:input type="text" class="form-control" path="username" placeholder="username" required="true"/>
            <form:errors path="username" />
			<br>			
			<label for="">PASSWORD</label>
			<br>
				<form:input path="password" type="password" class="form-control" placeholder="password" required="true"/>
				<!-- bind to user.name-->
				<form:errors path="password" />
			<br>
				<label for="">Confirm password</label>
				<br>
				<form:input path="mpassword" type="password" class="form-control" required="true" />
				<!-- bind to user.name-->
				<form:errors path="mpassword" />
		
			<br>
			
			<label for="">FIRST NAME</label>
			<br>
				<form:input path="cust_fname" type="text" class="form-control" placeholder="first name" required="true"/>
				<!-- bind to user.name-->
				<form:errors path="cust_fname" />
			
			<br>
			<label for="">MIDDLE NAME</label>
			<br>
				<form:input path="cust_mname" type="text" class="form-control" placeholder="middle name" required="true"/>
				<!-- bind to user.name-->
				<form:errors path="cust_mname" />
			
			<br>
			<label for="">LAST NAME</label>
			<br>
				<form:input path="cust_lname" type="text" class="form-control" placeholder="last name" required="true"/>
				<!-- bind to user.name-->
				<form:errors path="cust_lname" />
			
			<br>
			<label for="">EMAIL</label>
			<br>
				<form:input path="cust_email" type="email" class="form-control" placeholder="email" required="true"/>
				<!-- bind to user.name-->
				<form:errors path="cust_email" />
			
			<br>
	
			<label for="">PHONE</label>
			<br>
				<form:input path="cust_contact" type="text" class="form-control" placeholder="phone" required="true"/>
				<!-- bind to user.name-->
				<form:errors path="cust_contact" />
	
			<br>
			
			<label for="">GENDER</label>
			<br>
				<form:input path="cust_gender" type="text" class="form-control" placeholder="M/F" required="true"/>
				<!-- bind to user.name-->
				<form:errors path="cust_gender" />
	
			<br>
			<label for="">House No</label>
			<br>
				<form:input path="cust_houseno" type="text" class="form-control" placeholder="house no" required="true" />
				<!-- bind to user.name-->
				<form:errors path="cust_houseno" />
	
			<br>
			<label for="">Colony</label>
			<br>
				<form:input path="cust_colony" type="text" class="form-control" required="true" />
			<br>
			<label for="">City</label>
			<br>
				<form:input path="cust_city" type="text" class="form-control" required="true" />
			<br>
			<label for="">State</label>
			<br>
				<form:input path="cust_state" type="text" class="form-control" required="true" />
			<br>
			<label for="">Pincode</label>
			<br>
				<form:input path="cust_pincode" type="number" class="form-control" required="true" />
			<br>
			
			<button type="submit" class="btn btn-primary">Submit</button>
				
				<td>${error}</td>
			
	</form:form>
	</div>
	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>