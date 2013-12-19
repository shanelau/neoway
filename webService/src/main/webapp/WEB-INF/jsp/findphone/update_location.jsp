<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../part/header.jsp" %>
<title>更新手机位置</title>
<%@include file="../part/inc_css.jsp" %>
</head>
<body>
<form name="pointForm" action="findphone/update_location" method="post">
    <input type="text" name="imei" class="" value="864134012306637"/>
    <input type="text" name="pointX" class="pointX" value="115.987055"/>
    <input type="text" name="pointY" class="pointY" value="23.590852"/>
    <input type="submit" class="pointTo" value="更新坐标"/>
</form>
</body>
</html>