<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Item"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
    
    a {
    text-align : right;
    }
    
    </style>
  </head>
  <body>
    <h1>장바구니</h1>
    
     <a href="itemList.do">쇼핑 계속하기</a>
     
    <table border="1">
    <tr>
     <th>번호</th>
      <th>상품이미지</th>
      <th>상품명</th>
       <th>상품가</th>
        <th>수량</th>
     	  <th><button>삭제</button></th>
    </tr>
    
    <tr>
     <td>${localStorage.getItem}</td>
     <td>${item.itemId}</td>
     <td>${item.itemId}</td>
     <td>${item.itemId}</td>
     <td>${item.count}</td>
     <td><input type="checkbox"></td>
    </tr>
    
	</table>   
  </body>
</html>
