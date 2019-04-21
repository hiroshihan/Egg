<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>登録の確認</title>
</head>
<body>
<h2>以下の登録内容でよろしいでしょうか？</h2>
<p>名前				${userBean.db_user_name}</p>
<p>性別				${userBean.db_user_gender}</p>
<p>住所 			${userBean.db_user_post}</p>
<p>メールアドレス	${userBean.db_user_email}</p>
<p>パスワード		********</p>
<br>
<form action="/Egg/InsertUserServlet" method="post">
<input type="submit"value="登録">
</form>
<form action="/Egg/ConfirmInsertUserServlet" method="post">
<input type="submit"value="登録画面に戻る">
</form>
</body>
</html>