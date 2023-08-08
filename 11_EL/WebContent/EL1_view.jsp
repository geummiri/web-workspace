<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h2>Attribute에 바인딩된 값을 받아옴</h2>
	
	<h3>1~50까지의 합산 결과 값 1)</h3>
	<%=
		request.getAttribute("result")
	%>
	
	<%-- 
		EL(Expression Language)
		- Attribute에 바인딩된 값을 찾아오는 로직을 태그로 바꾼 기술
		- 객체를 바인딩한 ${이름}이 사용된다.
	 --%>
	 
	<h3>1~50까지의 합산 결과 값 2) EL</h3>
	<p>request : ${requestScope.result}</p>
	<p>session : ${sessionScope.result}</p>
	<p>request : ${result}</p>
	<%-- request는 requestScope값 생략 가능 25, 27번째줄 값 동일 --%>
</body>
</html>