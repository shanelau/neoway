<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 13-11-20
  Time: 上午10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="part/header.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
           <form action="<%=basePath%>feedback/add" method="post" enctype="multipart/form-data">
               <input name="content" type="text" value="我是内容a"/>
               <input name="version" type="text" value="我是版本b"/>
               <input name="phImei" type="text" value="IMEI"/>
               <input name="typeId" type="text" value="2"/>
               <input name="contact" type="text" value="联系方式"/>
               <input name="imgPath" type="file"/>
               <input name="logPath" type="file"/>
               <input type="submit" value="提交">
           </form>
</body>
</html>