<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.form-container {
	position: absolute;
	top: 17vh;
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

	<section class="container-fluid ">
		<section class="row justify-content-center">
			<section class="col-12 col-sn-6 col-md-3">
				<form class="form-container" method="post" action="change-password">
					<div class="form-group">
						<label for="exampleInputEmail1">User Name</label> <input
							type="text" class="form-control" name="username"
							id="exampleInputEmail1" aria-describedby="emailHelp">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Mobile Number</label> <input
							type="password" class="form-control" name="mobileno"
							id="exampleInputPassword1">
					</div>
					<c:set var="err" value="${notmatching}"></c:set>
					<c:if test="${err == 400 }">
						<div>
							<p style="color: red">please Contact Administrator (+917731897510) or try again</p>
						</div>
					</c:if>
					<c:set var="err" value="${nouserfound}"></c:set>
					<c:if test="${err == 404 }">
						<div>
							<p style="color: red">No Username Found</p>
						</div>
					</c:if>
					<button type="submit" class="btn btn-primary btn-block">Submit</button>

				</form>
			</section>
		</section>
	</section>

</body>
</html>