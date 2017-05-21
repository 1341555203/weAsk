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
<div class="container " id="msg-box">
	<br>
		<legend class="text-right">与XXX对话 &nbsp;&nbsp;<span id="hide-box" class="glyphicon glyphicon-chevron-up"></span></legend>
		<div id="msg-container" class="list-group">
			<c:forEach items="${messages}" var="msg">
				<a href="#" class="list-group-item">
					<h6 class="list-group-item-heading"><img class="msgIcon"
					                                         src="/image/down/u/${msg.toUserId}"/>&nbsp;[${msg.createDate}]
					</h6>
					<p class="list-group-item-text">${msg.content}</p>
				</a>
			</c:forEach>
		</div>
		<div class="input-group">
			<input id="msg-content" type="text" class="form-control">
    <span class="input-group-btn">
      <button id="send-msg" class="btn btn-default" type="button">发送</button>
    </span>
		</div>

</div>
</body>
</html>
