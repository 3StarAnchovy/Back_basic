<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href = "${pageContext.request.contextPath}/city?param=list"> 도시 목록 조회</a>
	<br> 
	<c:choose>
		<c:when test="${sessionScope.userInfo == null}">
			<a href = '${pageContext.request.contextPath}/auth?param=loginPage'>로그인</a><br> 
		</c:when>
		<c:otherwise>
			<a href = '${pageContext.request.contextPath}/city?param=writePage'>도시정보등록</a><br> 
			<a href = '${pageContext.request.contextPath}/auth?param=logout'>로그아웃</a><br> 
		</c:otherwise> 
	</c:choose>
	
	
	<%--
	if(session.getAttribute("userInfo") == null){ //로그인하지 않은 경우
		out.print("<a href='/mvc_test_el/auth?param=loginPage'>로그인</a><br>");
	}
	else{ // 로그인한경우
		out.print("<a href='/mvc_test_el/city?param=writePage'>도시정보등록</a>");
		out.print("<a href='/mvc_test_el/auth?param=logout'>로그아웃</a>");
	}
	--%>
</body>
</html>