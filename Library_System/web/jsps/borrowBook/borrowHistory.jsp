<%--
  Created by IntelliJ IDEA.
  User: 丁雯雯
  Date: 2019/1/22
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>借阅历史</title>
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
                <div>
                    <div class="panel panel-default">
                        <table class="table" id="project">
                            <th>订单ID</th><th>书籍ID</th><th>书名</th><th>借出日期</th><th>归还日期</th><th>逾期天数</th><th>逾期罚款（元/天）</th><th>应罚金额</th><th>罚款状态</th>
                        </table>
                    </div>
                </div>
                <hr>
                <div>
                    <div class="one">
                        <b>剩余未缴罚款总金额：</b>
                        <b id="sum_fine_money">xxxxxx</b>
                    </div>
                    <div class="two">
                        <button type="button" class="btn btn-default" style="alignment: right" onclick="">缴纳罚款</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
