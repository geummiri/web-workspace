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
   	  width: 50px;
      height: 50px;
     }
     
     h1 {
   		text-align : center;
     }
     
     form {
   	  display:flex;
     	 justify-content:center;
   		  align-items:center;
     }
     
    </style>
  </head>
  <body>
    <h1>Fruit Total List</h1>
    <form>
    	<c:forEach items="${list}" var="item">
		<div>
		<a href=itemView.do><img src="${item.pictureUrl}"></a>
		${item.itemName}
		${item.price}
		</div>
		</c:forEach>
  
    </form>
  </body>
</html>
