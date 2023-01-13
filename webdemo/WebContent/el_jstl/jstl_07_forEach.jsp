<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_07_forEach</title>
</head>
<body>
	<%
	int[] num = new int[] { 10, 20, 30, 40, 50 };
	for (int i = 0; i < num.length; i++) {
		out.print("<p>" + num[i] + "</p>");
	}
	%>

	<hr />

	<c:forEach items="<%=num%>" var="data">
		<p>${data}</p>
	</c:forEach>
</body>
</html>