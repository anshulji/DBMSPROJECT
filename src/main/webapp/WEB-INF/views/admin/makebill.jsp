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
	<nav class="navbar navbar-inverse navbar-fixed-top" style="background: #3366cc !important">
		<div class="container-fluid">
			
			<ul class="nav navbar-nav">
				<li><a href="/dbms/admin">Home</a></li>
				
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value="/j_spring_security_logout" />"><span class="glyphicon glyphicon-log-out"></span>
						Logout</a></li>
			</ul>
		</div>
	</nav>
<br>
<div class="col-lg-6" style="width: 100%; margin: 0 auto;">
	<form:form method="post" modelAttribute="prod_bill" action="/dbms/admin/makebill">
            <label for="">Enter Customer Username</label>
			<br>
				<form:input path="username" type="text" class="form-control" required="true"/>
			<br>
			<button type="submit" class="btn btn-primary">Submit</button>
				
				<td>${error}</td>
			
	</form:form>
	</div>
	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>