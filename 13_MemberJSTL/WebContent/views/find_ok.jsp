<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "servlet.model.vo.MemberDTO" %>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<li>${dto.id}</li>
		<li>${dto.name}</li>
		<li>${dto.address}</li>
	</ul>
</body>
</html>