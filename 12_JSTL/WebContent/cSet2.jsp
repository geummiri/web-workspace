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
	<%--라이브러리 필요함 --%>
	<c:set var="CODE" value="1004" scope="request"/>
	<c:set var="NAME" value="kh" scope="request"/>
	<c:set var="PRICE" value="220000" scope="request"/>
	
	<%--라이브러리 필요없이 생성 가능 --%>
	<jsp:forward page= "cSet2_view.jsp"/>
	
</body>
</html>