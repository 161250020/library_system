<%@ page import="model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lx
  Date: 2019/1/22
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看用户个人信息</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/foundation/5.5.3/css/foundation.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/foundation/5.5.3/js/foundation.min.js"></script>
    <script src="https://cdn.bootcss.com/foundation/5.5.3/js/vendor/modernizr.js"></script>

    <link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">

    <style rel="stylesheet">
        .yuan{
            width: 100px;
            height: 100px;
            background-color: white;
            border-radius: 50%;
            border:1px solid #ccc;
        }
        .one,.two{
            width: 50%;
            height: 30px;
            float: left;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<div class="panel panel-info">
    <%
    List<User> userList = (List<User>) session.getAttribute("userInfoList");
    String username = (String) session.getAttribute("username");
%>
    <!--标题-->
    <div class="panel-heading">
        <b class="panel-title">图书馆信息系统</b>
        <!--左边-->
        <div align="right">
            <b id="b_userId" style="alignment: right">管理员：<%=username%></b>
            <form method='GET' action="/admin_login">
                <input class="btn btn-default" style="alignment: right" type='submit' name='Logout' value='Logout'>
            </form>
        </div>
    </div>

    <!--内容-->
    <div class="panel-body">
        <div class="row" style="height: 2000px">
            <!--左边-->
            <div class="col-md-3" style="background-color: white;box-shadow: inset 1px -1px 1px #fffb4b, inset -1px 1px 1px #fffe7a;height: 70%;" align="center">
                <ul class="no-bullet">
                    <li>
                        <br>
                        <div class="yuan" align="center">
                            <br>
                            <i class="fa fa-user-o" style="font-size:30px"></i>
                            <br>
                            <b>系统管理</b>
                        </div>
                    </li>
                    <br>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%" onclick="javascript:location.href='/check_user_data'"><a href="/check_user_data" style="color: #FF0543">用户信息</a></button>
                    </li>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%" onclick="javascript:location.href='/check_bollowing'"><a href="/check_bollowing">借阅记录</a></button>
                    </li>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%" onclick="javascript:location.href='/check_bookInfo'"><a href="/check_bookInfo">书籍信息</a></button>
                    </li>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%" onclick="javascript:location.href='/check_user_changed'"><a href="/check_user_changed">用户信息修改记录</a></button>
                    </li>
                </ul>
            </div>

            <!--右边-->
            <div class="col-md-9" style="background-color: white;box-shadow: inset 1px -1px 1px #f7ff62, inset -1px 1px 1px #fff626;height: 70%;">
                <br>
                <br>
                <div class="panel panel-default">
                    <form action="/modify_user" method="get">
                    <table class="table" id="project">
                        <tr><th>用户ID</th><th>用户名</th><th>密码</th><th>类型</th><th>可借本数</th><th>可借天数</th><th>余额</th><th>操作</th></tr>
                        <%
                            for(int i=0;i<userList.size();i++){
                                out.println("<tr>\n" +
                                        "<td>"+userList.get(i).getId()+"</td><td>"+userList.get(i).getName()+"</td>" +
                                        "<td>"+userList.get(i).getPassword()+"</td><td>"+userList.get(i).getType()+"</td>" +
                                        "<td>"+userList.get(i).getMaxNum()+"</td><td>"+userList.get(i).getMaxPeriod()+"</td>" +
                                        "<td>"+userList.get(i).getMoney()+"</td><td><button name='change' type='submit' value='"+userList.get(i).getName()+"'>修改</button></td>" +
                                        "</tr>");
                            }
                        %>
                    </table></form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
