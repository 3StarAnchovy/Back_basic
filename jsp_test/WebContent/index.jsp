<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 응애 나 주석  --%>
	<%-- 선언 - 멤버변수, 메소드 등을 선언, 얘 스코프는 어디까지임? --%>
	<%!int var1 = 10;
	static int var2 = 30;
	boolean flag = false;

	public void hello() {
		System.out.println("hello 호출");
	}%>

	<%--스크립틀릿 - 자바코드 service() 메소드의 구현부 --%>
	<%
		List<Integer> list = new ArrayList<>();
	list.add(10);
	list.add(5);
	System.out.println(list);
	hello();
	out.println(var1);
	out.println(var2);
	%>
	<br>

	<%-- 표현식 out.print()와 비슷한 의미 --%>
	<%=var1%>
	<br>
	<%=flag%>
</body>
</html>