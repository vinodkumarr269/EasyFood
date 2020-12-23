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
${hno}

<form action="addItemsToHotel" action="get" >
		<table align="center" border="1px">
			    <input type="hidden" name="ino" value="${items.ino }">
		<input type="hidden" name="hno" value="${hno }">
		
		<tr>
				<td colspan=2><center>
						<font size=4><b>Add Items To Hotel</b></font>
					</center></td>
			</tr>
			<tr>
				<td>ItemName:</td>
				<td><input type="text" name="itemname" value="${items.itemname}"
					required="required"></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price"
					value="${items.price}" required="required"></td>
			</tr>
			
			<tr>
			

				<td colspan = "3">
					<button style="width: 100%"type="submit" >Register</button>
					
			</tr>
		</table>
	</form>
</body>
</html>