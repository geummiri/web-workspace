<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Lifecycle CallBack Method..</h3>

	<p> <%= request.getParameter("name") %>님이 <%= request.getParameter("count") %> 번째 등장</p>
	
</body>
</html>