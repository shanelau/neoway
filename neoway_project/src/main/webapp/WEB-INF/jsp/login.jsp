<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 13-9-10
  Time: 下午8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>来登录吧</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
</head>
<body>
<p>==${error_info}</p>
<input class="error_time" value="${error_time}" style="visibility: hidden"/>

<form action="login" method="post">
    用户名:<input type="text" name="username"/> <br/>
    密码:<input type="password" name="password"/><br/>
    <p id="captcha"></p>
    <input type="submit" value="登录"/></form>
<script>
    (function($){
        var time = $(".error_time").val();
        if(time == 1){
            $("#captcha").append("验证码:<img src='generatImage'><br/><input type='text' name='captcha_value'/>" +
                    "<a href=''>换一张试试</a>" );
        }
    })($);
</script>
</body>
</html>