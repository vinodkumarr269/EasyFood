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
	<c:set var="cartdetails" value="${qempty }"></c:set>
	<c:if test="${cartdetails == 1}">
No Items In the Cart Please 
<a href="displayAllHotels">click here</a> to add Items to the cart 
</c:if>
	<c:set var="cartdetails" value="${notempty }"></c:set>
	<c:if test="${cartdetails == 2}">
		<br>
		<a href="displayAllHotels">add more items</a>
		<br>
		<br>
		<form action="get-saved-addresses">

			<table class="table">
				<thead>
					<tr>
						<th>HotelNo</th>
						<th>ItemNo</th>
						<th>ItemName</th>
						<th>Price</th>
						<th>Remove</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cart" items="${cartItems }">
						<tr>
							<td>${cart.hno}</td>
							<td>${cart.ino}</td>
							<td>${cart.itemname}</td>
							<td>${cart.price}</td>
							<td><a href="/removeItemsfromcart?cno=${cart.cno }">remove</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<tr>
					<td colspan="5"><b>Grand Total=${total }</b></td>
				</tr>
				<tr>
					<td colspan="5"><input style="width: 100%" type="submit"
						value="continue with cart"></td>
				</tr>
			</table>

		</form>

	</c:if>


</body>
</html>