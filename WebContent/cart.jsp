<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>カート画面</title>
</head>
<body>
<h1>カートの中身</h1>
<c:if test="${empty cart.items}">
現在、カートは空です。
</c:if>
<p>${itembean.db_item_code}</p>
<p>${itembean.db_item_name}</p>
<p>${itembean.db_item_price}</p>
<p>${itembean.db_item_category}</p>
<a href="http://localhost:8080/Egg/confim.jsp">購入画面</a>
</body>
</html>