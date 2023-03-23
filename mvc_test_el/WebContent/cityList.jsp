<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.ssafy.mvc.dto.City"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>CountryCode</th>
			<th>population</th>
		<tr>
			<c:forEach items="${requestScope.cities }" var="city">
				<tr>
					<td>${city.id}</td>
					<td>${city.name}</td>
					<td>${city.contryCode}</td>
					<td>${city.population}</td>
				</tr>
			</c:forEach>
			
			<%-- 도시 목록 정보를 이용해 동적인 요소를 생성할 부분 --%>
			<%--
			String html = "";
				List<City> cityList = (List<City>) request.getAttribute("cities");
			for (City city : cityList) {
				System.out.println(city);
				html += "<tr>\r\n" + 
						"			<td>"+city.getId()+ "</td>\r\n" + 
						"			<td>"+city.getName()+ "</td>\r\n" + 
						"			<td>"+city.getContryCode()+ "</td>\r\n" + 
						"			<td>"+city.getPopulation()+ "</td>\r\n" + 
						"		<tr>";
						
			}
			out.print(html);
			--%>

			<%-- --%>
	</table>

</body>
</html>