<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<c:choose>
<c:when test="${!empty dto}">
	
	<h1>수정 정보</h1>
	<ul>
		<li>${dto.id} 님의 정보를 수정했습니다.</li>
	</ul>
	<a href="/index.jsp">첫 페이지로 이동</a>
	
</c:when>
<c:otherwise>

	<h3>수정실패</h3>
	<a href="/login.html">login.html</a>
	
</c:otherwise>
</c:choose>
	
</body>
</html>