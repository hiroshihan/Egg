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
<c:if test="${empty cartList}">
現在、カートは空です。
</c:if>
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
<a href="javascript:void(0);" onclick="window.history.back();">前の画面に戻る</a>
<a href="http://localhost:8080/Egg/CompleteServlet?action=confirm">購入画面</a>
</body>
</html>