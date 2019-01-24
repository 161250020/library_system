<%@ page import="model.UserOrder" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lx
  Date: 2019/1/22
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看借阅记录报告其罚款</title>
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
<%
    String username = (String) session.getAttribute("username");
    List<UserOrder> list = (List<UserOrder>) session.getAttribute("userOrder");
%>
<div class="panel panel-info">
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
                        <button type="button" class="button secondary" style="width: 100%" onclick="javascript:location.href='/check_user_data'"><a href="/check_user_data">用户信息</a></button>
                    </li>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%" onclick="javascript:location.href='/check_bollowing'"><a href="/check_bollowing"  style="color: #FF0543">借阅记录</a></button>
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
                    <table class="table" id="project">
                        <tr><th>借阅记录ID</th><th>书籍ID</th><th>用户ID</th><th>借书时间</th><th>还书时间</th><th>超期时间</th><th>逾期天数</th></tr>
                        <%
                            for(int i=0;i<list.size();i++){
                                out.println("<tr>" +
                                                "<td>"+list.get(i).getId()+"</td>"+
                                        "<td>"+list.get(i).getBookId()+"</td><td>"+list.get(i).getUserId()+"</td>" +
                                        "<td>"+list.get(i).getBorrowTime()+"</td><td>"+list.get(i).getReturnTime()+"</td>" +
                                        "<td>"+list.get(i).getFineDay()+"</td><td>"+list.get(i).getAlreadyPay()+"</td>" +
                                        "</tr>");
                            }
                        %>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
