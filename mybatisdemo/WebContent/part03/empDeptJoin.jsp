<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empDeptJoin.jsp</title>
</head>
<body>

	<table>
		<tr>
			<th>employee_id</th>
			<th>first_name</th>
			<th>job_id</th>
			<th>department_id</th>
			<th>department_name</th>
		</tr>

		<c:forEach items="${aList}" var="dto">
			<tr>
				<td>${dto.employee_id}</td>
				<td>${dto.first_name}</td>
				<td>${dto.job_id}</td>
				<td>${dto.dept.department_id}</td>
				<td>${dto.dept.department_name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>