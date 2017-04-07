<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%--以上标签必须放在最上 否则无法在移动端正常显示--%>
	<title>更新个人信息</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
	<style>
		.whitebg{
			background-color:white;
		}
		.breadcrumb li{
			font-size: medium;
		}
	</style>
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
	<div class="container col-xs-12 whitebg">
		<legend>
			<ul class="breadcrumb">
				<li class="active">我的信息</li>
				<li><a href="<%=request.getContextPath()%>/quiz/myQuiz">我的提问</a></li>
				<li><a href="<%=request.getContextPath()%>/quiz/startup">发起提问</a></li>
				<li><a href="<%=request.getContextPath()%>/quiz/answer">我的回答</a></li>
				<li><a href="<%=request.getContextPath()%>/user/signout">注销</a></li>
		    </ul>
		</legend>
		<form:form modelAttribute="currentUser" method="post" role="form" action="/user/account/update">
		<div class="col-xs-10 col-xs-offset-1">
			<form:hidden path="id"/>
			<div class="form-group">
				<label for="inputUsername" class="control-label">用户名</label>
				<form:input cssClass="form-control" id="inputUsername" type="text" path="username" required="required"/>
			</div>
			<h3>${currentUser.email}</h3>
			<form:hidden path="email"/>
			<br>
			<label class="control-label">性别</label>
			<div class="radio">
				<label>
					<form:radiobutton path="gender"  id="optionsRadios1" value="1"/>
					男
				</label>
			</div>
			<div class="radio">
				<label>
					<form:radiobutton path="gender"  id="optionsRadios2" value="0"/>
					女
				</label>
			</div>
			<br>
			<h4 class="userType">${currentUser.userType}</h4>
			<hr>
			<button type="submit" class="btn btn-primary">提交更改</button>
		</div>
		</form:form>
	</div>
</div>
</body>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
<script>
	$(function(){
		var userGender=$('.userGender').text();
		if(userGender!=null){
			if(userGender=='0'){
				$('.userGender').text('女');
			}
			if(userGender=='1'){
				$('.userGender').text('男');
			}
		}
		var userType=$('.userType').text();
		if(userType!=null){
			if(userType=='0'){
				$('.userType').text('普通用户');
			}
			if(userType=='1'){
				$('.userType').text('管理员');
			}
		}
	});
</script>
</html>