<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp"%>
<meta charset="UTF-8">
<title>네트워크 게시판</title>
</head>
<body>
	<header>
		<%@ include file="/include/navbar.jsp"%>
	</header>

	<main>
		<div>전체 ${count}개</div>
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>등록일</th>
					</tr>
				</thead>
				<c:forEach var="board" items="${list}">
					<tr>
						<td>${board.no}</td>
						<td>${board.title}</td>
						<td>${board.writer}</td>
						<td>${board.regDate}</td>
					</tr>
				</c:forEach>
				<c:if test="${empty list}">
					<tr>
						<td colspan='4'>입력된 게시물이 없습니다.</td>
					</tr>
				</c:if>
			</table>
		</div>

		<c:if test="${count != 0 }">
		<nav>
			<ul class = "pagination">
				<c:forEach var = "i" begin = "1" end = "${lastPage}">
					<c:choose>
					<%-- 현재 페이지 버튼인 경우 --%>
					<c:when test = "${pageNo == i}">
						<li class = "active"><a href="#">${i}</a></li>
					 </c:when>
					<%-- 나머지 페이지인 경우 --%>
					<c:otherwise>
						<li><a href="${root}/list1?pageNo=${i}">${i}</a></li>
					</c:otherwise>
					</c:choose>
				</c:forEach>
				<li></li>
			</ul>
		</nav>
		</c:if>
	</main>
</body>
</html>


















