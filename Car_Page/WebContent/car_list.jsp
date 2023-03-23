<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<th>Number</th>
			<th>Model</th>
			<th>Price</th>
			<th>Brand</th>
		<tr>
			<c:forEach items="${requestScope.car_list }" var="car">
				<tr>
					<td>${car.number}</td>
					<td>${car.model}</td>
					<td>${car.price}</td>
					<td>${car.brand}</td>
				</tr>
			</c:forEach>
	</table>

</body>
</html>