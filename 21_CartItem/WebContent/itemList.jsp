<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="model.Item"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
     img {
   	 width: 150px;
     height: 150px;
     object-fit : cover;
     }
     
     h1 {
   	 text-align : center;
     }
     
     #container {
     display :flex;
     justify-content :center;
     }
    
    
    </style>
  </head>
  <body>
    <h1>Fruit Total List</h1>
    <div id="container">
   		<c:forEach items="${list}" var="item">
		
		<div>
			<a href="itemView.do?id=${item.itemId}">
			<img src="${item.pictureUrl}"></a>
			<p>${item.itemName}</p>
			<p>${item.price}</p>
		</div>
		
		</c:forEach>
    </div>
   	<hr>
   	<h1>오늘 본 상품들</h1>
   	 <div id="container">
   	<c:if test="${not empty fruits}">
 	
   	<table>
   		<c:forEach items="${fruits}" var = "fruit">
   		<td>
   		 <img src="${fruit}" >
   		 </td>
   		</c:forEach>
   	</table>
   	
   	</c:if>
   	</div>

  </body>
</html>
