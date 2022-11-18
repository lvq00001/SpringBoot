<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html xmlns:th="http:/www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<title>Login Page</title>
</head>
<body>
	<div class="font-weight-bold text-center">
		<p class="text-success">
			<c:out value="${rs}"></c:out>
		</p>
		<c:choose>
			<c:when test="${param.logout != null }">
				<p class="text-success">LOG OUT SUCCESSFULLY!</p>
			</c:when>
			<c:when test="${param.error !=null }">
				<p class="text-danger">Wrong username or password</p>
			</c:when>
		</c:choose>
	</div>

	<form th:action="/login" method="post" role="form"
		class="col-md-4 offset-md-4">
		<div class="mt-4 mb-4">
			<input class="form-control" type="text" name="username"
				placeholder="Enter Username">
		</div>
		<div class="mb-4">
			<input class="form-control" type="password" name="password"
				placeholder="Enter Password">
		</div>

		<button class="btn btn-primary btn-block" type="submit">Log
			in</button>

		<div class="text-center">
			<p>
				Not a member? <a href="/register">Register</a>
			</p>
		</div>
	</form>

</body>
</html>




