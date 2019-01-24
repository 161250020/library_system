<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Book" %>
<%@ page import="model.UserOrder" %>
<%@ page import="model.User" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="otherModels.strategies.lendBooks.Context" %>
<%@ page import="otherModels.strategies.lendBooks.undergraduateStrategy" %>
<%@ page import="otherModels.strategies.lendBooks.postgraduateStrategy" %>
<%@ page import="otherModels.strategies.lendBooks.teacherStrategy" %><%--
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
    <title>在借书籍</title>
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

    ArrayList<Book> arrBooks= (ArrayList<Book>) session.getAttribute("alreadyLentBooks");
    ArrayList<UserOrder> arrUserOrder= (ArrayList<UserOrder>) session.getAttribute("alreadyLentBooksUserOrder");
    User u= (User) session.getAttribute("userInfo");
    ArrayList<String> borrowTimes=new ArrayList();
    for(int i=0;i<arrUserOrder.size();i++){
        Date d=arrUserOrder.get(i).getBorrowTime();
        java.text.SimpleDateFormat formatter=new SimpleDateFormat( "yyyy-MM-dd ");
        borrowTimes.add(formatter.format(d));
    }

    //策略模式获得可借阅时间
    Context con;
    if(u.getType().equals("undergraduate")){
        con=new Context(new undergraduateStrategy());
    }
    else if(u.getType().equals("postgraduate")){
        con=new Context(new postgraduateStrategy());
    }
    else{
        con=new Context(new teacherStrategy());
    }
    int canBorrowTime=con.maxPeriod();
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
                <br><b style="alignment: right">可借阅天数：<%=canBorrowTime%></b>
                <div class="panel panel-default">
                    <table class="table" id="project">
                        <th>书籍ID</th><th>书籍分类</th><th>书名</th><th>作者</th><th>出版设</th><th>借出日期</th>
                        <%
                            for(int i=0;i<borrowTimes.size();i++){
                                out.println("<tr>\n" +
                                        "<td>"+arrBooks.get(i).getId()+"</td><td>"+arrBooks.get(i).getType()+"</td>" +
                                        "<td>"+arrBooks.get(i).getName()+"</td><td>"+arrBooks.get(i).getAuthor()+"</td>" +
                                        "<td>"+arrBooks.get(i).getPublishCompany()+"</td><td>"+borrowTimes.get(i)+"</td>\n" +
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
