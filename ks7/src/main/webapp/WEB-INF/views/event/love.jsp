<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EVENT LOVE</title>
<link rel="stylesheet" type="text/css" href="/ks/resources/css/event/love.css" />
<script type="text/javascript" src='http://code.jquery.com/jquery-latest.js'></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btn").click(function(){
			var user = '<c:out value="${LOGIN_USER.USERID}" />';
			if(user == ""){
				alert("로그인 해주세요!");
				location.href = "/ks/home.html"					
				return;
			}else{
				if($("#contents").val() == ""){
					alert("덧글을 입력해주세요!");
					return;					
					
				}else{
				
					$("#thisForm").attr("action","./eventLoveInsert.html");
					$("#thisForm").submit();				
					
				}
			}
			
		})	
	});
</script>
</head>
<body leftmargin="0" topmargin="0" onload="MM_preloadImages('/ks/resources/image/event/love/event01_off_best.jpg')">
<br />
<a href="/ks/home.html">MAIN</a> &nbsp;&nbsp;&nbsp;&nbsp; 
<a href="/ks/event/eventLove.html">EVENT</a> &nbsp;&nbsp;&nbsp;&nbsp; 
<a href="/ks/board/List.html">BOARD</a>
<br /><br />
<div class="event">

	<div><img src="/ks/resources/image/event/love/event02_title.jpg" alt="5월 감사의 달 감사 BIG이벤트" /></div>
	
	<!-- 전광판 -->
	<div class="todaywords">
		<dl>
			<dt>최지은 학생</dt>
			<dd><img src="/ks/resources/image/event/love/icn_heart.gif" alt="하트" />오늘 출근하시는 아빠의 구두를 닦아 드렸다.</dd>
		</dl>
	</div>
	<!-- 전광판 -->
	
	<!-- 이벤트탭 -->
	<ul class="eventmaintab2">
		<li class="off"><a href=""><img src="/ks/resources/image/event/love/event01_off.jpg" alt="우리 공부방이 최고야" name="m1" id="m1" onmouseover="MM_swapImage('m1','','/ks/resources/image/event/love/event01_off_best.jpg',1)" onmouseout="MM_swapImgRestore()" /></a></li>
		<li><img src="/ks/resources/image/event/love/event02_on.jpg" alt="우리 공부방이 최고야" /></li>
	</ul>
	<!-- 이벤트탭 -->

	<div><img src="/ks/resources/image/event/love/event02_info.jpg" alt="이벤트정보관련 이미지" /></div>
	
	

	
	<!-- 커뮤니티 생성 게시판 시작 -->
	<div class="event_board">
		<div class="btitle_part2">
		<form method="post" id="thisForm" >
			<input name="contents" id="contents" type="text" class="eventinput03" /><img id="btn" src="/ks/resources/image/event/love/btn_todaywords.jpg" alt="등록하기" />
		</form>
		</div>
		<div class="blist2">
			
			<table width="570" border="0" cellspacing="0" cellpadding="0">
				
				<c:forEach var="vo" items="${getLoveList}">
				<tr>
					<td align="center">
						<table width="570" border="0" cellspacing="0" cellpadding="0" style="font-size:12px;">
							<tr>
								<td width="519" align="left" style="padding:10px 0 5px 0;"><span style="font-size:12px;font-weight:bold;color:#4b4b4b;"><span style="color:#990000;">101.</span><c:out value="${vo.USERNAME}" />(<c:out value="${vo.USERID}" />)</span> <span style="font-size:11px;color:828282;"><fmt:formatDate value="${vo.REGDATE}" pattern="yyyy.MM.dd"/></span></td>
								<td width="91" align="right" style="padding:10px 0 5px 0;"><img src="/ks/resources/image/event/love/btn_del.jpg" /></td>
							</tr>
							<tr>
								<td colspan="2" align="left" style="padding:2px 0 10px 0;color:#4b4b4b;word-break:break-all;line-height:140%;"><c:out value="${vo.CONTENTS}" /></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td background="/ks/resources/image/event/love/bg_twodot.jpg"><img src="img/blank_dot.gif" width="1" height="1" /></td>
				</tr>
				</c:forEach>	
						
			</table>
			
			<!-- 페이징 -->
			<ul class='pagenum'>
				<li class="none"><a href="JavaScript:go_page('1');"><img src="/ks/resources/image/event/love/btn_prevend.gif" alt='처음페이지로' border='0' /></a></li>
				<li class="none"><a href="JavaScript:go_page('9');"><img src="/ks/resources/image/event/love/btn_prev.gif" alt="이전페이지로" border="0" /></a></li>
				<li><a href="JavaScript:go_page('1')">1</a></li>
				<li><a href="JavaScript:go_page('2')">2</a></li>
				<li><a href="JavaScript:go_page('3')">3</a></li>
				<li><a href="JavaScript:go_page('4')">4</a></li>
				<li><a href="JavaScript:go_page('5')">5</a></li>
				<li><a href="JavaScript:go_page('6')">6</a></li>
				<li><a href="JavaScript:go_page('7')">7</a></li>
				<li><a href="JavaScript:go_page('8')">8</a></li>
				<li><a href="JavaScript:go_page('9')">9</a></li>
				<li class="none"><a href="JavaScript:go_page('10');"><span class="current">10</span></a></li>
				<li class="none"><a href="JavaScript:go_page('11');"><img src="/ks/resources/image/event/love/btn_next.gif" alt="다음페이지로" border="0" /></a></li>
				<li class="none"><a href="JavaScript:go_page('143');"><img src="/ks/resources/image/event/love/btn_nextend.gif" alt="마지막페이지로" border="0" /></a></li>
			</ul>
			<!-- 페이징 -->
			
		</div>
		<div class="bbtm2"></div>
	</div>
	<!-- 커뮤니티 생성 게시판 끝 -->
	
	
</div>
</body>
</html>