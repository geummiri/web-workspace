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

	<h2>회원 정보 수정</h2>
	<form action="/UpdateServlet" method="post">
		ID : <input type="text" value="${dto.id}" name="id" readonly> <br>
		PASSWORD : <input type="password" value="${dto.password}" name="password"> <br>
		NAME : <input type="text" value="${dto.name}" name="name"> <br>
		ADDRESS : <input type="text" value="${dto.address}" name="address"> <br>
		<input type="submit" value="정보수정">
	</form>
	
</body>
</html>