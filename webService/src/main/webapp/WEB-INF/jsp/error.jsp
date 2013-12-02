<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="feedback/part/header.jsp" %>
<title>错误页面</title>
<%@include file="feedback/part/inc_css.jsp"%>
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
        <p>  <a href="index">返回主页</a><br/><br/></p>

    </div>

</div>

</body>

<!-- END BODY -->

</html>