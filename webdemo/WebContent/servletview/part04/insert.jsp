<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert.jsp</title>
</head>
<body>
	<form action="meminsert" method="post">
	<table>
		<tr>
			<th>name</th>
			<td><input type="text" name="name" /></td>
		</tr>

		<tr>
			<th>age</th>
			<td><input type="text" name="age" /></td>
		</tr>

		<tr>
			<th>loc</th>
			<td><input type="text" name="loc" /></td>
		</tr>


		<tr>
			<td colspan="2"><input type="submit" value="commit" /></td>
		</tr>




	</table>
	</form>
</body>
</html>