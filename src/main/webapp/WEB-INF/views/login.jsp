<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jpa Project</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#username').val('');
		$('#username').focus();
	});
function validate(){

	var uname = $('#username').val();
	var pass = $('#password').val();
	
	if(uname == ""){
		alert("Username Should Not Be Empty");
		$('#username').focus();
		return false;
	}
	
	if(pass == ""){
		alert("Password Shoult Not Be Empty");
		$("#password").focus();
		return false;
	}
}


</script>
</head>
<body>
<script>
    var secondsBeforeExpire = ${pageContext.session.maxInactiveInterval};
    var timeToDecide = 15; // Give client 15 seconds to choose.
    setTimeout(function() {
        alert('Your session is about to timeout in ' + timeToDecide + ' seconds!')
    }, (secondsBeforeExpire - timeToDecide) * 1000);
</script>
<h1 align="center">Login</h1>
<form action="${pageContext.request.contextPath}/login/login" method="post" onsubmit="return validate()" modelAttribute="login">
<table align="center">
	<tr>
		<td>UserName:</td>
		<td><input type="text" name="username" id="username"/></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="password" name="password" id="password"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="Login"/>
			<input type="reset" value="Reset"/>		
		</td>
	</tr>
</table>
</form>
</body>
</html>