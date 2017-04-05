<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%--以上标签必须放在最上 否则无法在移动端正常显示--%>
	<title>帐号</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
	<style>
		.whitebg{
			background-color:white;
		}
		.breadcrumb li{
			font-size: medium;
		}
		#userIcon img{
			width: 120px;
			height:120px;
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
			<li><a href="<%=request.getContextPath()%>/quiz/my">我的提问</a></li>
			<li><a href="<%=request.getContextPath()%>/quiz/startup">发起提问</a></li>
			<li><a href="<%=request.getContextPath()%>/user/signout">注销</a></li>
		    </ul>
		</legend>
		<div class="col-xs-10 col-xs-offset-1">
			<div id="userIcon">
				<a href="#" data-toggle="modal" data-target="#iconModel">
					<img src="<%=request.getContextPath()%>/image/down/u/${currentUser.id}" />
				</a>
			</div>
			<h1>${currentUser.username}</h1>
			<h3>${currentUser.email}</h3>
			<h3 class="userGender">${currentUser.gender}</h3>
			<h3 class="userType">${currentUser.userType}</h3>
			<hr>
			<a class="btn btn-primary" href="<%=request.getContextPath()%>/user/account/update">修改账户信息</a>
		</div>
	</div>
</div>

<form  methord="POST" enctype="multipart/form-data" id="iconForm">
	<!-- icon modify model -->
	<div class="modal" id="iconModel">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
					        aria-hidden="true">&times;</button>
					<h4 class="modal-title">更改头像</h4>
				</div>
				<div class="modal-body">
					<div id="iconpreview" class="text-center">
						<img id="icon" class=" img-circle" style="height: 120px; width: 120px" src="<%=request.getContextPath()%>/image/down/u/${currentUser.id}" />
					</div>
					<input type="file" name="upImage" id="inputhd"   accept="image/*,">

				</div>
				<div class="modal-footer">
					<button id="selBtn" type="button" class="btn btn-default btn-sm ">选择图片
					</button>
					<button type="button" id="subicon" class="btn btn-primary btn-sm disabled">更新
					</button>
				</div>
			</div>
		</div>
	</div>
</form>

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

		$("#inputhd").hide();
		$("#selBtn").on('click',function(){
			$("#inputhd").click();
		});
		$("#inputhd").on("change",function(){
			var prevDiv = $("#iconpreview");
			if (this.files && this.files[0])
			{
				var reader = new FileReader();
				reader.onload = function(evt){
					prevDiv.html('<img class="img-circle" style="height:120px;width:120px;" src="' + evt.target.result + '" />');
				}
				reader.readAsDataURL(this.files[0]);
				$("#subicon").removeClass("disabled");
			}

			$("#subicon").one("click",function(){

				$.ajax("/image/upload/u/${currentUser.id}", {
					async: false,
					cache: false,
					contentType: false,
					processData: false,
					data : new FormData($("#iconForm")[0]),
					type : 'post',
					success : function(rt) {
						window.location.reload();
					}
				});
			});

		});
	});
</script>
</html>