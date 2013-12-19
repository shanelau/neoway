<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../part/header.jsp" %>
<title>更新手机位置</title>
<%@include file="../part/inc_css.jsp" %>
</head>
<body>
<form name="pointForm" action="findphone/update_status" method="post">
    <input type="text" name="imei" class="" value="864134012306637"/>
    <input type="text" name="motion" value="voice"/>
    <input type="text" name="status" value="open"/>
    <input type="submit" class="pointTo" value="状态"/>
</form>
</body>
</html>