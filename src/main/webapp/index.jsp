<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page import="java.security.Principal" %>

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
				<li class="active"><a href="home">Home</a></li>
				<li><a href="/wishlist">Wishlist</a></li>
				<li><a href="/services">Services</a></li>
				<li><a href="/blog">Blog</a></li>
				<li><a href="/contact">Contact</a></li>
				<li><a href="/products">Products</a></li>
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


	<!-- intro section -->
	<section class="intro-section spad  set-bg" data-setbg="img/intro-bg.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-9">
					<div class="intro-content">
						<h2>Why Choose Us?</h2>
						<p>At the Beauty Parlour, we believe in beauty with a conscience. We have created a salon that offers the highest quality hair services in a setting that is healthier for the environment, our guests and our staff. The Beauty Parlour is designed and built primarily with recycled materials: the floor is made of reclaimed wood from a local grain elevator – preserving and showcasing its natural texture – and most of the fixtures and furniture are refurbished or original vintage pieces.

We carry high quality professional hair products designed to ensure our guests look their best, both in the salon and at home. The hair care products we carry have been carefully chosen based both on performance and eco-sensitivity. As a clean air salon, we offer ammonia-free colour services with little to no scent properties or chemical emanation. This healthier alternative to traditional colouring practices is also safe for expectant mothers and individuals with allergies or scent sensitivities.

Our design and philosophy work hand in hand. We are committed to providing healthy hair care with a low impact on the environment. Come see what you and your hair can do for the Earth.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<!-- fact -->
				<div class="col-lg-3 col-sm-6 fact">
					<i class="flaticon-016-woman"></i>
					<h2>+3500</h2>
					<p>Happy Clients</p>
				</div>
				<!-- fact -->
				<div class="col-lg-3 col-sm-6 fact">
					<i class="flaticon-020-mirror"></i>
					<h2>12</h2>
					<p>New Locations</p>
				</div>
				<!-- fact -->
				<div class="col-lg-3 col-sm-6 fact">
					<i class="flaticon-030-cream-1"></i>
					<h2>+175</h2>
					<p>Great Employees</p>
				</div>
				<!-- fact -->
				<div class="col-lg-3 col-sm-6 fact">
					<i class="flaticon-013-facial-mask-1"></i>
					<h2>56K</h2>
					<p>Instagram Followers</p>
				</div>
			</div>
		</div>
	</section>
	<!-- intro section end -->


	<!-- Services section -->
	<section class="services-section spad set-bg" data-setbg="img/service-bg.png">
		<div class="container">
			<div class="section-title text-white">
				<h2>Our Services</h2>
			</div>
			<div class="row">
				<!-- service -->
					<c:forEach items="${services_list }" var="cat">
						<div class="col-lg-4 col-md-6 service text-white">
							<h2>${cat.service_name} </h2>
							<p>${cat.description}</p>
							<b><p>Rs. ${cat.price}</p></b>
						</div>
					</c:forEach>
				<!-- service -->
		</div>
	</section>
	<!-- Services section end -->

					<div class="copyright" style="background-color:black;">
					<p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved 
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer section end -->


	<!--====== Javascripts & Jquery ======-->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/circle-progress.min.js"></script>
	<script src="js/main.js"></script>

    </body>
</html>