<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
    
<%--
	String rememberId = "";
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies)
	{
		if(cookie.getName().equals("rememberId"))
		{
			rememberId = cookie.getValue();
		}
	}
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/auth" method="post">
	<input type ="hidden" name="param" value="login">
	<fieldset>
	<label>아이디</label><input type = "text" value = "${cookie.rememberId.value }" name = "id">
	<input type = "checkbox" name = "isRemember" value = ${(empty cookie.rememberId) ? "" : "checked"}> 아이디 저장
	<br>
	<label>비밀번호</label><input type = "password" name = "password">
	</fieldset>
	<input type = "submit" value = "로그인"/>
	</form>
</body>
</html>