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
<h1>どこつぶログイン</h1>
<c:choose>
	<c:when test="${loginUser != null}">
		<p>ログインに成功しました</p><br>
		<p>ようこそ<c:out value="${loginUser.userId}"/>さん</p><br>
		<a href="MainServlet">つぶやき投稿・閲覧へ</a>
	</c:when>
	<c:otherwise>
		<p>ログインに失敗しました</p><br>
		<a href="LoginServlet">ログイン画面へ</a>
	</c:otherwise>
</c:choose>	
</body>
</html>