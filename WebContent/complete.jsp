<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>登録完了</title>
</head>
<body>
<h1>以下の内容で登録されました。</h1>
<br>
<p>名前:			${user.db_user_name}</p>
<p>性別:			${user.db_user_gender}</p>
<p>住所: 			${user.db_user_post}</p>
<p>メールアドレス:	${user.db_user_email}</p>
<a href="/Egg/LoginServlet?action=login_view">ログインページへ</a>
<a href="/Egg">Topに戻る</a>
</body>
</html>