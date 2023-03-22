<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String rememberId = "";
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies)
	{
		if(cookie.getName().equals("rememberId"))
		{
			rememberId = cookie.getValue();
		}
	}
%>
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
	<label>아이디</label><input type = "text" value = "<%=rememberId%>" name = "id">
	<br>
	<label>비밀번호</label><input type = "password" name = "password">
	</fieldset>
	<input type = "submit" value = "로그인"/>
	</form>
</body>
</html>