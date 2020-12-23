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
	<a href="displayAllHotels">Show All Hotels</a>
	<a href="displayCart">View Cart</a>
	<a href="diplayOffers">View Offers</a>
	<a href="diplayOrderHistory">View History</a>
	<c:choose>
		<c:when test="${mode=='MODE_All_HOTELS' }">
			<table border="1px">
				<tr>
					<th>HotelName</th>
					<th>Rating</th>
					<th>Area</th>
				</tr>
				<c:forEach var="hotel" items="${hotels }">
					<tr>
						<td><a href="/getAllItemsByHno?hno=${hotel.hno }">${hotel.hotelname}</a></td>
						<td>${hotel.rating}</td>
						<td>${hotel.area}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:when test="${mode=='SHOW_CART_ITEMS' }">
			<table align="left" border="1px">
			<tr>
				<th>HotelNo</th>
				<th>ItemNo</th>
				<th>ItemName</th>
				<th>Price</th>
				<th>Remove</th>
				
			</tr>
			<c:forEach var="c" items="${cartItems }">
				<tr>
					<td>${c.hno}</td>
					<td>${c.ino}</td>
					<td>${c.itemname}</td>
					<td>${c.price}</td>
					<td><a href="/removefromcart?no=${c.no }">remove</a></td>
				</tr>
			</c:forEach>
			<tr><td colspan="5"><b>Grand Total=${totalprice }</b> </td></tr>
			<tr><td colspan="5"><input style="width: 100%"type="submit" " value="continue with cart" ></td></tr>
			
			
		</table>
		 
		</c:when>
		
	</c:choose>
</body>
</html>