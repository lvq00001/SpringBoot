<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome page</title>
</head>
<body class="d-flex flex-column min-vh-100">
	<c:import url="header.jsp"/>
	<br>
	<h3 class="font-weight-bold">NAVIGATION PAGE</h3>
	<ul>
		<li><a href="/user/quiz">Start a quiz</a></li>
		<li><a href="/admin/add-quiz">Add quiz</a></li>
		<li><a href="/admin/manage-questions">Manage questions</a></li>
		<li><a href="/admin/manage-users">Manage users</a></li>
	</ul>
	<c:import url="footer.jsp" />
</body>
</html>