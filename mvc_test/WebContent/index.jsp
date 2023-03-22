<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href = "<%=request.getContextPath()%>/city?param=list"> 도시 목록 조회</a>
	<br>
	
	<%
	if(session.getAttribute("userInfo") == null){ //로그인하지 않은 경우
		out.print("<a href='/mvc_test/auth?param=loginPage'>로그인</a><br>");
	}
	
	else{ // 로그인한경우
		out.print("<a href='/mvc_test/city?param=writePage'>도시정보등록</a>");
		out.print("<a href='/mvc_test/auth?param=logout'>로그아웃</a>");
	}
	%>
</body>
</html>