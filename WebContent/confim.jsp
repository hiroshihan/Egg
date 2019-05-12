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

<%--購入商品リスト --%>
	<form action="/Egg/CompleteServlet" method="post">
		<input type="submit" value="購入">
	</form>
</body>
</html>