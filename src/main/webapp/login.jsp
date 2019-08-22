<%--
  Created by IntelliJ IDEA.
  User: w-ss
  Date: 2019/8/6
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>shrio测试</h1>
<form action="${pageContext.request.contextPath}/login/login04" method="post">
    用户名：<input type="text" name="uname" placeholder="请输入用户名"><br/>
    密码：<input type="password" name="pwd" placeholder="请输入密码" /></br>
    <input type="submit" value="login">
</form>

</body>
</html>