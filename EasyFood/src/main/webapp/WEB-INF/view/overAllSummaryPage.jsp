<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/apply-offer">
		<table class="table">
		<thead>
			<tr>
				<th>HotelNo</th>
				<th>ItemNo</th>
				<th>ItemName</th>
				<th>Price</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="c" items="${cart }">
				<tr>
					<td>${c.hno}</td>
					<td>${c.ino}</td>
					<td>${c.itemname}</td>
					<td>${c.price}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<b>Grand Total=${total }</b><br> 
		<b>DelivaryAddress=${address.houseno} ,${address.flat },${address.landmark },${address.area },${address.city },${address.state },$address.country},${address.pincode}</b><br>
		<br>
		


		<input type="submit" value="continue with order">
	</form>

</body>
</html>