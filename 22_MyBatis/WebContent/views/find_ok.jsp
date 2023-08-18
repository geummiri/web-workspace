<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="member.model.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 검색 결과</h1>
	<%-- MemberDTO dto = (MemberDTO) request.getAttribute("dto");--%>
	
	<ul>
		<li>${vo.id}</li>
		<li>${vo.name}</li>
		<li>${vo.address}</li>
	</ul>
	<p><a href="index.jsp">화면으로가</a></p>
</body>
</html>