<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<title>Update Questions</title>
</head>
<body>
	<c:import url="header.jsp" />
	<br>

	<form:form method="POST" action="/admin/update-question"
		modelAttribute="question">
		<h3 class="font-weight-bold">UPDATE QUESTION</h3>
		<div>
			<table>
				<tr>
					<td><form:label class="font-weight-bold" path="id">Question ID</form:label></td>
					<td><form:input class="form-control" path="id" value="${q.id }" /></td>
				</tr>
				<tr>
					<td><form:label class="font-weight-bold" path="title">Question Title</form:label></td>
					<td><form:textarea class="form-control" path="title" rows="3" cols="50" value="${q.title }"/></td>
				</tr>
				<c:forEach items="${choiceList }" var="c" varStatus="status">
					<tr>
						<td class="font-weight-bold">Choice ${status.index +1}</td>
						<td><input class="form-control" name="choice" type="text" value="${c.choice }" /></td>
					</tr>
				</c:forEach>
				<tr>
					<td><input class="btn btn-primary mt-4 mb-4" type="submit" value="Update Quiz" /></td>
				</tr>
			</table>
		</div>
	</form:form>

	<c:import url="footer.jsp" />
</body>
</html>