<%--
  Created by IntelliJ IDEA.
  User: mtf81
  Date: 2017/2/3
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>注册成功</title>
	<meta http-equiv="refresh" content="3;url=<%=request.getContextPath()%>/user/login">
</head>
<body>
注册成功!<br>
正在跳转至
<a href="<%=request.getContextPath()%>/user/login">登录</a>
</body>
</html>
