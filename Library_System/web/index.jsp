<%--
  Created by IntelliJ IDEA.
  User: lx
  Date: 2019/1/21
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="jsps/users/Login.jsp">登录</a>
  <form method="post" action="<%=response.encodeURL(request.getContextPath() + "/test")%>">
    <input type="submit" value="input" name="Submit">
  </form>

  <script language="javascript">
      function openmydoc(){
          var doc=new ActiveXObject("Word.Application");
          doc.visible=true;
          doc.Documents.Open("复习暂用.docx");
      }
  </script>
  <input type="button" value="ok" name="b1" onclick="openmydoc()" />
  <!--<a href="复习暂用.docx" type="application/ms-word">打开word </a> -->
  </body>
</html>
