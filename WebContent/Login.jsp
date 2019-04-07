<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<c:if test="${isLogin eq true}">

</c:if>

<c:if test="${isLogin eq false}">
<form action="/egg/LoginServlet" method="post">
	ユーザー名:<input type="text" name="username"><br>
	パスワード:<input type="password" name="password">
	<input type="hidden" name="action" value="login">
	<input type="submit" value="ログイン">
	
</form>
</c:if>
</body>
</html>