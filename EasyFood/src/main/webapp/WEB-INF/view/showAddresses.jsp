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
<form action="over-all-summary">
<a href="/add-address">Add Address</a><br>
<c:set var="x" value="${x}"></c:set>
<c:if test="${x ==1 }">
<body>
	<table border="1px" class="table table-striped">
		<thead>
		<tr>
			<th>HOUSE NO</th>
			<th>FLAT</th>
			<th>LANDMARK</th>
			<th>AREA</th>
			<th>CITY</th>
			<th>STATE</th>
			<th>PINCODE</th>
			<th>SELECT</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="address" items="${addresses }">
			<tr>
				<td>${address.houseno}</td>
				<td>${address.flat}</td>
				<td>${address.landmark}</td>
				<td>${address.area}</td>
				<td>${address.city}</td>
				<td>${address.state}</td>
				<td>${address.pincode}</td>
				<td><label><input type="radio" name="ano"value="${address.ano}"></label></td>
			<%-- <td><a href="/selectaddress?ano=${address.ano }">select</a></td>--%>	
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<input type="submit" name="submit">
</c:if>
</form>
</body>
</html>