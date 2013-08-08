<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<script type="text/javascript" src='http://code.jquery.com/jquery-latest.js'></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//$(":input[name='email3']").attr("disabled", true);
	});
	
	function goSubmit(){
		
		if(!checkSpace($('#userid'),"아이디를 입력해 주세요!"))return;
		if(!checkSpace($('#userpwd'),"비밀번호를 입력해 주세요!"))return;
		if(!checkSpace($('#username'),"이름을 입력해 주세요!"))return;
		
		if(!checkSpace($('#byear'),"생년월일을 선택해 주세요!"))return;
		if(!checkSpace($('#bmonth'),"생년월일을 선택해 주세요!"))return;
		if(!checkSpace($('#bday'),"생년월일을 선택해 주세요!"))return;
		
		var bmonth = $("#bmonth").val();
		var bday = $("#bday").val();
		if(bmonth.length < 2){
			bmonth = "0"+bmonth;
		}
		if(bday.length < 2){
			bday = "0"+bday;
		}
		
		$("#birth").val($("#byear").val() +"-"+ bmonth +"-"+ bday);
		
		if($(":radio[name='birth_fl']:checked").length < 1){
			alert("음력 , 양력을 선택해 주세요!");
			$("#birth_fl").focus();			
			return false;
		}
		
		
		/* 
		if(!$(":radio[name='birth_fl']:checked").val()){
			alert("음력 , 양력을 선택해 주세요!");
		} */
		
		if(!checkSpace($('#address'),"주소를 입력해 주세요!"))return;
		if($("#job").val() == "0"){
			alert("직업을 선택해 주세요!");
			$("#job").focus()
			return false;
		}
		
		if(!checkSpace($('#home_tel1'),"전화번호를 입력해 주세요"))return;
		if(!checkSpace($('#home_tel2'),"전화번호를 입력해 주세요"))return;
		if(!checkSpace($('#home_tel3'),"전화번호를 입력해 주세요"))return;
		if(!checkNum($('#home_tel1'),"전화번호는 숫자만 입력하세요"))return;
		if(!checkNum($('#home_tel2'),"전화번호는 숫자만 입력하세요"))return;
		if(!checkNum($('#home_tel3'),"전화번호는 숫자만 입력하세요"))return; 
		
		$("#home_tel").val($("#home_tel1").val() + "-" + $("#home_tel2").val() + "-" + $("#home_tel3").val());
		
		if(!checkSpace($('#sel_hand_tel_agency'),"통신사를 입력해 주세요"))return;
		if(!checkSpace($('#sel_hand_tel1'),"휴대전화를 입력해 주세요"))return;
		if(!checkSpace($('#hand_tel2'),"휴대전화를 입력해 주세요"))return;
		if(!checkSpace($('#hand_tel3'),"휴대전화를 입력해 주세요"))return;
		if(!checkNum($('#sel_hand_tel1'),"휴대전화는 숫자만 입력하세요"))return;
		if(!checkNum($('#hand_tel2'),"휴대전화는 숫자만 입력하세요"))return;
		if(!checkNum($('#hand_tel3'),"휴대전화는 숫자만 입력하세요"))return;
		
		$("#hand_tel").val($("#sel_hand_tel1").val() +"-"+ $("#hand_tel2").val() +"-"+ $("#hand_tel3").val());
				
		if(!checkSpace($('#email1'),"이메일을 입력해 주세요"))return;
		if(!checkSpace($('#email3'),"이메일을 입력해 주세요"))return;
		
		$("#email").val($('#email1').val() +"@"+ $('#email3').val());		
		
		if($("input:checkbox[id='chk_dm_fl']:checked").length < 1){
			alert("정보 메일 수신동의(이벤트, 뉴스등) 체크해 주세요!");
			$("input:checkbox[id='chk_dm_fl']").focus();
			return false;
		}else{
			$("#dm_fl").val("Y");
		}
		
		
		if($("input:checkbox[id='chk_ds_fl']").is(":checked") == false){
			alert("SMS 수신동의 체크해 주세요!");
			$("input:checkbox[id='chk_ds_fl']").focus();
			return false;
		}else{
			 $("#ds_fl").val("Y");
		}		
		
		if(confirm("회원등록을 진행합니다.")){
			$("#f").attr("action","./joinProcess.html");
			$("#f").submit();
		}
	}	
	
	function checkEmailState(){
		
		var email = $("#email2 > option:selected").val();
		if(email == "WRITE"){
			$("#email3").val("");
			$("#email3").focus();
			$("#email3").attr("disabled",false);
		}else{
			$("#email3").val(email);
			$("#email3").attr("disabled",true);
		}
	}	
	
	function checkSpace(frm, strMsg) {
		
		if($.trim($(frm).val()) == ""){
			alert(strMsg);
			$(frm).focus();
			return false;
		}
		
		return true;
	}
	
	function checkNum(frm,strMsg){
		var strNum = frm.val();
		if (isNaN(strNum)){
			alert(strMsg);
			frm.val("");
			frm.focus();
			return false;
		}
		return true;
	}
	
</script>
</head>
<body>
<form name="f" id="f" method="post" >
<input type="hidden" name="birth" id="birth" />
<input type="hidden" name="home_tel" id="home_tel" />
<input type="hidden" name="hand_tel" id="hand_tel" />
<input type="hidden" name="email" id="email" />
<input type="hidden" name="dm_fl" id="dm_fl" />
<input type="hidden" name="ds_fl" id="ds_fl" />
<table border="1">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="userid" id="userid" /></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" name="userpwd" id="userpwd" /></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="username" id="username" /></td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td>
			<select name="byear" id="byear">
				<option value="1970" >1970</option>
				<option value="1971" >1971</option>
				<option value="1972" >1972</option>
				<option value="1973" >1973</option>
				<option value="1974" >1974</option>
				<option value="1975" >1975</option>
				<option value="1976" >1976</option>
				<option value="1977" >1977</option>
				<option value="1978" >1978</option>
				<option value="1979" >1979</option>
				<option value="1980" >1980</option>
				<option value="1981" >1981</option>
				<option value="1982" >1982</option>
				<option value="1983" >1983</option>
				<option value="1984" >1984</option>
				<option value="1985" >1985</option>
				<option value="1986" >1986</option>
				<option value="1987" >1987</option>
				<option value="1988" >1988</option>
				<option value="1989" >1989</option>
				<option value="1990" >1990</option>
				<option value="1991" >1991</option>
				<option value="1992" >1992</option>
				<option value="1993" >1993</option>
				<option value="1994" >1994</option>
				<option value="1995" >1995</option>
				<option value="1996" >1996</option>
				<option value="1997" >1997</option>
				<option value="1998" >1998</option>
				<option value="1999" >1999</option>
				<option value="2000" >2000</option>
			</select>
			
			<select style="width:60px;" name="bmonth" id="bmonth">
				<option value="" >선택</option>
				<option value="01" >01</option>
				<option value="02" >02</option>
				<option value="03" >03</option>
				<option value="04" >04</option>
				<option value="05" >05</option>
				<option value="06" >06</option>
				<option value="07" >07</option>
				<option value="08" >08</option>
				<option value="09" >09</option>
				<option value="10" >10</option>
				<option value="11" >11</option>
				<option value="12" >12</option>
			</select>
			
			<select style="width:60px;" name="bday" id="bday">
				<option value="" >선택</option>
				<option value="01" >01</option>
				<option value="02" >02</option>
				<option value="03" >03</option>
				<option value="04" >04</option>
				<option value="05" >05</option>
				<option value="06" >06</option>
				<option value="07" >07</option>
				<option value="08" >08</option>
				<option value="09" >09</option>
				<option value="10" >10</option>
				<option value="11" >11</option>
				<option value="12" >12</option>
				<option value="13" >13</option>
				<option value="14" >14</option>
				<option value="15" >15</option>
				<option value="16" >16</option>
				<option value="17" >17</option>
				<option value="18" >18</option>
				<option value="19" >19</option>
				<option value="20" >20</option>
				<option value="21" >21</option>
				<option value="22" >22</option>
				<option value="23" >23</option>
				<option value="24" >24</option>
				<option value="25" >25</option>
				<option value="26" >26</option>
				<option value="27" >27</option>
				<option value="28" >28</option>
				<option value="29" >29</option>
				<option value="30" >30</option>
				<option value="31" >31</option>
			</select>
			
		</td>
	</tr>
	<tr>
		<td>양력/음력</td>
		<td>음력1 : <input type="radio" id="birth_fl" name="birth_fl" value="S1"  />
			음력2 : <input type="radio" id="birth_fl" name="birth_fl" value="S2"  />
			양력1 : <input type="radio" id="birth_fl" name="birth_fl" value="M1"  />
			음력2 : <input type="radio" id="birth_fl" name="birth_fl" value="M2"  />
		</td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type="text" name="address" id="address" /></td>
	</tr>
	<tr>
		<td>직업</td>
		<td>
			<select name="job" id="job" style="width:135px;">
				<option value="0">선택</option>
				<option value="중고생" >중고생</option>
				<option value="대학(원)생" >대학(원)생</option>
				<option value="회사원" >회사원</option>
				<option value="주부" >주부</option>
				<option value="자영업" >자영업</option>
				<option value="공무원" >공무원</option>
				<option value="교직자" >교직자</option>
				<option value="의료인" >의료인</option>
				<option value="언론인" >언론인</option>
				<option value="예술인" >예술인</option>
				<option value="전문직" >전문직</option>
				<option value="군인" >군인</option>
				<option value="경찰" >경찰</option>
				<option value="종교인" >종교인</option>
				<option value="무직" >무직</option>
				<option value="기타" >기타</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" name="home_tel1" id="home_tel1" maxlength="3" class="input2" style="width:58px;" /> - 
		<input type="text" name="home_tel2" id="home_tel2" maxlength="4" class="input2" style="width:58px;" /> - 
		<input type="text" name="home_tel3" id="home_tel3" maxlength="4" class="input2" style="width:58px;" /></td>
	</tr>
	<tr>
		<td>휴대폰번호</td>
		<td>	
		<select name="sel_hand_tel_agency" id="sel_hand_tel_agency" style="width:70px;">
			<option value="">선택</option>
		    <option value="SKT" >SKT</option>
		    <option value="LGT" >LGT</option>
		    <option value="KTF" >KT</option>
		</select> 
		<select name="sel_hand_tel1" id="sel_hand_tel1" style="width:70px;">
			<option value="010" >010</option>
		    <option value="011" >011</option>
		    <option value="016" >016</option>
		    <option value="017" >017</option>
		    <option value="018" >018</option>
		    <option value="019" >019</option>
		</select> - 
		<input type="text" name="hand_tel2" id="hand_tel2" maxlength="4" class="input2" style="width:58px;" /> -
		<input type="text" name="hand_tel3" id="hand_tel3" maxlength="4" class="input2" style="width:58px;" /> 		
		</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email1" id="email1" />@ 
		<input type="text" name="email3" id="email3" />
		<select name="email2" id="email2" onchange="checkEmailState()" style="width:111px;">
			<option value="">메일주소선택</option>
			<option value="chollian.net"  >chollian.net</option>
			<option value="dreamwiz.com"  >dreamwiz.com</option>
			<option value="empal.com"  >empal.com</option>
			<option value="hanafos.com"  >hanafos.com</option>
			<option value="hanmail.net"  >hanmail.net</option>
			<option value="hanmir.com"  >hanmir.com</option>
			<option value="hotmail.com"  >hotmail.com</option>
			<option value="korea.com"  >korea.com</option>
			<option value="lycos.co.kr"  >lycos.co.kr</option>
			<option value="msn.com"  >msn.com</option>
			<option value="nate.com"  >nate.com</option>
			<option value="naver.com"  >naver.com</option>
			<option value="netian.com"  >netian.com</option>
			<option value="WRITE"  selected  >직접입력</option>
		</select>
		</td>
	</tr>
	<tr>
		<td>정보수신</td>
		<td><input type="checkbox" id="chk_dm_fl" name="chk_dm_fl" /> 정보 메일 수신동의(이벤트, 뉴스등)
			<input type="checkbox" id="chk_ds_fl" name="chk_ds_fl" /> SMS 수신동의
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="button" value="등록" onclick="goSubmit();"></td>		
	</tr>
</table>
</form>
</body>
</html>