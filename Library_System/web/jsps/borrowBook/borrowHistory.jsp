<%@ page import="model.User" %>
<%@ page import="factory.ServiceFactory" %>
<%@ page import="model.UserOrder" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Book" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
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
    ArrayList<UserOrder> arrUserOrder= (ArrayList<UserOrder>) session.getAttribute("allLentBooksUserOrder");
    ArrayList<Book> arrBooks= (ArrayList<Book>) session.getAttribute("allLentBooks");

    //罚款状态：未缴纳，已缴纳，未还书，未缴纳
    ArrayList<String> fineStates=new ArrayList();
    //逾期天数
    ArrayList<Integer> fineDays=new ArrayList();
    //计算剩余未缴纳罚款总金额
    double sumFineMoney=0;
    //应罚金额
    ArrayList<String> arrFineMoneyPerBook=new ArrayList();
    for(int i=0;i<arrUserOrder.size();i++){
        if(arrUserOrder.get(i).getFineDay()==-1){//未还书
            arrFineMoneyPerBook.add("--");
            fineStates.add("未还书");
            fineDays.add(0);
        }
        else if(arrUserOrder.get(i).getFineDay()==0){//未逾期
            arrFineMoneyPerBook.add("0");
            fineStates.add("未逾期");
            fineDays.add(0);
        }
        else{//已还书
            double m=arrBooks.get(i).getFineMoneyPerDay();
            int d=arrUserOrder.get(i).getFineDay();
            double sum=d*m;
            arrFineMoneyPerBook.add(sum+"");//每本书缴纳的罚款
            fineDays.add(arrUserOrder.get(i).getFineDay());
            //已缴纳---不算在sum money当中
            if(arrUserOrder.get(i).getAlreadyPay()==1){
                fineStates.add("已缴纳");
            }
            else{//未缴纳---计算在sum money当中
                fineStates.add("未缴纳");
                sumFineMoney=sumFineMoney+sum;
            }
        }
    }

    //借出日期
    ArrayList<String> arrBorrowDay=new ArrayList();
    //归还日期
    ArrayList<String> arrReturnDay=new ArrayList();
    for(int i=0;i<arrUserOrder.size();i++){
        java.text.SimpleDateFormat formatter=new SimpleDateFormat( "yyyy-MM-dd ");

        //借出日期转换成字符串
        Date d1=arrUserOrder.get(i).getBorrowTime();
        String str1=formatter.format(d1);
        arrBorrowDay.add(str1);
        //归还日期转换成字符串---注意书籍的借阅状态（未还书："--"，还书）
        if(arrUserOrder.get(i).getFineDay()==-1){//未还书
            arrReturnDay.add("--");
        }
        else{//已还书
            Date d2=arrUserOrder.get(i).getReturnTime();
            String str2=formatter.format(d2);
            arrReturnDay.add(str2);
        }
    }

    session.setAttribute("sumFineMoney", sumFineMoney);
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
                <div>
                    <div class="panel panel-default">
                        <table class="table" id="project">
                            <th>订单ID</th><th>书籍ID</th><th>书名</th><th>借出日期</th><th>归还日期</th><th>逾期天数</th><th>逾期罚款（元/天）</th><th>应罚金额</th><th>罚款状态</th>
                            <%
                                for(int i=0;i<arrUserOrder.size();i++){
                                    out.println("<tr>\n" +
                                            "<td>"+arrUserOrder.get(i).getId()+"</td><td>"+arrBooks.get(i).getId()+"</td>" +
                                            "<td>"+arrBooks.get(i).getName()+"</td><td>"+arrBorrowDay.get(i)+"</td>" +
                                            "<td>"+arrReturnDay.get(i)+"</td><td>"+fineDays.get(i)+"</td>" +
                                            "<td>"+arrBooks.get(i).getFineMoneyPerDay()+"</td><td>"+arrFineMoneyPerBook.get(i)+"</td>" +
                                            "<td>"+fineStates.get(i)+"</td>\n" +
                                            "</tr>");
                                }
                            %>
                        </table>
                    </div>
                </div>
                <hr>
                <div>
                    <div class="one">
                        <b>剩余未缴罚款总金额：</b>
                        <b id="sum_fine_money"><%=sumFineMoney%></b>
                    </div>
                    <div class="two">
                        <form method="post" action="<%=response.encodeURL(request.getContextPath() + "/payFine")%>">
                            <button type="submit" class="btn btn-default" style="alignment: right" onclick="">缴纳罚款</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
