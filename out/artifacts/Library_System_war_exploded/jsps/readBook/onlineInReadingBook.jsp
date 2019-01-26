<%@ page import="model.ElectronicBooks" %>
<%@ page import="otherModels.strategies.readEBooks.Context" %>
<%@ page import="otherModels.strategies.readEBooks.pdfStrategy" %>
<%@ page import="otherModels.strategies.readEBooks.wordStrategy" %>
<%@ page import="model.OnlineReadModule" %>
<%@ page import="java.util.UUID" %>
<%@ page import="changeFileToPDF.Word2Pdf" %><%--
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
    <title>在线阅读书籍</title>
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

    ElectronicBooks ebookInfo=new ElectronicBooks();
    ebookInfo= (ElectronicBooks) session.getAttribute("ebookInfo");
    String path= (String) session.getAttribute("filePath");
    session.setAttribute("ebookInfo",new ElectronicBooks());//获取完电子书的信息就清除

    //通过strategy获得文档阅读器的onlineReadModule
    Context con=new Context(new pdfStrategy());//默认PDF阅读器
    if(ebookInfo.getDocumentFormat().equals("word")){
        con=new Context(new wordStrategy());
    }
    OnlineReadModule onlineReadModule=con.chooseModule();
    String onlineReaderType=onlineReadModule.getDocumentReader();
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
                    <table class="table" id="project">
                        <th>书籍ID</th><th>书籍分类</th><th>书名</th><th>作者</th><th>出版设</th><th>文档格式</th><th>文档阅读器</th>
                        <%
                            out.println("<tr>\n" +
                                    "<td>"+ebookInfo.getId()+"</td><td>"+ebookInfo.getType()+"</td>" +
                                    "<td>"+ebookInfo.getName()+"</td><td>"+ebookInfo.getAuthor()+"</td>" +
                                    "<td>"+ebookInfo.getPublishCompany()+"</td><td>"+ebookInfo.getDocumentFormat()+"</td>" +
                                    "<td>"+onlineReadModule.getDocumentReader()+"</td>\n" +
                                    "</tr>");
                        %>
                    </table>
                    <br>
                    <b>内容如下：</b>
                    <!--在线阅读的内容显示如下-->
                    <div style="height: 500px;background-color: white">
                        <%
                            //如果为pdf类型的文档
                            if(onlineReaderType.equals("pdf的在线阅读器")){
                                out.println("<iframe src=\""+request.getContextPath() + path+"\" width=\"100%\" height=\"500\" scrolling=\"yes\"></iframe>");
                            }
                            else if(onlineReaderType.equals("word的在线阅读器")){
                                //将Word文件转化成PDF文件，然后再显示出来
                                System.out.println("jsps:"+path);

                                //如果上面的那个实现不了，就使用下面的这个
                                out.println("此电子书的路径（可以通过这个获得在线电子书阅读所需要加载的内容）："+path+"\n" +
                                " <br>\n" +
                                " 此电子书的在线阅读器类型（可以通过这个使用不同的在线阅读器加载电子书的内容）："+onlineReaderType+"\n" +
                                " <br>\n" +
                                " 在线多种类型文档阅读......");
                            }
                            else{
                                out.println("<b>此书文件类型非PDF且非Word，无法在线阅读！</b>");
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
