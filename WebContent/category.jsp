<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品一覧</title>
</head>
<body>

<jsp:include page="/header.jsp" />

<h3>商品一覧</h3>


	<form action="/Egg/CartServlet?action=add" method="post">
		<table border="1">
			<tr>
				<th>コード</th>
				<th>商品名</th>
				<th>価格</th>
				<th>カテゴリー</th>
				<th>個数</th>
			</tr>
		<c:forEach items="${items}" var="item">
			<tr>
				<input type="hidden" name="item_code" value="${item.db_item_code}">	
				<td><b>${item.db_item_code}</b></td>
				<td><b>${item.db_item_name}</b></td>
				<td><b>${item.db_item_price}円</b></td>
				<td><b>${item.db_item_category}</b></td>
				<td>：
				<select name="quantity">
				<option value="1">1
				<option value="2">2
				<option value="3">3
				<option value="4">4
				<option value="5">5
				</select>
				個<br>
				</td>
				<td><input type="submit" value="カートに追加"></td>
			</tr>			
	  </c:forEach>
	 </table>
	</form>
</body>
</html>