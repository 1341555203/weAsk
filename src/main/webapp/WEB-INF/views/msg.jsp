<%--
  Created by IntelliJ IDEA.
  User: mtf81
  Date: 2017/5/21
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/msg.css">
</head>
<body>
<div class="container">
	<br>

	<span id="msgCount" class="badge"></span>
	<div id="msg-box">

	</div>
	<div class='input-group'>
		<input id='msg-content' type='text' class='form-control'>
	<span class='input-group-btn'>
			<button id='send-msg' class='btn btn-default' type='button'>发送</button>
	</span>
	</div>

</div>
</body>
<script src="<%=request.getContextPath()%>/static/jquery/1.11.3/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/static/bootstrap/js/bootstrap.min.js"></script>
<script>
//		debugger;
	var toId = ${toUser.id};
	var currentUser = ${currentUser.id};
	$(function () {
		function setMsgCount() {
			if (currentUser != null) {
				var msgCount = 0;
				$.ajax({
					url: '<%=request.getContextPath()%>/msg/count',
					type: 'GET', //GET
					async: false,    //或false,是否异步
					success: function (data) {
						msgCount = data;
						$("#msgCount").html(msgCount);
					},
					error: function () {
						console.log("msg request falied!")
					}
				});
			}
			;
		}

		setMsgCount();
		setInterval(setMsgCount, 1000 * 20);
		var talks;
		function getTalk(toId) {
			$.ajax({
				url: '<%=request.getContextPath()%>/msg/talk/' + toId,
				type: 'GET',
				success: function (data) {
					console.log(data);
					parseTalk(data);
					postList();
				},
				error: function () {
					console.log("gettalk failed");
				}
			});
		};

		function parseTalk(data) {
			console.log("parseTalk");
			var msgBox = $("#msg-box");
			var htmlhead = "<legend class='text-right'>对话 &nbsp;&nbsp;<span id='hide-box' class='glyphicon glyphicon-chevron-up'></span></legend>"
					+ "<div id='msg-container' class='list-group'>";
//					+"<a href='#' class='list-group-item'>"

			var msgUnit = "";
			for ( var i=0;i<data.length;i++) {
				msgUnit += "<h6 class='list-group-item-heading'><img class='msgIcon'"
						+ "src='/image/down/u/" + data[i].fromUserId + "'/>&nbsp;["
//						+ data[i].createDate
                        +"发送的消息："
						+ "]"
						+ "</h6>"
						+ "<h4 class='list-group-item-text'>" + data[i].content + "</h4>"
				+"<hr>";
			}

//			var htmlfooter = "</div>"
//					+ "<div class='input-group'>"
//					+ "<input id='msg-content' type='text' class='form-control'>"
//					+ "<span class='input-group-btn'>"
//					+ "<button id='send-msg' class='btn btn-default' type='button'>发送</button>"
//					+ "</span>"
//					+ "</div>";
//			return htmlhead+msgUnit+htmlfooter;
			$("#msg-box").html(htmlhead+msgUnit);
		};
//		console.log("get talk");
		getTalk(toId);
		function intervalGetTalk(){
			getTalk(toId);

		}
		setInterval(intervalGetTalk,5*1000)
		function postList(){
			console.log("post talks");
			$.ajax({
				url: '<%=request.getContextPath()%>/msg/setRead',
				type: 'GET',
				data:{
					toId:toId
				},
				contentType: "application/json; charset=utf-8",
				success: function (data) {
					console.log(data);
				},
				error: function () {
					console.log("postListWWWWWW failed");
				}
			});
		};

		$("#send-msg").on("click",function(){
			var msg = $("#msg-content");
			var msgStr = msg.val();
			msg.val("");
			if(msgStr!=null){
				var message={
							toUserId:toId,
							content:msgStr
						};
				$.ajax({
					url: '<%=request.getContextPath()%>/msg/send',
					type: 'POST',
					data:JSON.stringify(message),
					contentType: "application/json; charset=utf-8",
					success: function (data) {
						console.log(data);
						getTalk(toId);
					},
					error: function () {
						console.log("send failed");
					}
				});
			}
		});
	});

</script>
</html>
