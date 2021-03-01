<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="add-address-into-database" >
		<table align="center" border="1px">
		<input type="hidden" name="hno" value="${address.ano }">
		<tr>
				<td colspan=2><center>
						<font size=4><b>AddressDetails</b></font>
					</center></td>
			</tr>
			<tr>
				<td>H.NO:</td>
				<td><input type="text" name="houseno" value="${address.houseno}"
					required="required"></td>
			</tr>
			<tr>
				<td>FLATNAME:</td>
				<td><input type="text" name="flat"
					value="${address.flat}" required="required"></td>
			</tr>
			<tr>
				<td>LANDMARK:</td>

				<td><input type="text" name="landmark" value="${address.landmark}"
					required="required"></td>
			</tr>
					<tr>
				<td>AREA:</td>
				<td><input type="text" name="area" value="${address.area}"
					required="required"></td>
			</tr>
			<tr>
				<td>CITY:</td>
				<td><input type="text" name="city"
					value="${address.city}" required="required"></td>
			</tr>
			<tr>
				<td>STATE:</td>

				<td><input type="text" name="state" value="${address.state}"
					required="required"></td>
			</tr>
					<tr>
				<td>PINCODE:</td>

				<td><input type="text" name="pincode" value="${address.pincode}"
					required="required"></td>
			</tr>
			
			
			<tr>
			

				<td colspan = "3">
					<button style="width: 100%"type="submit" >AddAddress</button>
					
			</tr>
		</table>
	</form>

</body>
</html>