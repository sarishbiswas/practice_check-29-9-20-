<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>MenuItem Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.table {
	border-radius: 5px;
	width: 50%;
	margin: 0px auto;
	float: none;
}

body {
	background:
		url("https://images.wallpapersden.com/image/download/meat-chicken-grilled_45572_2560x1440.jpg")
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
</style>
</head>

<body>
	<nav class="navbar navbar-expand-md navbar-light bg-warning"> <a
		class="navbar-brand" href="/menuitems">Welcome to
		Food Mart</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">

		<ul class="nav navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link" href="/menuitems">Admin
					Panel</a></li>
			<li class="nav-item"><a class="nav-link"
				href="/cart"> User Panel</a></li>
		</ul>
	</div>
	</nav>
	<br>
	<div class="container col-md-6 mt-5 ">
		<form:form method="post" modelAttribute="add"
			class="shadow-lg p-4 text-black">
			<div class="form-group">
				<form:label path="id">Menu Id</form:label>
				<form:input type="text" class="form-control" path="id" />
			</div>

			<div class="form-group">
				<form:label path="name">Name</form:label>
				<form:input type="text" class="form-control" path="name"
					required="true" />
			</div>
			<div class="form-group">
				<form:label path="price">Price</form:label>
				<form:input type="text" class="form-control" path="price"
					required="true" />
			</div>
			<div class="form-group">
				<form:label path="actv">Active Status</form:label>
				<form:input type="text" class="form-control" path="actv"
					required="true" />
			</div>
			<div class="form-group">
				<form:label path="dateOfLaunch">Date of Launch</form:label>
				<form:input type="text" class="form-control" path="dateOfLaunch"
					required="true" />
			</div>
			<div class="form-group">
				<form:label path="category">Category</form:label>
				<form:input type="text" class="form-control" path="category"
					required="true" />
			</div>
			<div class="form-group">
				<form:label path="freeDelivery">Free Delivery Option</form:label>
				<form:input type="text" class="form-control" path="freeDelivery"
					required="true" />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>


</body>
</html>