<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>

	<div class="text-danger text-center font-weight-bold">
		<c:choose>
			<c:when test="${rs!= null }">
				<p>${rs }</p>
			</c:when>
		</c:choose>
	</div>
	
	<form:form action="register" method="post" modelAttribute="user"
		class="form-group col-md-4 offset-md-4">
		<h3 class="text-center">REGISTER FORM</h3>
		<table>
			<form:errors class="text-danger" path="*"></form:errors>
			<tr>
				<th>Username:</th>
				<td><form:input class="form-control" path="username"
						placeholder="Enter Username" /></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><form:input class="form-control" path="userPassword"
						placeholder="Enter Password" /></td>
			</tr>
		</table>
		<input type="submit" value="Register"
			class="btn btn-primary btn-block mt-4" />


	</form:form>

</body>
</html>