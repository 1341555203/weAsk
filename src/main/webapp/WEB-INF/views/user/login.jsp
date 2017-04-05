<%--
  Created by IntelliJ IDEA.
  User: mtf81
  Date: 2017/4/5
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container col-lg-8 col-lg-offset-2 ">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<%=request.getContextPath()%>/sys/home">weAsk</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="<%=request.getContextPath()%>/sys/help">help</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<br>
	<div class="container col-lg-10 col-lg-offset-1">
		<form class="form-horizontal  col-md-4 col-md-offset-1 col-lg-6 col-lg-offset-0" method="post" action="login"
		      style="margin-top: 20px;">
			<fieldset>
				<legend>登录</legend>
				<br>
				<div class="form-group">
					<label for="inputEmail" class="col-lg-3 control-label">邮箱</label>
					<div class="col-lg-9">
						<input type="email" class="form-control" id="inputEmail" name="email" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPwd" class="col-lg-3 control-label">密码</label>
					<div class="col-lg-9">
						<input type="password" class="form-control" id="inputPwd" name="password" required="required">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-8 col-lg-offset-2">
						<button type="submit" class="btn btn-primary">登入<span
								class="glyphicon glyphicon-play"></span></button>
					</div>
				</div>
				<%--<div class="text-right"><a href="<%=request.getContextPath()%>/user/forgot-password">Forgot--%>
				<%--password?</a></div>--%>
			</fieldset>
			<hr>
			<div>
				没有帐号？<br>
				<a href="<%=request .getContextPath()%>/user/signUp">注册</a>
			</div>
		</form>
		<div class="form-horizontal  col-lg-6  col-md-5 hidden-sm hidden-xs">
			<div class="jumbotron">
				<h2>欢迎使用</h2>
				<p>请输入邮箱和密码进行登录<br>
					点击注册链接跳转至注册页面</p>
			</div>
		</div>
	</div>
</div>
</body>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
</html>

