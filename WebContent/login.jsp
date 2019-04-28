<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${isLogin eq true}">

</c:if>

<c:if test="${isLogin eq false}">
<form action="/Egg/LoginServlet" method="post">
	ユーザー名:<input type="text" name="username"><br>
	パスワード:<input type="password" name="password">
	<input type="hidden" name="action" value="login"><br>
	<input type="submit" value="ログイン">
</form>
</c:if>
