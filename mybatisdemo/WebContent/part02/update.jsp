<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update.jsp</title>
</head>
<body>
	<form action='memUpdate' method='post'>
		<table>
			<tr>
				<th>이름</th>
				<td><input type='text' name='name' value='${dto.name}' /></td>
			</tr>

			<tr>
				<th>나이</th>
				<td><input type='text' name='age' value='${dto.age}' /></td>
			</tr>

			<tr>
				<th>지역</th>
				<td><input type='text' name='loc' value='${dto.loc}' /></td>
			</tr>

			<tr>
				<td colspan='2'><input type='hidden' name='num'
					value='${dto.num}' /><input type='submit' value='commit' /></td>
			</tr>
		</table>
	</form>
</body>
</html>