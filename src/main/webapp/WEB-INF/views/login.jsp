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
				<li><a href="/dbms/appointment">Book Appointment</a></li>
				
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
<% 
Principal principal=request.getUserPrincipal();
if(principal!=null)
{
// out.println("<form action=\"login\"><input type=\"submit\" value=\"Login\"><form>");
response.sendRedirect("home");
return;
}
%>
	<br><br>
	
				<%
					String errorString = (String) request.getAttribute("error");
					if (errorString != null && errorString.trim().equals("true")) {
						out.println("<span class=\"errorblock\">Incorrect login name or password. Please try again");
					}
				%>
	
	<div class="col-lg-6" style="width: 100%; margin: 0 auto;">
					<h2 class="contact-title">Login</h2>
					<form:form class="contact-form" action="/dbms/login" method="post" modelAttribute="user">
						<div class="row" >
							<div class="col-md-6">
								<form:input type="text" path="username" placeholder="Username" required="true"/>
							</div>
							<div class="col-md-6">
								<form:input type="password" path="password" placeholder="Password" required="true"/>
							</div>
							
							<div class="col-md-12">	
								<button class="site-btn">Login</button>
							</div>
						</div>
					</form:form>
					<br><br>
					<h2  class="contact-title">If not registered, click below button</h2>
					<form action="register" class="contact-form">
						<div class="col-md-12">	
								<button class="site-btn">Register</button>
						</div>
					</form>
				</div>
	</div>

	<div>
		<section class="contact-section spad">
			<div class="container" style="width: 50%; margin: 0 auto;" >

			
	
			</div>
		</section>
	</div>
	
	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>