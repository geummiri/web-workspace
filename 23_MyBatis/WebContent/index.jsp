<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<body>
<!-- 
	첫 페이지 리스트 뿌려주기~ <%%>
	service 호출해서 list에 담아
	request.setAttribute로 바인딩
	 -->
	
	<input type="text" name="word"><button type="submit" onload="return search()">검색</button>

	<table border="1">
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>주소</th>
			<th>학과</th>
			<th>계열</th>
		</tr>
		
	
		
	
	<script>
	
		function search() {
			
		}
	
	</script>
	
	</table>	
</body>
</html>