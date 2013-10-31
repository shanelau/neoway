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
    <script type="text/javascript" src="../js/jquery-1.10.2.min.js"></script>
    <script>
        function changeImg() {
            $(".captcha_img").attr("src", "generatImage?code+" + Math.random());
            return false;
        }
        (function ($) {

            $(document).ready(function () {

                var time = $(".error_time").val();
                if (time >= 3) {

                    $("#captcha").append("验证码:<img src='generatImage' class='captcha_img' onclick='javascript:changeImg()'><br/><input type='text' name='captcha_value'/>" +
                            "<a href='javascript:changeImg()'>换一张</a>");
                }


            });
        })($);
    </script>
</head>
<body>
<p>==${error_msg}</p>

<form action="register" method="post">
    用户名:<input type="text" name="username"/> <br/>
    密码:<input type="password" name="password"/><br/>
    邮箱::<input type="email" name="email"/><br/>
    <input type="submit" value="注册"/></form>
</body>
</html>