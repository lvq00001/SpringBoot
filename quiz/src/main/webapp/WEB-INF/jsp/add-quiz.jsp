<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<title>Add Quiz</title>
</head>
<body class="d-flex flex-column min-vh-100">
	<c:import url="header.jsp"/><br>
	
	
	<form:form method="POST" action="/admin/add-quiz" modelAttribute="question" class="form-group col-md-6 offset-md-3">
		<h3>ADD NEW QUIZ</h3>
		<div>
			<table >
				<tr>
					<td class="font-weight-bold"><form:label path="title">Question Title</form:label></td>
					<td><form:textarea class="form-control" path="title" rows="3" cols="100"/></td>
				</tr>
				<tr>
					<td class="font-weight-bold">Choice 1</td>
					<td><input class="form-control" name="choice1" type="text" value="" /></td>
				</tr>
				<tr>
					<td class="font-weight-bold">Choice 2</td>
					<td><input class="form-control" name="choice2" type="text" value="" /></td>
				</tr>
				<tr>
					<td class="font-weight-bold">Choice 3</td>
					<td><input class="form-control" name="choice3" type="text" value="" /></td>
				</tr>
				<tr>
					<td class="font-weight-bold">Choice 4</td>
					<td><input class="form-control" name="choice4" type="text" value="" /></td>
				</tr>
				<tr>
					<td colspan="2"><input class="btn btn-secondary btn-block mt-4 " type="submit" value="Add Quiz" /></td>
				</tr>
			</table>
		</div>
	</form:form>
	
	<c:import url="footer.jsp"/>
</body>
</html>