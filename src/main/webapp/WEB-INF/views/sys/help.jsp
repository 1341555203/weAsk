<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%--以上标签必须放在最上 否则无法在移动端正常显示--%>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/wangEditor/css/wangEditor.min.css">
	<title>帮助</title>
</head>
<body>
<div class="container col-lg-8 col-lg-offset-2 ">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
				        data-target="#bs-example-navbar-collapse-2" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=request.getContextPath()%>/sys/home">WeAsk</a>
			</div>

			<div class="navbar-collapse collapse" id="bs-example-navbar-collapse-2" aria-expanded="false"
			     style="height: 1px;">
				<ul class="nav navbar-nav">

					<c:if test="${currentUser!=null}">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
							   aria-expanded="false">${currentUser.username} <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="<%=request.getContextPath()%>/user/account">我的帐号</a></li>
								<li><a href="<%=request.getContextPath()%>/quiz/myQuiz">我的提问</a></li>
								<li><a href="<%=request.getContextPath()%>/quiz/startup">发起提问</a></li>
								<li><a href="<%=request.getContextPath()%>/quiz/answer">我的回答</a></li>

								<li class="divider"></li>
								<li><a href="<%=request.getContextPath()%>/user/signout">注销</a></li>
									<%--<li class="divider"></li>--%>
									<%--<li><a href="#">One more separated link</a></li>--%>
							</ul>
						</li>
					</c:if>
				</ul>
				<%--<form class="navbar-form navbar-left" role="search">--%>
				<%--<div class="form-group">--%>
				<%--<input type="text" class="form-control" placeholder="Search">--%>
				<%--</div>--%>
				<%--<button type="submit" class="btn btn-default">Search</button>--%>
				<%--</form>--%>
				<ul class="nav navbar-nav navbar-right">
					<%--c:if 判断 若已登录则试用dropdown显示当前用户--%>
					<%--<li><a href="<%=request.getContextPath()%>/user/signup">Sign Up<span class="sr-only">(current)</span></a></li>--%>
					<c:if test="${currentUser==null}">
						<li><a href="<%=request.getContextPath()%>/user/login">Sign in</a></li>
					</c:if>
					<li><a href="<%=request.getContextPath()%>/sys/help">help</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container col-xs-12">
		<h2>暂时没有</h2>
	</div>
</div>


</body>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
</html>
