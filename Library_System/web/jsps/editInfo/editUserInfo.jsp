<%--
  Created by IntelliJ IDEA.
  User: 丁雯雯
  Date: 2019/1/22
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改信息</title>
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
    <!--标题-->
    <div class="panel-heading">
        <b class="panel-title">图书馆信息系统</b>
        <!--左边-->
        <div align="right">
            <b id="b_userId" style="alignment: right">用户名：</b>
            <button type="button" class="btn btn-default" style="alignment: right" onclick="">退出登录</button>
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
                            <b>个人中心</b>
                        </div>
                    </li>
                    <br>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%"><a href="#" onclick="">个人信息</a></button>
                    </li>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%"><a href="#" onclick="">在借书籍</a></button>
                    </li>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%"><a href="#" onclick="">在线阅读</a></button>
                    </li>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%"><a href="#" onclick="">借阅历史</a></button>
                    </li>
                    <li>
                        <button type="button" class="button secondary" style="width: 100%"><a href="#" onclick="">修改信息</a></button>
                    </li>
                </ul>
            </div>

            <!--右边-->
            <div class="col-md-9" style="background-color: white;box-shadow: inset 1px -1px 1px #f7ff62, inset -1px 1px 1px #fff626;height: 70%;">
                <br>
                <br>
                <div class="panel panel-default" align="left">
                    <div style="height: 40px">
                        <div class="one">
                            <h5 style="font-family: 仿宋;font-weight: bold">新用户名：</h5>
                        </div>
                        <div class="two">
                            <input class="form-control" id="new_username">
                        </div>
                    </div>
                    <br>
                    <div style="height: 40px">
                        <div class="one">
                            <h5 style="font-family: 仿宋;font-weight: bold">原密码：</h5>
                        </div>
                        <div class="two">
                            <input type="password" class="form-control" id="pre_pass">
                        </div>
                    </div>
                    <br>
                    <div style="height: 40px">
                        <div class="one">
                            <h5 style="font-family: 仿宋;font-weight: bold">新密码：</h5>
                        </div>
                        <div class="two">
                            <input type="password" class="form-control" id="new_pass">
                        </div>
                    </div>
                    <br>
                    <div style="height: 40px">
                        <div class="one">
                            <h5 style="font-family: 仿宋;font-weight: bold">确认新密码：</h5>
                        </div>
                        <div class="two">
                            <input type="password" class="form-control" id="reInputNew_pass">
                        </div>
                    </div>
                    <br>
                    <br>
                    <div align="center">
                        <button type="button" class="button warning tiny" style="width: 50%" onclick="modify_pass()">确认</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>