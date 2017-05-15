<%--
  Created by IntelliJ IDEA.
  User: mtf81
  Date: 2017/4/7
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
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
	<style>
		.quiz-container {
			box-shadow: 4px 4px 5px 4px #888888;
			margin-bottom: 20px;
		}
	</style>
	<title>${question.title}</title>
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
				<a class="navbar-brand" href="<%=request.getContextPath()%>/sys/home">weAsk</a>
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
	<div class="container col-xs-12 ">
		<div class="container col-xs-12 quiz-container">
			<h2>${quizViewDto.question.title}</h2>
			<hr>
			<p class="text-muted">${quizViewDto.question.createDate} by ${quizViewDto.asker.username}</p>
			<div>
				${quizViewDto.question.content}
			</div>
			<hr>
			<c:if test="${quizViewDto.question.finishFlag==0}">
				<c:choose>
					<c:when test="${currentUser!=null}">
						<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#answerModal">我要回答</a>
					</c:when>
					<c:otherwise>
						<%--<a href="<%=request.getContextPath()%>/user/login" class="btn btn-default" >请登录回答</a>--%>
						<a href="#" data-toggle="modal" data-target="#loginModal" class="btn btn-default">请登录回答</a>
					</c:otherwise>
				</c:choose>
			</c:if>

		<hr>
		<c:if test="${quizViewDto.choicedAnswer!=null}">
			<legend>最佳回答</legend>
			<p>${quizViewDto.choicedAnswer.answer.createDate} by ${quizViewDto.choicedAnswer.user.username}</p>
			${quizViewDto.choicedAnswer.answer.content}
		</c:if>
		</div>
		<br>
		<hr>
		<legend>所有回答</legend>
		<c:forEach items="${quizViewDto.answers}" var="answerDto">
			<p>${answerDto.answer.createDate} by ${answerDto.user.username}</p>
			${answerDto.answer.content}
			<c:if test="${currentUser.id==quizViewDto.question.userId}">
				<c:if test="${quizViewDto.choicedAnswer==null}">
					<form method="post" action="<%=request.getContextPath()%>/quiz/chooseAnswer">
						<input type="hidden" name="questionId" value="${answerDto.answer.questionId}">
						<input type="hidden" name="replierId" value="${answerDto.answer.userId}">
						<input type="hidden" name="answerId" value="${answerDto.answer.id}">
						<button type="submit" class="btn btn-default">选为最佳</button>
					</form>
				</c:if>
			</c:if>
			<hr/>
		</c:forEach>
		<hr>
		<p>没有更多啦...</p>
	</div>

</div>
<%--loginModal--%>
<div class="modal" id="loginModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
				        aria-hidden="true">&times;</button>
				<h4 class="modal-title">登录</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="inputEmail" class="col-lg-3 control-label">邮箱</label>
					<div class="col-lg-9">
						<input type="email" class="form-control" id="inputEmail" name="email"
						       required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPwd" class="col-lg-3 control-label">密码</label>
					<div class="col-lg-9">
						<input type="password" class="form-control" id="inputPwd" name="password"
						       required="required">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<a href="#" id="modalLoginBtn" class="btn btn-default btn-sm ">登录
				</a>
			</div>
		</div>
	</div>
</div>
<%--回答modal--%>
<form method="post" action="<%=request.getContextPath()%>/quiz/answer">
	<input type="hidden" name="userId" value="${currentUser.id}"/>
	<input type="hidden" name="questionId" value="${quizViewDto.question.id}"/>
	<div class="modal" id="answerModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<h4 class="modal-header">回答</h4>
				<div class="modal-body">
					<textarea id="inputAnswer" style="height: 250px;" name="content">
	                <p>请输入内容...</p>
					</textarea>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">提交</button>
				</div>
			</div>
		</div>
	</div>
</form>

</body>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/static/wangEditor/js/wangEditor.min.js"></script>
<script>
	//init the editor
	var editor = new wangEditor('inputAnswer');
	editor.config.menus = [
		'source',
		'|',
		'bold',
		'underline',
		'italic',
		'strikethrough',
		'eraser',
		'forecolor',
		'|',
		'quote',
		'fontfamily',
		'fontsize',
		'unorderlist',
		'orderlist',
		'|',
		'link',
		'unlink',
		'table',
		'|',
		'img',
		'location',
		'insertcode',
		'|',
		'undo',
		'redo',
	];
	editor.create();
</script>
<script>
	$(function () {

		$("#modalLoginBtn").on("click", function () {
			console.log("onClick");
			var email = $("#inputEmail").val();
			var password = $("#inputPwd").val();
			$.ajax({
				url: '<%=request.getContextPath()%>/user/loginAjax',
				type: 'POST', //GET
				async: true,    //或false,是否异步
				data: {
					'email': email, 'password': password
				},
				success: function (data) {
//					alert(data);
					if (data.msg == "success") {

					} else if (data.msg == "fail") {
						alert("登录失败1");
					}
					location.reload();
				},
				error: function () {
					alert("登录失败0");
					location.reload();
				}
			})
		});
	});
</script>
</html>
