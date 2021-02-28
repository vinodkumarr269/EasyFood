<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: red;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<a href="displayAllHotels" class="navbar-brand">Show All Hotels</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="displayCart" class="navbar-brand">View Cart</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="diplayOffers" class="navbar-brand">View Offers</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="diplayOrderHistory" class="navbar-brand">View History</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="/account" class="navbar-brand">Account</a>
					<div class="dropdown">
						<button class="dropbtn">
							Dropdown <i class="fa fa-caret-down"></i>
						</button>
						<div class="dropdown-content">
							<a href="#">Log Out</a> <a href="#">Linksdcsdc 2</a> <a
								href="#">Linsdsdcsdk 3</a>
						</div>
					</div>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode=='MODE_All_HOTELS' }">
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
				<tr>
					<td colspan="5"><b>Grand Total=${totalprice }</b></td>
				</tr>
				<tr>
					<td colspan="5"><input style="width: 100%" type="submit"
						" value="continue with cart"></td>
				</tr>


			</table>

		</c:when>
		<c:when test="${mode=='MODE_ACCOUNT' }">
			<br>
			<br>
			<table border="1px">
				<tr>
					<td>USER DETAILS = ${username }<br></td>
				</tr>
				<tr>
					<td><a href="/help">HELP</a><br></td>
				</tr>
				<tr>
					<td><a href="/logout">LOGOUT</a><br></td>
				</tr>
			</table>

			<form action="accountdetails"></form>


		</c:when>
	</c:choose>
</body>
</html>