<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세페이지</title>
</head>
<body>
<table style="width:600px; " border="1">
	<tr>
		<td width="100px">글번호</td>
		<td width="500px"><c:out value="${detail.SEQ}" /></td>
	</tr>
	<tr>
		<td>조회수</td>
		<td><c:out value="${detail.HIT}" /></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><c:out value="${detail.WRITER}" /></td>
	</tr>
	<tr>
		<td>글제목</td>
		<td><c:out value="${detail.TITLE}" /></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><c:out value="${detail.CONTENT}" /></td>
	</tr>
	<tr>
		<td>첨부파일</td>
		<td><a href="./Download_file.html?seq=<c:out value="${detail.SEQ}" />"><c:out value="${detail.FILENAME}" /></a></td>
	</tr>
	<tr>
		<td>다음글</td>
		<td><a href="./View.html?seq=${prev.SEQ}"><c:out value="${prev.TITLE}" /></a></td>
	</tr>
	<tr>
		<td>이전글</td>
		<td><a href="./View.html?seq=${next.SEQ}"><c:out value="${next.TITLE}" /></a></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="수정" onclick="location.href='Update.html?seq=${detail.SEQ}'">
		<input type="button" value="삭제" onclick="location.href='Delete.html?seq=${detail.SEQ}'">
		<input type="button" value="목록" onclick="location.href='List.html'">
		</td>
	</tr>
</table>
</body>
</html>