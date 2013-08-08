<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Home</title>
</head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<script type="text/javascript" src='http://code.jquery.com/jquery-latest.js'></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){		
		
		$("#login").button().click(function(){
			
			if($.trim($("#userid").val()) == ""){
				alert("아이디를 입력하세요!");
				$("#userid").focus();
				return false;
			}
			
			if($.trim($("#userpwd").val()) == ""){
				alert("비밀번호를 입력하세요!");
				$("#userpwd").focus();
				return false;
			}
			
			$.ajax({
				url: "./ajaxLogin.html",
				type: "POST",
				data: $("#form").serialize(),
				dataType: "json",
				success: function(result, status){
					if(result && result.isSuccess){
						alert(result +"||"+ result.isSuccess +"||"+result.LOGIN_USER.USERID);
						//location.href = "./event/eventLove.html";
						$("#form").hide();
						$("#loginAfter").show();
						
					}else{
						alert(result.error_msg);
					}
				},
				error: function(){
					alert("로그인중 오류가 방생하였습니다.");
				}
				
			})
			
		})
	});
</script>
<body>
<c:if test="${LOGIN_USER == null}">
<!-- <form action="./Login.html" method="post"> -->

<form id="form">
<table border="1">
	<tr>
		<td><input type="text" name="userid" id="userid" tabindex="1"></td>
		<td rowspan="2"><input type="button" id="login" tabindex="3" value="LOGIN"></td>
	</tr>
	<tr>
		<td><input type="password" name="userpwd" id="userpwd" tabindex="2"></td>
	</tr>	
</table>
</form>

<!-- </form> -->
</c:if>


<div id="loginAfter">
<c:if test="${!empty LOGIN_USER}">
<c:forEach var="name" items="${pageContext.session.attributeNames}">
Name: ${name}
Value: ${sessionScope[name]} <br />
</c:forEach>
<br /><br />
<c:out value="${LOGIN_USER}" />
<br /><br />

<table border="1">
	<tr>
		<td>USERID : <c:out value="${LOGIN_USER.USERID}" /></td>
	</tr>
	<tr>
		<td>EMAIL : <c:out value="${LOGIN_USER.EMAIL}" /></td>
	</tr>
	<tr>
		<td><a href="./Logout.html">로그아웃</a></td>
	</tr>
</table>
</c:if>
</div>


<br />
<br />
<a href="./register/joinForm.html">REGISTER</a>
<br />
<a href="./event/eventLove.html">EVENT</a>
<br />
<a href="./board/List.html">BOARD</a>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
