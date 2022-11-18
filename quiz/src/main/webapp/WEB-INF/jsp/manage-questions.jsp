<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Questions</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

</head>
<body class="d-flex flex-column min-vh-100">
<c:import url="header.jsp"></c:import>
	<table class = "table table-bordered">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th colspan="2">Manage</th>
		</tr>
		<c:forEach var="q" items="${questions}" varStatus="status">
			<tr>
				<td>${q.id}</td>
				<td>${q.title}</td>
				<td><a href="/admin/update-question?id=${q.id}">Edit</a></td>
				<td><a href="/admin/delete-question?id=${q.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="footer.jsp"/>
</body>
</html>

