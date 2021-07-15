<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
	<a href="displayAllHotels">back</a><br><br>
<table>
  <tr>
    <th>Coupon Code</th>
    <th>Discount</th>
    <th>Eligible</th>
  </tr>
  <tr>
    <td>new50</td>
    <td>50%</td>
    <td>For First 5 Orders</td>
  </tr>
  </table>
</body>
</html>