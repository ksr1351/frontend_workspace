<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_02_res_jsp</title>
</head>
<body>
	<%
	//scriptlet
	String data = request.getParameter("data");
	out.print("<p>" + data + "</p>"); //scriptlet에서 변수 출력할 땐 out 이용
	%>

	<p>
		<%=data%>
	</p>

	<p>${param.data}</p>
	<!-- 파라미터값을 받을 때는 param 이용, data는 파라미터값 -->
	<!-- 모든 파라미터는 기본이 String -->

	<%
	String[] chk = request.getParameterValues("chk");
	if (chk != null) {
		for (String sn : chk)
			out.print("<p>" + sn + "</p>");
	}
	%>
	<p>${paramValues.chk[0]}</p>
	<p>${paramValues.chk[1]}</p>
	<p>${paramValues.chk[2]}</p>

	<!-- 256바이트 이상인것, 보안이 필요한 정보들은 get방식 쓰면 안됨(노출됨) -->



</body>
</html>