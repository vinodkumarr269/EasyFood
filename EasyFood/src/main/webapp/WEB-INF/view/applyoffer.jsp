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
<form action="/applycoupon">
<b>Total Amount To Pay=${totalprice }</b><br><br>
ApplyCoupon:<input type="text" name="coupon">
<input type="submit" value="apply"><br><br><br>
<input type="submit" value="Proceed">
</form>

</body>
</html>