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

<h2>Bill id :${prod_bill.pbill_id }</h2>
<h2>Username : ${prod_bill.username }</h2>
<h2>Date :${prod_bill.date }</h2>
<h2>Amount :${prod_bill.amount }</h2>
<div class="col-lg-6" style="width: 100%; margin: 0 auto;">
	<form:form method="post" modelAttribute="prod_bill_items" action="/dbms/admin/addbillitem">
            <label for="">Product Id</label>
			<br>
				<form:input path="prod_id" type="text" class="form-control" required="true"/>
			<br>
			<label for="">Quantity</label>
			<br>
				<form:input path="quantity" type="text" class="form-control" required="true"/>
			<br>
							<form:input path="pbill_id" value="${prod_bill.pbill_id }" type="hidden" class="form-control" required="true"/>
			
			
			<button type="submit" class="btn btn-primary">Add</button>
				
				<td>${error}</td>
			
	</form:form>
	</div>
	<table class="table table-striped">
	<thead>
      <tr>
        <th>Product Id</th>
        <th>Quantity</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${list }" var="item">
    <tr>
    <td>${item.prod_id }</td>
    <td>${item.quantity }</td>
   
    </tr>
    </c:forEach>
    </tbody>
</table>
	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>