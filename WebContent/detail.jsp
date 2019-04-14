<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html lang="ja">
<head>
<jsp:include page="header.jsp"/>
    <body>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>
<body>
<h3>商品詳細</h3>
    <hr>
    <table><tr>
    <td>
      <img src="<c:url value="${product.imageUrl}"/>">
    </td>
    <td>
        <table border="1">
        <tr>
            
        </tr>
        <tr>
            <th>商品名</th><td><c:out value="${db_item_name}"/></td>
        </tr>
        <tr>
            <th>価格</th><td align="right">\<c:out value="${db_item_price}"/></td>
        </tr>
        <tr>
            <th colspan="2">商品説明</th>
        </tr>
        <tr>
            <td colspan="2"><c:out value="${product.description}"/></td>
        </tr>
        </table>
    </td>
    </tr></table>
    <hr>


<p><a href="http://localhost:8080/Egg/CartServlet?db_item_code=1">カートに入れる</a>
</body>
</html>