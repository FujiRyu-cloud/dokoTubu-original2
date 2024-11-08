<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<c:out value="${userId}"/>さん、ログイン中
<a href="Logout">ログアウト</a>
</p>
<p><a href="MainServlet">更新</a></p>
<form action="MainServlet" method="post">
<input type="text" name="text"><br>
<input type="submit" value="つぶやく">
</form>
<c:if test="${not empty errorMsg}">
	<p><c:out value="${errorMsg}"/></p>
</c:if>
<c:forEach var="mutter" items="${mutterList}">
	<p><c:out value="${mutter.name}"/>:
	   <c:out value="${mutter.text}"/></p>
</c:forEach>
</body>
</html>