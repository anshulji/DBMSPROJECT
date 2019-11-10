<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<li class="active"><a href="services">Services</a></li>
				<li><a href="blog">Blog</a></li>
				<li><a href="contact">Contact</a></li>
				<li><a href="products">Products</a></li>
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

                                                
	<!-- Hero section -->

		<img src="<c:url value="/resources/img/back.png" />" style="width:100%;" alt="">

	<!-- Hero section end -->


		<!-- Services section -->
	<section class="services-section spad set-bg" style="background-color:white;">
		<div class="container" style="background-color:white;">
			<div class="section-title text-black" style="background-color:white;">
				<h2>Our Services</h2>
			</div>
			<div class="row">
				<!-- service -->
					<c:forEach items="${services_list }" var="cat">
						<div class="col-lg-4 col-md-6 service text-black">
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