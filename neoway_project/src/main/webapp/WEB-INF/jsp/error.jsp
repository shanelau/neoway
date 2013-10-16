<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="inc/header.jsp"%>


<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8"/>
    <title>错误页面</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <!-- END GLOBAL MANDATORY STYLES -->
    <link href="css/error.css" rel="stylesheet" type="text/css"/>
</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-500-full-page">

<div class="row-fluid">

    <div class="span12 page-500">

        <div class="number">

            OOP!

        </div>

        <div class=" details">

            <h2>${msg}.</h2>

        </div>
        <p>  <a href="login">返回主页</a><br/><br/></p>

    </div>

</div>

</body>

<!-- END BODY -->

</html>