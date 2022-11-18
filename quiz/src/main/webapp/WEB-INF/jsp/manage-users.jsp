<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<title>Manage Users</title>
</head>
<body class="d-flex flex-column min-vh-100">
	<c:import url="header.jsp" />
	<br>

	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">User name</th>
				<th scope="col">Enabled</th>
				<th scope="col">Disable/Enable</th>
				<th scope="col">Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList }" var="u" varStatus="stat">
				<tr>
					<th scope="row">${u.id }</th>
					<td>${u.username }</td>
					<td>${u.enabled }</td>
					<td><a href="/admin/disable-user?id=${u.id }">Change</a></td>
					<td><a href="/admin/delete-user?id=${u.id }">Delete</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<c:import url="footer.jsp" />
</body>
</html>