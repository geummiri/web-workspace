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
		<c:when test= "${vo eq null}">
	
	<h1>회원 관리 기능</h1>
	
	<ul>
	<%--로그인 되어 있지 않은 경우 --%>
		<li><a href="views/register.html">회원가입</a></li>
		<li><a href="views/login.html">로그인</a></li>
		</c:when>
		
	<%--로그인 된 경우 --%>	
		<c:otherwise>
		<li><a href="views/search.html">회원검색</a></li>
		<li><a href="front.do?command=allMember">전체회원보기</a></li>
		<li><a href="front.do?command=logout">로그아웃</a></li>
		<li><a href="views/update.jsp">회원정보 수정</a></li>
		</c:otherwise>
		</c:choose>
	</ul>
</body>
</html>