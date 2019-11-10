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

<div class="container">
<div class="jumbotron">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Admin Panel : Welcome <mark>${user}</mark>  <a href="<c:url value="/j_spring_security_logout" />"><span class="glyphicon glyphicon-log-out"></span>
						Logout</a>
        </h2>
    </c:if>
    </div>
    <h2> <a href="admin/allusers">All Customers</a></h2>
    <h2> <a href="admin/allemployee">All Employee</a></h2>
    <h2><a href="admin/addemployee">Add Employee</a></h2>
    <h2><a href="admin/wishlistdemand">View Wishlist Demand</a></h2>
    <h2><a href="admin/getmessages">View Anonymous Messages</a></h2>
    <h2><a href="admin/appointments">Appointments</a></h2>
    <h2> <a href="admin/allservices">All Services</a></h2>
    <h2><a href="admin/addservices">Add  Services</a></h2>
    <h2><a href="admin/makebill">Make bill</a></h2>
    </div>
</body>
</html>
