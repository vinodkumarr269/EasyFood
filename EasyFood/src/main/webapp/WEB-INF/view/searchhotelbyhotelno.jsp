<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<table class="table table-striped">
				<thead class="thead-dark">
				<tr>
					<th>HotelNo</th>

					<th>HotelName</th>
					<th>Rating</th>
					<th>Area</th>
					<th>items</th>
				</tr>
				</thead>
				<tbody>
					<tr>
						<td>${hotel.hno}</td>

						<td>${hotel.hotelname}</td>
						<td>${hotel.rating}</td>
						<td>${hotel.area}</td>
						<td><a href="/getAllItemsByHno?hno=${hotel.hno }">items</a></td>
					</tr>
					</tbody>
			</table>

</body>
</html>