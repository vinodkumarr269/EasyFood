<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Searched Hotels</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
			<table class="table table-striped">
				<thead class="thead-dark">
					<tr>
						<th>HotelName</th>
						<th>Rating</th>
						<th>Area</th>
					</tr>

				</thead>
				<tbody>
					<c:forEach var="hotel" items="${hotels }">
						<tr>
							<td><a href="/getAllItemsByHno?hno=${hotel.hno }">${hotel.hotelname}</a></td>
							<td>${hotel.rating}</td>
							<td>${hotel.area}</td>
						</tr>
					</c:forEach>
				<tbody>
			</table>
		
		
		
</body>
</html>