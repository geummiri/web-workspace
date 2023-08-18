<%@page import="member.model.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<%--
	MemberVO vo = (MemberVO) session.getAttribute("dto");
	
	if(vo!=null) {
	session.invalidate(); 
	
	--%>
<body onload="return logout()">
	
	<script>
		function logout() {
			alert('Logout!');
			location.href = "../index.jsp";
		}
	</script>

</body>

	<%-- } --%>

</html>