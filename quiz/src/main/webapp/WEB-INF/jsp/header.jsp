<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
	<header class="h5 p-3 bg-info">
		User:
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.username" />
		</sec:authorize>
		|
		<a href="/logout">Logout</a>
		|
		<a href="/">Navigation</a>
	</header>

</body>
</html>