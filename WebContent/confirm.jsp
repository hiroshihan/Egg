<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>最終確認</title>
</head>
<body>
<h1>下記商品を購入でよろしいですか？</h1>
<table border="1">
<tr>
<th>商品名</th>
<th>カテゴリー</th>
<th>注文数</th>
<th>合計価格</th>
</tr>
<c:forEach items="${cartList}" var="item">
<tr>
<td>${item.db_item_name}</td>
<td>${item.db_item_category}</td>
<td>${item.quantity}</td>
<td>${item.totalprice}円</td>
</tr>
</c:forEach>
</table>
<a href="http://localhost:8080/Egg/CompleteServlet?action=end">購入完了</a>
</body>
</html>