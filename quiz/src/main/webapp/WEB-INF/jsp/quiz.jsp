<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body class="d-flex flex-column min-vh-100">
	<c:import url="header.jsp" />
	<br>

	<div class="container">
		<form action="/user/quiz" method="POST">
			<div class="form-group">
				<c:forEach items="${questions }" var="q" varStatus="loop">
					<div class="font-weight-bold">
						${loop.count}/
						<c:out value="${q.key.title}"></c:out>
					</div>
					<c:forEach items="${q.value}" var="c">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="${q.key.id }"
								value="${c.id }"> <label class="form-check-label"
								for="exampleRadios1"> <c:out value="${c.choice}"></c:out>
							</label>
						</div>
					</c:forEach>
					<br />
				</c:forEach>
			</div>
			<input type="submit" value="Finish Quiz" class="btn btn-primary mb-4">
		</form>

		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item page-link">
					Pages:
				</li>
				<c:forEach begin="1" end="${totalPages }" varStatus="loop">
					<li class="page-item"><a class="page-link"
						href="/user/quiz?pageNum=${loop.index}"> ${loop.index } </a></li>
				</c:forEach>
			</ul>
		</nav>
	</div>

	<c:import url="footer.jsp" />
</body>
</html>