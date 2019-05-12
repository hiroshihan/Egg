<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form action="/Egg/LoginServlet" method="post">
	ユーザー名:<input type="text" name="username"><br>
	パスワード:<input type="password" name="userpassword">
	<input type="hidden" name="action" value="login"><br>
	<input type="submit" value="ログイン">
</form>

<a href="/Egg/InsertUserServlet?action=regist">新規登録はこちらをクリック</a>