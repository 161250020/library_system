<%--
  Created by IntelliJ IDEA.
  User: lx
  Date: 2019/1/24
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <link rel="stylesheet" href="../../css/login/style.css" />
</head>
<body>
<div class="login-container">
    <h1>图书管理系统</h1>

    <div class="connect">
        <p>登录</p>
    </div>

    <form action="/admin_login" method="post" id="loginForm">
        <div>
            <input type="text" name="username" class="username" placeholder="用户名" autocomplete="off"/>
        </div>
        <div>
            <input type="password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
        </div>
        <button id="submit" type="submit">登 陆</button>
    </form>
</div>
</body>
</html>
