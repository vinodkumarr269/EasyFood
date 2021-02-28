<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
</head>
<body>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
			      <th scope="col"></th>
			
				<th scope="col">HotelNo</th>
				<th scope="col">HotelName</th>
				<th scope="col">Rating</th>
				<th scope="col">Area</th>
				<th scope="col">items</th>
			</tr>
			  </thead>
			  <tbody>
			
			<c:forEach var="hotel" items="${hotels }">
				<tr>
				      <th scope="row"></th>
				
					<td>${hotel.hno}</td>
					<td>${hotel.hotelname}</td>
					<td>${hotel.rating}</td>
					<td>${hotel.area}</td>
					<td><a href="/openAddItemsPage?hno=${hotel.hno }">Add
							items</a></td>
				</tr>
			</c:forEach>
			</tbody>
	</table>

</body>
</html>