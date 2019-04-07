<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Eggs Shopping Site</title>
</head>
<body>
<!-- comment add -->
 <table>
  <tr>
   <td colspan="2">
    <%@ include file="/header.html" %>
   </td>
  </tr>
  <tr>
   <td bgcolor="#AFEEEE">
    <jsp:include page="/top.jsp" />
   </td>
  </tr>
 </table>

 <jsp:include page="/menu.jsp"></jsp:include>
<hr>

</body>
</html>