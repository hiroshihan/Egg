<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Welcome Shopping!</title>
</head>
<body>

	<jsp:include page="/header.jsp"/>

	<h1>ようこそ！Eggs ショッピングサイトへ！</h1>
	<p></p>
	<p></p>
	<h2>商品一覧</h2>
	<table border="1">
		<tr>
			<th>コード</th>
			<th>商品名</th>
			<th>価格</th>
			<th>カテゴリー</th>
			<th>レビュー</th>
		</tr>
		<c:forEach items="${items}" var="item">
			<tr>
				<td>${item.db_item_code}</td>
				<td>${item.db_item_name}</td>
				<td>${item.db_item_price}</td>
				<td>${item.db_item_category}</td>
				<td>${item.db_item_review}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>