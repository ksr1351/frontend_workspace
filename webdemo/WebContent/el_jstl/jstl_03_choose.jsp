<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_03_choose</title>
</head>
<body>
<%
	int avg = 85;

	if (avg >= 90)
		out.print("A");
	else if (avg >= 80)
		out.print("B");
	else if (avg >= 70)
		out.print("C");
	else if (avg <= 60)
		out.print("D");
	else
		out.print("F");
%>


★ 외우기 ★
<p>if~else 와 switch~case의 혼합형태 : choose태그 </p>
<c:set var="avg" value="85"/>

<c:choose>
	<c:when test="${avg>=90}">
	<p> <c:out value="A"/> </p>
	</c:when>
	
	<c:when test="${avg>=80}">
	<p> <c:out value="B"/> </p>
	</c:when>
	
	<c:when test="${avg>=70}">
	<p> <c:out value="C"/> </p>
	</c:when>
	
	<c:when test="${avg>=60}">
	<p> <c:out value="D"/> </p>
	</c:when>
	
	<c:otherwise>
		<p> <c:out value="F"/></p>
	</c:otherwise>
</c:choose> 



</body>
</html>