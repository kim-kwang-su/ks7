<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./Update.html" method="post">
<input type="hidden" name="seq" value="${detail.SEQ}" />
<table>
	<tr>
		<td>글번호</td>
		<td>${detail.SEQ}</td>
	</tr>
	<tr>
		<td>조회수</td>
		<td>${detail.HIT}</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type="text" name="writer" value="<c:out value='${detail.WRITER}' />" /></td>
	</tr>
	<tr>
		<td>글제목</td>
		<td><input type="text" name="title" value="<c:out value='${detail.TITLE}' />" /></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name="content" style="width:200px; height:100px;"><c:out value='${detail.CONTENT}' /></textarea></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="수정">		
		<input type="button" value="목록" onclick="location.href='List.html'"></td>
	</tr>
</table>
</form>
</body>
</html>