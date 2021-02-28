<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<a href="displayAllHotels">back</a><br><br>
	<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<body>
	<table class="table">
		<thead class="thead-dark">
		<tr>
			<th>ItemNo</th>
			<th>ItemName</th>
			<th>Price</th>
			<th>AddToCart</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${items }">
			<tr>
				<td>${item.ino}</td>
				<td>${item.itemname}</td>
				<td>${item.price}</td>
				<td><a
					href="/addItemsToCart?ino=${item.ino }&hno=${item.hno}&itemname=${item.itemname}&price=${item.price}">Add
						To Cart</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>