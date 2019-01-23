<%--
  Created by IntelliJ IDEA.
  User: 丁雯雯
  Date: 2019/1/22
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
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
    String username="";

    Cookie[] cookies=request.getCookies();
    Cookie cookie=null;
    if(null!=cookies){
        for(int i=0;i<cookies.length;i++){
            cookie=cookies[i];
            if(cookie.getName().equals("username")){
                username=cookie.getValue();
                break;
            }
        }
    }

    User u= (User) session.getAttribute("userInfo");
    ArrayList<Book> arrBooks= (ArrayList<Book>) session.getAttribute("alreadyLentBooks");

    String books="";
    for(int i=0;i<arrBooks.size();i++){
        books=books+arrBooks.get(i).getName()+";";
    }
%>

<div class="panel panel-info">
    <!--标题-->
    <div class="panel-heading">
        <b class="panel-title">图书馆信息系统</b>
        <!--左边-->
        <div align="right">
            <form method="post" action="<%=response.encodeURL(request.getContextPath() + "/toLoginJSP")%>">
            <b id="b_userId" style="alignment: right">用户名：<%=username%></b>
            <button type="submit" class="btn btn-default" style="alignment: right">退出登录</button>
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
                            <b>个人中心</b>
                        </div>
                    </li>
                    <br>
                    <li><form method="post" action="<%=response.encodeURL(request.getContextPath() + "/userInfo")%>">
                        <button type="submit" class="button secondary" style="width: 100%"><a href="#">个人信息</a></button> </form>
                    </li>
                    <li><form method="post" action="<%=response.encodeURL(request.getContextPath() + "/borrowBooks")%>">
                        <button type="submit" class="button secondary" style="width: 100%"><a href="#">在借书籍</a></button> </form>
                    </li>
                    <li><form method="post" action="<%=response.encodeURL(request.getContextPath() + "/onlineReadBook")%>">
                        <button type="submit" class="button secondary" style="width: 100%"><a href="#">在线阅读</a></button> </form>
                    </li>
                    <li><form method="post" action="<%=response.encodeURL(request.getContextPath() + "/borrowHistory")%>">
                        <button type="submit" class="button secondary" style="width: 100%"><a href="#">借阅历史</a></button> </form>
                    </li>
                    <li><form method="post" action="<%=response.encodeURL(request.getContextPath() + "/editUserInfo")%>">
                        <button type="submit" class="button secondary" style="width: 100%"><a href="#">修改信息</a></button> </form>
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
                            <h5 style="font-family: 仿宋;font-weight: bold">用户ID：</h5>
                        </div>
                        <div class="two">
                            <h5 style="font-family: 仿宋;font-weight: bold"><%=u.getId()%></h5>
                        </div>
                    </div>
                    <br>
                    <div style="height: 40px">
                        <div class="one">
                            <h5 style="font-family: 仿宋;font-weight: bold">用户名：</h5>
                        </div>
                        <div class="two">
                            <h5 style="font-family: 仿宋;font-weight: bold"><%=u.getName()%></h5>
                        </div>
                    </div>
                    <br>
                    <div style="height: 40px">
                        <div class="one">
                            <h5 style="font-family: 仿宋;font-weight: bold">身份：</h5>
                        </div>
                        <div class="two">
                            <h5 style="font-family: 仿宋;font-weight: bold"><%=u.getType()%></h5>
                        </div>
                    </div>
                    <br>
                    <div style="height: 40px">
                        <div class="one">
                            <h5 style="font-family: 仿宋;font-weight: bold">可借最大图书量：</h5>
                        </div>
                        <div class="two">
                            <h5 style="font-family: 仿宋;font-weight: bold"><%=u.getMaxNum()%></h5>
                        </div>
                    </div>
                    <br>
                    <div style="height: 40px">
                        <div class="one">
                            <h5 style="font-family: 仿宋;font-weight: bold">已借图书量：</h5>
                        </div>
                        <div class="two">
                            <h5 style="font-family: 仿宋;font-weight: bold"><%=arrBooks.size()%></h5>
                        </div>
                    </div>
                    <br>
                    <div style="height: 40px">
                        <div class="one">
                            <h5 style="font-family: 仿宋;font-weight: bold">已借图书名：</h5>
                        </div>
                        <div class="two">
                            <h5 style="font-family: 仿宋;font-weight: bold"><%=books%></h5>
                        </div>
                    </div>
                    <br>
                    <div style="height: 40px">
                        <div class="one">
                            <h5 style="font-family: 仿宋;font-weight: bold">可借阅图书最大时长：</h5>
                        </div>
                        <div class="two">
                            <h5 style="font-family: 仿宋;font-weight: bold"><%=u.getMaxPeriod()%></h5>
                        </div>
                    </div>
                    <br>
                    <div style="height: 40px">
                        <div class="one">
                            <h5 style="font-family: 仿宋;font-weight: bold">账户内金额：</h5>
                        </div>
                        <div class="two">
                            <h5 style="font-family: 仿宋;font-weight: bold"><%=u.getMoney()%></h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
