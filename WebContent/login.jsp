<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Welcome Shopping!</title>
</head>
<body>
<c:if test="${!empty message}">
<h1 style="color:red">${message}</h1>
</c:if>
	
<form action="/Egg/LoginServlet" method="post">
	ユーザー名:<input type="text" name="username"><br>
	パスワード:<input type="password" name="userpassword">
	<input type="hidden" name="action" value="login"><br>
	<input type="submit" value="ログイン">
</form>

<a href="/Egg/InsertUserServlet?action=regist">新規登録はこちらをクリック</a>
<a href="/Egg">トップに戻る</a>
</body>
</html>