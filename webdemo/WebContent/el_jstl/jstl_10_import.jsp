<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_10_import</title>
</head>
<body>
	<%--
	<jsp:include/> 액션태그와 같은 기능을 처리한다.
--%>

	<p>before</p>
	<c:import url="jstl_10_top.jsp">
		<c:param name="data" value="10" />
	</c:import>
	<p>after</p>

</body>
</html>

<%--여러페이지 내의 중복된 부분들을 별도의 페이지에 작성하고 페이지를 포함해서 사용(include)
core에서는 import 사용 가능 
param을 이용해서 parameter값을 받을 수 있음 (param.파라미터값)--%>