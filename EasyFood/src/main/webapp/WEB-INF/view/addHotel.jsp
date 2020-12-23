<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="register-hotel" method="get">
		<table align="center" border="1px">
		<input type="hidden" name="hno" value="${hotel.hno }">
		<tr>
				<td colspan=2><center>
						<font size=4><b>Register Hotel</b></font>
					</center></td>
			</tr>
			<tr>
				<td>HotelName:</td>
				<td><input type="text" name="hotelname" value="${hotel.hotelname}"
					required="required"></td>
			</tr>
			<tr>
				<td>Rating:</td>
				<td><input type="text" name="rating"
					value="${hotel.rating}" required="required"></td>
			</tr>
			<tr>
				<td>area:</td>

				<td><input type="text" name="area" value="${hotel.area}"
					required="required"></td>
			</tr>
			<tr>
				<td colspan = "3">
					<button style="width: 100%"type="submit" >Register</button>
					
			</tr>
		</table>
			</form>

</body>
</html>