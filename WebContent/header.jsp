<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ようこそ</title>
</head>
<body>

<a href="/servlet/TopServlet?action=top">ホーム画面</a>
｜
<c:forEach items="${categories}" var="category">
<a href="/servlet/TopServlet?list&code=${category.code}">${category.name}</a>｜ 
</c:forEach>
<a href="/servlet/cart/CartServlet?action=show">カートを見る</a>
</body>
</html>