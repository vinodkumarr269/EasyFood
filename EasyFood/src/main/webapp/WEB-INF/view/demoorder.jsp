<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order History</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
</head>
<body>
	<a href="displayAllHotels">back</a><br><br>
<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th>Hotel Name</th>
						<th>Item Name</th>
						<th>Price</th>
						<th>Order No</th>
					</tr>
				</thead>
				<c:forEach var="c" items="${orderlistbyorderno }">
				<tr>
					<td>${c.hotelname}</td>
					<td>${c.itemname}</td>
					<td>${c.price}</td>
					<td>${c.orderno}</td>
					</tr>
				</c:forEach>
			
</body>
</html>