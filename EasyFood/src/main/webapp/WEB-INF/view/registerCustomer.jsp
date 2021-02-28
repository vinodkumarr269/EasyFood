<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.form-container {
	position: absolute;
	top: 10vh;
	background: #fff;
	padding: 50px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px 0px #000;
	background: #fff;
}

body {
	background: url('src/main/webapp/static/download.jpg') no-repeat;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="/src/main/webapp/static/css/global.css">
</head>
<body>
					<c:set var="err" value="${x3}"></c:set>
					<c:if test="${err == 3 }">
					<script type="text/javascript">
					alert("Registered Sucessfully")
					</script>
					</c:if>
	<section class="container-fluid ">
		<section class="row justify-content-center">
			<section class="col-12 col-sn-6 col-md-3">
				<form class="form-container" method="post" action="register-customer">
				<input type="hidden" name="cno" value="${register.cno }">
				<div class="form-group">
						<label>User Name</label> <input
							type="text" class="form-control" name="username"
							value="${register.username}" required="required">
					</div>
					<c:set var="err" value="${x1}"></c:set>
					<c:if test="${err == 1 }">
					<div>
							<p style="color: red">UserName is already Existing</p>
						</div>
					</c:if>
					
					<div class="form-group">
						<label">First Name</label> <input
							type="text" class="form-control" name="firstname"
					value="${register.firstname}" required="required">
					</div>
				<div class="form-group">
						<label>Last Name</label> <input
							type="text" class="form-control"name="lastname"
					value="${register.lastname}" required="required">
					</div>
					<div class="form-group">
						<label >Mobile No</label> <input
							type="text" class="form-control"name="mobileno"
					value="${register.mobileno}" required="required">
					</div>
					<div class="form-group">
						<label >Password</label> <input
							type="password" class="form-control" name="password"
					value="${register.password}" required="required">
			</div>
					<c:set var="err" value="${x2}"></c:set>
					<c:if test="${err == 2 }">
					<div>
							<p style="color: red">Password should meet Following criteria
							* length Should be 8 or more
							* Should contain one small Alphabet
							* Should contain one small Alphabet
							* Should contain one Special Character
							</p>
						</div>
					</c:if>
					<button type="submit" class="btn btn-primary btn-block">Submit</button>
					<div class="form-group form-">
					</div>
				</form>
			</section>
		</section>
	</section>

</body>
</html>