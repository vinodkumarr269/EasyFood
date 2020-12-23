<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
				<tr>
					<th>HotelNo</th>
					<th>HotelName</th>
					<th>Rating</th>
					<th>Area</th>
					<th>items</th>
				</tr>
				<c:forEach var="hotel" items="${hotels }">
					<tr>
						<td>${hotel.hno}</td>
						<td>${hotel.hotelname}</td>
						<td>${hotel.rating}</td>
						<td>${hotel.area}</td>
						<td><a href="/openAddItemsPage?hno=${hotel.hno }">Add items</a></td>
					</tr>
					</c:forEach>
			</table>

</body>
</html>