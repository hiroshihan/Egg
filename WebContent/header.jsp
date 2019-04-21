<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="/Egg/TopServlet?action=top">ホーム画面</a>
｜
<c:forEach items="${categories}" var="category">
<a href="/Egg/CategoryServlet?action=list&code=${category}">${category}</a>｜
</c:forEach>
<a href="/Egg/CartListServlet?action=show">カートを見る</a>