<%--
  Created by IntelliJ IDEA.
  User: 丁雯雯
  Date: 2019/1/22
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@page import="model.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="<%=request.getContextPath() + "/css/login/style.css"%>"/>
</head>
<body>
<div class="login-container">
    <h1>图书管理系统</h1>

    <div class="connect">
        <p>登录</p>
    </div>

    <form action="<%=response.encodeURL(request.getContextPath() + "/Login")%>" method="post" id="loginForm">
        <div>
            <input type="text" name="username" class="username" placeholder="用户名" autocomplete="off"/>
        </div>
        <div>
            <input type="password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
        </div>
        <%
            String loginInfo= (String) request.getAttribute("loginInfo");
            if (loginInfo!=null){
                loginInfo="登录提示："+loginInfo;
            }
            else
                loginInfo="";
        %>
        <%=loginInfo%>
        <button type="submit" name="submit" value="login">登 陆</button>
    </form>

</div>
</body>

</html>
