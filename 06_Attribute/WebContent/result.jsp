<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- MemberVO import해주기 --%>
<%@ page import="servlet.model.MemberVO" %>


<!--  % % : : Scriptlet Element -->
<%
	MemberVO vo = (MemberVO) application.getAttribute("vo");
					//객체이기 때문에 형변환 해주기

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
JSP Element
1) 지시어 %@ % : 컨테이너에게 알려줄 내용을 지정
2) 스크립트릿 % % : 자바코드는 이 안에 지정
3) 출력문 %= % : 출력하려는 내용 지정
 
 페이지 소스 보기에서 안보여짐
 --%>
 		
 		<!--  %= % :: Expression Element -->
 		<h2>회원님의 정보를 출력합니다</h2>
		<p>이름 : <%= vo.getName() %> </p>
		<p>나이 : <%= vo.getAge() %> </p>
		<p>주소 :  <%= vo.getAddr() %> </p>
	
</body>
</html>