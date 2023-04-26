<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<nav class="main_nav">
   <ul class="menu">
     <li class="menu_item active"><a href="${root}/list1">자유게시판1</a></li>
     <li class="menu_item"><a href="${root}/list2">자유게시판2</a></li>
     <li class="menu_item"><a href="${root}/list3">자유게시판3</a></li>
   </ul>
</nav> 