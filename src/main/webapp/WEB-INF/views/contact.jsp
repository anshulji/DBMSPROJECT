<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
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
<body>
	
	
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
				<li><a href="home">Home</a></li>
				<li><a href="wishlist">Wishlist</a></li>
				<li><a href="services">Services</a></li>
				<li><a href="blog">Blog</a></li>
				<li class="active"><a href="/contact">Contact</a></li>
				<li><a href="products">Products</a></li>
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

                                                
	<!-- Hero section -->

		<img src="<c:url value="/resources/img/back.png" />" style="width:100%;" alt="">

	<!-- Hero section end -->

<!-- Contact section -->
	<section class="contact-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 contact-content">
					<h2 class="contact-title">Diva Beatuy Salon</h2>
					<p>At the Beauty Parlour, we believe in beauty with a conscience. We have created a salon that offers the highest quality hair services in a setting that is healthier for the environment, our guests and our staff.</p>
					<div class="ci-item">
						<div class="ca-icon">
							<img src="<c:url value="/resources/img/icons/map.png" />" alt="">
						</div>
						<div class="ca-text">Sector 40, Mahalaxmi Nagar<br>Indore (M.P.)</div>
					</div>
					<div class="ci-item">
						<div class="ca-icon">
							<img src="<c:url value="/resources/img/icons/phone.png" />"alt="">
						</div>
						<div class="ca-text">+91 7987936958</div>
					</div>
				</div>
				<div class="col-lg-6">
					<h2 class="contact-title">Get in Touch</h2>
					<form:form class="contact-form" action="/submitmessage" method="post" modelAttribute="message">
						<div class="row">
							<div class="col-md-6">
								<form:input type="text" path="name" placeholder="Your Name" required="true"/>
							</div>
							<div class="col-md-6">
								<form:input type="text" path="email" placeholder="Your E-mail" required="true"/>
							</div>
							<div class="col-md-12">
								<form:input type="text" path="subject" placeholder="Subject" required="true"/>
								<form:textarea path="message" placeholder="Your Message" required="true"/>
								<button class="site-btn">Submit</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
			<div class="map-area" id="map-canvas"> 
			<img src="<c:url value="/resources/images/map.png" />" style="width:90%;" alt="">
			</div>
		</div>
	</section>
	<!-- Contact section end -->


					<div class="copyright" style="background-color:black;">
					<p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved 
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
				</div>
	
    </body>
</html>