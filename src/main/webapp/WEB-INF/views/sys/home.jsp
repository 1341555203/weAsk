<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%--以上标签必须放在最上 否则无法在移动端正常显示--%>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
	<title>weAsk</title>

	<style>
		.list-container {
			margin-top: 20px;
			box-shadow: 4px 4px 5px 4px #888888;
		}

		.questionContent {
			max-height: 200px;
			overflow: hidden;
		}
		/*#myCarousel{*/
			/*width: 100%;*/
			/*height: 400px;*/
			/*text-align: center;*/
		/*}*/
		/*.item{*/
			/*margin: 0 auto 0 auto;*/
		/*}*/
	</style>
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
				<div class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" id="keyWord" required="required" class="form-control" placeholder="Search by..">
					</div>
					<button type="button" id="sTitleBtn" class="btn btn-default">Title</button>
					<button type="button" id="sContentBtn" class="btn btn-default">Content</button>
				</div>
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

	<div id="myCarousel" class="carousel slide">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
			<div class="item active">
				<a href="/sys/help"> <img src="http://www.runoob.com/wp-content/uploads/2014/07/slide1.png" alt="First slide"></a>
			</div>
			<div class="item">
				<img src="http://www.runoob.com/wp-content/uploads/2014/07/slide2.png" alt="Second slide">
			</div>
			<div class="item">
				<img src="http://www.runoob.com/wp-content/uploads/2014/07/slide3.png" alt="Third slide">
			</div>
		</div>
		<!-- 轮播（Carousel）导航 -->
		<a class="carousel-control left" href="#myCarousel"
		   data-slide="prev">&lsaquo;
		</a>
		<a class="carousel-control right" href="#myCarousel"
		   data-slide="next">&rsaquo;
		</a>
	</div>

	<div class="container col col-xs-12 " style="background-color: white">

		<c:forEach items="${allQuiz}" var="question">
			<div class="list-container container col-xs-12">
				<h4>${question.title}</h4>
				<hr>
				<div class="questionContent"
				     data-src="<%=request.getContextPath()%>/quiz/view/${question.id}">${question.content}</div>
				<hr>
				<p>${question.createDate}</p>
					<%--<a href="<%=request.getContextPath()%>/quiz/view/${question.id}" class="btn btn-sm btn-primary">查看</a>--%>
					<%--<hr>--%>
			</div>
		</c:forEach>

	</div>
</div>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
<script>
	$(function () {
		$(".questionContent").on("click", function () {
//			alert(this.dataset.src);
			window.location = this.dataset.src;
		});
		$("#sTitleBtn").on("click",function(){
			var keyWord=$("#keyWord").val();
			window.location = "<%=request.getContextPath()%>/quiz/search/title/"+keyWord;
		});
		$("#sContentBtn").on("click",function(){
			var keyWord=$("#keyWord").val();
			window.location = "<%=request.getContextPath()%>/quiz/search/content/"+keyWord;
		});
	});
</script>
</body>
</html>