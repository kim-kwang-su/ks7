<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>목록페이지</title>
<script type="text/javascript" src='http://code.jquery.com/jquery-latest.js'></script>
<script type="text/javascript">
$(document).ready(function(){	
	
	if('${title}' != ""){
		$("input[name='title']").attr("checked",true);
	}
	if('${writer}' != ""){
		$("input[name='writer']").attr("checked",true);
	}
	if('${content}' != ""){
		$("input[name='content']").attr("checked",true);
	}
});
</script>

</head>
<body>
<!--
한글 깨질때 
1. java.net.URLDecoder.decode("한글깨지는 값", "UTF-8");

2. server.xml에서 각 Connector에 추가
- <Connector connectionTimeout="20000" port="8010" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/> 
- <Connector port="8900" protocol="AJP/1.3" redirectPort="8443" URIEncoding="UTF-8"/>       
 -->


<br />
<a href="/ks/home.html">MAIN</a> &nbsp;&nbsp;&nbsp;&nbsp; 
<a href="/ks/event/eventLove.html">EVENT</a> &nbsp;&nbsp;&nbsp;&nbsp; 
<a href="/ks/board/List.html">BOARD</a>
<br /><br />
<table border="1" cellpadding="0" cellspacing="0" width="600px">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>등록일</th>
	</tr>	
	<c:forEach var="vo" items="${list}">	
	<tr height="25px;">
		<td>${vo.SEQ}</td>
		<td><a href="./View.html?seq=${vo.SEQ}">${vo.TITLE}</a></td>
		<td>${vo.WRITER}</td>
		<td>${vo.HIT}</td>
		<td>${vo.REGDATE}</td>
	</tr>
	</c:forEach>
</table>
<br /><br />
<div>
     <!-- 검색조건 받은것을 변수에 담아서 처리. -->
     <c:set var="pms" value="&writer=${ writer }&title=${ title }&content=${ content }&keyword=${ keyword }"/>
     <c:forEach var="i" begin="1" end="${ totalPageCount }">
         <c:if test="${ pageNum== i }">
             <span style="color:red"><a href="boardList.htm?pageNum=${ i }${ pms }">[${ i }]</a></span>
         </c:if>
         <c:if test="${ pageNum!= i }">
             <span><a href="boardList.htm?pageNum=${ i }${ pms }">[${ i }]</a></span>
         </c:if>
     </c:forEach>
 </div>
<br /><br />
<form action="boardList.htm">
<input type="checkbox" id="title" name="title" value="title" />제목
<input type="checkbox" id="writer" name="writer" value="writer" />작성자
<input type="checkbox" id="content" name="content" value="content" />내용
<input type="text" id="keyword" name="keyword" value="${keyword}" />
<input type="submit" value="검색" />
</form>
<br /><br />
<a href="./Write.html">쓰기 </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="./List.html">목록 </a>
</body>
</html>