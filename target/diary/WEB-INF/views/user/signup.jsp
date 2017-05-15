<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%--以上标签必须放在最上 否则无法在移动端正常显示--%>
	<title>注册</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
	<style>
		.errorMsg {
			color: red;
		}
	</style>
</head>
<body>
<div class="container col-lg-8 col-lg-offset-2 ">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<%=request.getContextPath()%>/sys/home">VOTE</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="<%=request.getContextPath()%>/user/login">登录</a></li>
				<li><a href="<%=request.getContextPath()%>/sys/help">帮助</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<br>
	<div class="container col-lg-10 col-lg-offset-1">
		<form class="form-horizontal  col-md-4 col-md-offset-1 col-lg-6 col-lg-offset-0" method="post" action="signUp"
		      style="margin-top: 20px;">
			<fieldset>
				<legend>注册</legend>
				<br>
				<div class="form-group">
					<label for="inputUsername" class="col-lg-3 control-label">用户名</label>
					<div class="col-lg-9">
						<input type="text" class="form-control" id="inputUsername" name="username" required="required" maxlength="16" min="3">
						<div class="errorMsg"><form:form commandName="user"><form:errors
								path="username"></form:errors></form:form></div>
					</div>

				</div>
				<div class="form-group">
					<label for="inputEmail" class="col-lg-3 control-label">邮箱</label>
					<div class="col-lg-9">
						<input type="email" class="form-control" id="inputEmail" name="email" required="required" maxlength="16">
						<div class="errorMsg">
							<form:errors path="userDto"></form:errors>
							${errorMessage}
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPwd" class="col-lg-3 control-label">密码</label>
					<div class="col-lg-9">
						<input type="password" class="form-control" id="inputPwd" name="password" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPwd2" class="col-lg-3 control-label">确认</label>
					<div class="col-lg-9">
						<input type="password" class="form-control" id="inputPwd2" required="required">
						<div id="pwdMsg" class="errorMsg"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-8 col-lg-offset-2">

					</div>
					<div class="col-lg-8 col-lg-offset-2">
						<button type="submit" id="subBtn" class="btn btn-primary">注册<span
								class="glyphicon glyphicon-play"></span></button>
					</div>
				</div>
				<hr>
			</fieldset>

		</form>
		<div class="form-horizontal  col-lg-6  col-md-5 hidden-sm hidden-xs">
			<div class="jumbotron">
				<h3>注册</h3>
				<p>注册一个新账号<br>
					请使用邮箱地址和密码登录</p>
			</div>
		</div>
	</div>
</div>
</body>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
<script>
	$(function(){
		var pwdEqual=false;
		$("#inputPwd2,#inputPwd").keyup(function(){
			var pw1=$("#inputPwd").val();
			var pw2=$("#inputPwd2").val();
			if(pw1!=pw2){
				$("#pwdMsg").text("两次密码不一致");
				pwdEqual=false;
				$("#subBtn").attr({"disabled":"disabled"});
			}else{
				$("#pwdMsg").text("");
				pwdEqual=true;
				$("#subBtn").removeAttr("disabled");
			}
			validateUserName();
		});

		$("#inputUsername").keyup(function(){
			validateUserName();
		});

		function validateUserName(){
			if($("#inputUsername").val().length< 3){
				$("#pwdMsg").text("用户名不能小于三位");
				$("#subBtn").attr({"disabled":"disabled"});
			}else{
				$("#pwdMsg").text("");
				$("#subBtn").removeAttr("disabled");
			}
		}
	});
</script>
</html>
