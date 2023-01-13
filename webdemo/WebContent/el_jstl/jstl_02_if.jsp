<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jsp를 core로 만들때 꼭 선언되어야함 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_02_if</title>
</head>
<body>

	<%
	int num = 10;
	if (num % 2 == 0)
		out.print("event");
	if (num % 2 == 1)
		out.print("odd");
	%>

	<hr />
	<%--
	<c:if test="${조건식}" var="변수명" scope="범위">
	
	</c:if>
	var, scope는 생량할 수 있다.(옵션)
	scope를 생략하면 기본값은 page이다.
 --%>
 
 <c:set var="num" value="10"/>
 <c:if test="${num%2==0}">
 <c:out value="${'even'}"/>
 </c:if>
 
 
 <c:if test="${num%2==1}">
 <c:out value="${'odd' }"/>
 </c:if> <!-- 조건 만족하지 않아 결과값 나오지 않음 -->
 
</body>
</html>




















