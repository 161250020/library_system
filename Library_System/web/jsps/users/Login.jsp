<%--
  Created by IntelliJ IDEA.
  User: lx
  Date: 2019/1/21
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@page import="model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="../../css/login/style.css" />
</head>
<body>
<div class="login-container">
    <h1>图书管理系统</h1>

    <div class="connect">
        <p>登录</p>
    </div>

    <form action="" method="post" id="loginForm">
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
