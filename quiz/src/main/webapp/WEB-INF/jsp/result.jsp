<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Result</title>
</head>
<body class="d-flex flex-column min-vh-100">

	<c:import url="header.jsp" />
	
	<div class="font-weight-bold m-2">
		Your result is:
		<c:out value="${countCorrect }">Correct</c:out>
		/ 5 (Correct/Total) <br>
	</div>


	<c:forEach items="${result }" var="r" varStatus="status">
		<div class="form-check mb-4">
			<div class="font-weight-bold">
				Question ${status.count }:
				<c:out value="${r.key }">Question Title</c:out>
			</div>
			<div>
				<c:if test="${r.value[0] == r.value[1]}">
					<div class="text-success">
						Your choice is correct:
						<c:out value="${r.value[0]}"></c:out>
					</div>
				</c:if>
				<c:if test="${r.value[0] != r.value[1] }">
					<div class="text-danger">
						Your choice:
						<c:out value="${r.value[0]}"></c:out>
					</div>
					<div class="text-success">
						Correct choice:
						<c:out value="${r.value[1]}"></c:out>
					</div>
				</c:if>
			</div>
		</div>
	</c:forEach>


	<a href="/user/quiz"><button class="btn btn-primary m-4">RETAKE
			QUIZ</button></a>

	<c:import url="footer.jsp" />
</body>
</html>