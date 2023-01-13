<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>주석처리</h3>
	<!-- html 주석 (출력 시 노출됨) -->

	<%-- jsp 주석 (출력 시 노출되지 않음) --%>
	<%--
 	EL(Expression Language) : 표현 언어
 	1. JSP 스크립트를 대신해서 속성값을 편리하게 출력할 수 잇도록 제공해주는 언어이다.
 	2. ${  } -> jsp에서 쓰는 기호이기 때문에 html주석 쓰게되면 오류발생할 수 있음
 	 --%>

	<!-- jsp에서 java코드를 구현할 때 쓰는것 -->
	<%
	//scope(영역) - 데이터를 참조할 수 있도록 제공해주는 공간
	//page(객체)-pageContext(scope), request-request, session-session, application-application (기본객체와 관련있음)

	//page영역에 p1이름으로 page값이 저장된다.
	pageContext.setAttribute("p1", "page"); //한 페이지(현재 페이지에서만 참조가능)

	//request영역에 p2이름으로 request값이 저장된다.
	request.setAttribute("p2", "request"); //한 번의 호출 

	//session영역에 p3이름으로 session값이 저장된다.
	session.setAttribute("p3", "session"); //하나의 클라이언트 (로그인 처리할 때 많이 사용)

	//application영역에 p4이름으로 application값이 저장된다.
	application.setAttribute("p4", "application"); //모든 클라이언트 (방문자수)
	%>


	<p>
		<%=pageContext.getAttribute("p1")%>/<%=request.getAttribute("p2")%>/
		<%=session.getAttribute("p3")%>/<%=application.getAttribute("p4")%>
	</p>

	<p>${pageScope.p1} / ${requestScope.p2 } / ${sessionScope.p3 }
		/${applicationScope.p4}</p>


	<p>
		<!-- 
	속성값을 가져올 때 영역을 명시하지 않으면 page->request->session->application순으로 검색을한다.
	 -->
		${p3 }
	</p>























</body>
</html>