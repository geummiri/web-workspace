<%@page import="edu.kh.test.user.model.vo.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보</h2>
	
	<table border="1">
		<tr>
			<th>회원번호</th>
			<th>회원아이디</th>
			<th>회원이름</th>
			<th>회원나이</th>
		</tr>
		
	<% UserDTO dto = (UserDTO) request.getAttribute("dto"); %>
		
		<tr>
			<td><%=dto.getUserNo()%></td>
			<td><%=dto.getUserName()%></td>
			<td><%=dto.getUserId()%></td>
			<td><%=dto.getUserAge()%>></td>
		</tr>
	
	</table>
	<a href="index.jsp">메인페이지로 돌아가기</a>
</body>
</html>