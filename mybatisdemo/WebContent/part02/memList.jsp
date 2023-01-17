<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memList.jsp</title>
</head>
<body>
	<p>
		<a href='memInsert'>글쓰기</a>
	</p>
	<table>
		<tr>
			<th>num</th>
			<th>name</th>
			<th>age</th>
			<th>loc</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>

		<c:forEach items="${requestScope.aList}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td>${dto.name}</td>
				<td>${dto.age}</td>
				<td>${dto.loc}</td>
				<td><form action='memUpdate'>
						<input type='submit' value='수정' />
						<input type='hidden' name='num' value='${dto.num}'/>
						<input type='hidden' name='name' value='${dto.name}'/>
						<input type='hidden' name='age' value='${dto.age}'/>
						<input type='hidden' name='loc'	value='${dto.loc}'/>
					</form></td>
				<td><form action='memDelete'>
						<input type='hidden' name = 'num' value='${dto.num}' />
						<input type='submit' value='삭제' /> 
						</form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>